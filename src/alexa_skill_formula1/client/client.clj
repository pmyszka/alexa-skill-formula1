(ns alexa-skill-formula1.client.client
  (:require [alexa-skill-formula1.client.ergastapi :as api]))

(defn ^:private cache-in-session-map [session session-map data cache-key]
  (.setAttribute session (str cache-key) data)
  (assoc session-map (keyword cache-key) data))

(defn ^:private lookup-entity [session session-map f key]
  (let [cache-key (apply str (interpose "-" key))]
    (if-let [cached-val ((keyword cache-key) session-map)]
      cached-val
      ((keyword cache-key) (cache-in-session-map session session-map (apply f key) cache-key)))))

(defn get-season [session session-map year]
  (lookup-entity session session-map api/get-season [year]))

(defn get-round [session session-map year round]
  (lookup-entity session session-map api/get-round [year round]))

(defn get-race [session session-map year title]
  (let [races (get-season session session-map year)
        race (filter #(= (.toLowerCase (:raceName %)) (.toLowerCase (str title))) races)]
      (when-not (empty? race)
        (get-round session session-map year (apply :round race)))))

