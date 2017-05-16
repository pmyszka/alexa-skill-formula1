(defproject alexa-skill-formula1 "0.1.0-SNAPSHOT"
  :description "Alexa Formula 1 skill"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [
                  [com.climate/boomhauer "0.1.1"]
                  [com.amazon.alexa/alexa-skills-kit "1.2"]
                  [cheshire "5.5.0"]
                  [clj-time "0.13.0"]
                  [org.clojure/clojure "1.8.0"]
                  [proto-repl "0.3.1"]]
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  :aot [alexa-skill-formula1.formula1-speechlet-request-handler])
