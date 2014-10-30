(ns user
  (:require [ring.middleware.defaults :refer :all]
            [ring.middleware.reload :refer :all]
            [ring.middleware.stacktrace :refer :all]
            [ring.adapter.jetty :refer [run-jetty]]
            [stencil.loader :as templates]
            [clojure.core.cache :as cache]
            [intro.routing :as routing]))

(def app (-> routing/handler
             (wrap-reload)
             (wrap-stacktrace)
             (wrap-defaults (assoc-in site-defaults
                                      [:security :anti-forgery]
                                      false))))

(defonce jetty (run-jetty #'app {:port 8080 :join? false}))

(defn restart []
  (.stop jetty)
  (.start jetty))

(templates/set-cache (cache/ttl-cache-factory {} :ttl 0))
