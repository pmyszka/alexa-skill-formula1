(ns alexa-skill-formula1.util
  (:require [clj-time.format :as ctf])
  (:import [com.amazon.speech.speechlet SpeechletResponse]
           [com.amazon.speech.ui PlainTextOutputSpeech]))

(def default-formatter (ctf/formatter "yyyy-MM-dd HH:mm:ssZ"))

(defn now []
  (org.joda.time.DateTime. (java.util.Date.)))

(defn mk-plain-speech
  [text]
  (doto
    (PlainTextOutputSpeech.) (.setText text)))

(defn mk-tell-response
  [text]
  (SpeechletResponse/newTellResponse (mk-plain-speech text)))

