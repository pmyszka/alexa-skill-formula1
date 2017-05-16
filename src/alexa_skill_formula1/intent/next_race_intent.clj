(ns alexa-skill-formula1.intent.next-race-intent
  (:require [clojure.string :as s]
            [com.climate.boomhauer.intent-handler :refer [defintent]]
            [alexa-skill-formula1.client.client :as client]
            [alexa-skill-formula1.util :as u]
            [clj-time.format :as ctf]))

(defn get-next-race [session session-map]
  (let [race (first
              (filter
                #(>
                  (compare
                    (ctf/parse
                      u/default-formatter
                      (str (:date %) " " (:time %)))
                    (u/now))
                  0)
                (client/get-season session session-map (.getYear (u/now)))))
        speech (str "The next race will be the " (:raceName race) ". It will take place on " (:date race))]
      (u/mk-tell-response speech)))

(defintent :NextRaceIntent get-next-race)
