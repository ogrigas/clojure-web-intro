(ns intro.controller
  (:require [clojure.java.io :as io]
            [hiccup.core :refer [html]]
            [stencil.core :refer [render-file]]
            [intro.database :as db]))

(defn movie-list []
  (render-file "templates/movie-list.html"
               {:movies @db/movies}))
