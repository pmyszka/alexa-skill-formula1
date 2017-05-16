(ns alexa-skill-formula1.next-race-intent-test
  (:require [clojure.test :refer :all]
            [alexa-skill-formula1.test-helper :as th]
            [alexa-skill-formula1.intent.next-race-intent :as intent]
            [clj-time [core :as t]]))

(deftest next-race-intent-test
  (with-redefs-fn { #'alexa-skill-formula1.util/now #(t/date-time 2017 01 01)}
   #(do
      (testing "Testing intent/get-round"
        (is
          (=
            (.getText
              (.getOutputSpeech
                (intent/get-next-race (th/build-session) {})))
            "The next race will be the Australian Grand Prix. It will take place on 2017-03-26"))))))
