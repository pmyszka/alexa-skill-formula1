(ns alexa-skill-formula1.client-test
  (:require [clojure.test :refer :all]
            [alexa-skill-formula1.test-helper :as th]
            [alexa-skill-formula1.client.client :as client]))

(deftest client-test
  (testing "Testing client/get-round"
    (is
      (=
        (apply :raceName
          (client/get-round (th/build-session) {} 2016 1))
        "Australian Grand Prix")))

  (testing "Testing cached client/get-round"
    (is
      (=
        (apply :raceName
          (client/get-round (th/build-session) {:2016-1 [{:raceName "Cached Australian Grand Prix"}]} 2016 1))
        "Cached Australian Grand Prix")))

  (testing "Testing client/get-season"
    (is
      (=
        (count
          (client/get-season (th/build-session) {} 2016))
        21)))

  (testing "Testing cached client/get-season"
    (is
      (=
        (count
          (client/get-season (th/build-session) {:2016 [{:a "a" :b "b"},{:c "c" :d "d"}]} 2016))
        2)))

  (testing "Testing client/get-race"
    (is
      (=
        (apply :round
          (client/get-race (th/build-session) {} 2016 "Canadian Grand Prix"))
        "7")))

  (testing "Testing cached client/get-race"
    (is
      (=
        (apply :round
          (client/get-race (th/build-session) {:2016-7 [{:round "cached"}]} 2016 "Canadian Grand Prix"))
        "cached"))))
