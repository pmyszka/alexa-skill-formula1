(ns alexa-skill-formula1.test-helper
  (:import [com.amazon.speech.speechlet IntentRequest SessionStartedRequest SessionStartedRequest$Builder
                                        IntentRequest$Builder Session$Builder Session SessionEndedRequest
                                        SessionEndedRequest$Builder LaunchRequest LaunchRequest$Builder]
           [com.amazon.speech.slu Intent Slot Slot$Builder Intent$Builder]))

(defn build-session
  []
  (let [builder ^Session$Builder (Session/builder)]
    (.withSessionId builder "session id")
    (.build builder)))
