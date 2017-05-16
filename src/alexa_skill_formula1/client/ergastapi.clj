(ns alexa-skill-formula1.client.ergastapi
  (:require [cheshire.core :as json]))

(def ^:private api-endpoint "http://ergast.com/api/f1/")

(def ^:private json-nodes [:MRData :RaceTable :Races])

(defn get-season [year]
  (let [url (str api-endpoint year ".json")
        data (slurp url)]
      (get-in (json/parse-string data true) json-nodes)))

(defn get-round [year round]
  (let [url (str api-endpoint year "/" round "/results" ".json")
        data (slurp url)]
      (get-in (json/parse-string data true) json-nodes)))
