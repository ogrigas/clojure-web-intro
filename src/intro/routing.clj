(ns intro.routing
  (:require [clojure.java.io :as io]
            [clojure.pprint :refer [pprint]]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.util.response :as resp]
            [intro.controller :as controller]))

(def handler
  (routes
    (GET "/" []
         (resp/redirect "/movie-list"))
    (GET "/movie-list" []
         (controller/movie-list))
    (route/not-found "Oops! Not Found")))
