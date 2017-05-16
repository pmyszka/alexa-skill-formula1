(ns alexa-skill-formula1.race-results-intent-test
  (:require [clojure.test :refer :all]
            [alexa-skill-formula1.test-helper :as th]
            [alexa-skill-formula1.intent.race-results-intent :as intent]))

(deftest race-results-intent-test
  (testing "Testing intent/get-race-results"
    (is
      (=
        (.getText
          (.getOutputSpeech
            (intent/get-race-results (th/build-session) {:race "Canadian Grand Prix" :year 2008})))
        "Canadian Grand Prix was won by Robert Kubica, followed by Nick Heidfeld and David Coulthard.")))

  (testing "Testing not existing intent/get-race-results"
    (is
      (=
        (.getText
          (.getOutputSpeech
            (intent/get-race-results (th/build-session) {:race "Polish Grand Prix" :year 2000})))
        "Sorry, I wasn't able to find any information about this race."))))
