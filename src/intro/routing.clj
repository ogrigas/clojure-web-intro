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
    (GET "/movie/:id" [id]
         (controller/movie-details id))
    (GET "/movie/:id/poster" [id]
         (when-let [image (controller/movie-poster id)]
           (resp/content-type (resp/response image) "image/jpeg")))
    (GET "/new-movie" []
         (controller/movie-form))
    (POST "/create-movie" [title year director]
          (let [id (controller/create-movie title year director)]
            (resp/redirect (str "/movie/" id))))
    (route/not-found "Oops! Not Found")))
