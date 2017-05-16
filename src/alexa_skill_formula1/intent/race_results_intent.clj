(ns alexa-skill-formula1.intent.race-results-intent
  (:require [clojure.string :as s]
            [com.climate.boomhauer.intent-handler :refer [defintent]]
            [alexa-skill-formula1.client.client :as client]
            [alexa-skill-formula1.util :as u]
            [clj-time.format :as ctf]))

(defn get-race-results [session session-map]
  (let [year (:year session-map)
        race (:race session-map)]
      (if-let [results (:Results (into {} (client/get-race session session-map year race)))]
        (let [drivers (sort-by #(Integer/parseInt (:position %)) results)
              top-drivers (map #(str (:givenName (:Driver %)) " " (:familyName (:Driver %))) (take 3 drivers))
              speech (str race " was won by ")]
          (u/mk-tell-response (apply str [speech (first top-drivers) ", followed by " (second top-drivers) " and " (last top-drivers) "."])))
        (u/mk-tell-response "Sorry, I wasn't able to find any information about this race."))))

(defintent :RaceResultsIntent get-race-results)
