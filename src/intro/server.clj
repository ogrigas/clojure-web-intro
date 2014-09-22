(ns intro.server
  (:require [ring.middleware.defaults :refer :all]
            [ring.adapter.jetty :refer [run-jetty]]
            [intro.routing :as routing])
  (:gen-class))

(defn -main [& [port]]
  (run-jetty (wrap-defaults routing/handler site-defaults)
             {:port (Integer. port)}))
