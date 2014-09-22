(defproject clojure-web-intro "0.1"
  :description "Intro to Clojure web apps"

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [ring/ring-core "1.3.1"]
                 [ring/ring-defaults "0.1.1"]
                 [ring/ring-jetty-adapter "1.3.1"]
                 [compojure "1.1.9"]
                 [hiccup "1.0.5"]
                 [stencil "0.3.4"]]

  :profiles {:dev
              {:dependencies
                [[ring/ring-devel "1.3.1"]]}})
