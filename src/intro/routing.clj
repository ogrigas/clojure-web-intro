(ns intro.routing
  (:require [clojure.java.io :as io]
            [clojure.pprint :refer [pprint]]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.util.response :as resp]
            [intro.controller :as controller]))

(defn handler [req]
  {:status 200})
