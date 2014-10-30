(ns intro.controller
  (:import (java.io ByteArrayInputStream)
           (java.util UUID))
  (:require [clojure.java.io :as io]
            [hiccup.core :refer [html]]
            [stencil.core :refer [render-file]]
            [intro.database :as db]))

(defn movie-list []
  (render-file "templates/movie-list.html"
               {:movies @db/movies}))

(defn- find-movie [id]
  (first (filter #(= (:id %) id) @db/movies)))

(defn movie-details [id]
  (when-let [movie (find-movie id)]
    (render-file "templates/movie-details.html" movie)))

(defn movie-poster [id]
  (when-let [movie (find-movie id)]
    (ByteArrayInputStream. (:poster movie))))

(defn movie-form []
  (render-file "templates/new-movie.html" {}))

(defn create-movie [title year director]
  (let [id (.toString (UUID/randomUUID))]
    (swap! db/movies conj {:id       id
                           :title    title
                           :year     year
                           :director director})
    id))
