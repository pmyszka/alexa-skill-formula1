(ns alexa-skill-formula1.formula1-speechlet-request-handler
  (:gen-class
    :name alexa_skill_formula1.Formula1SpeechletRequestHandler
    :extends com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler
    :init "init"
    :constructors {[] [com.amazon.speech.speechlet.Speechlet java.util.Set]})

  (:use [alexa-skill-formula1.intent.next-race-intent]
        [alexa-skill-formula1.intent.race-results-intent])

  (:import [com.climate.boomhauer BoomhauerSpeechlet]))

(defn -init []
  [[(BoomhauerSpeechlet.), #{}] nil])
