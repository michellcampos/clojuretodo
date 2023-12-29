(defproject todo "0.1.0"
  :description "This is a basic Create, Read, Update, and Delete (CRUD) application."
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [compojure "1.6.1"]
                 [ring/ring-defaults "0.3.2"]
                 [ring/ring-json "0.4.0"]
                 [ring/ring-core "1.9.6"]
                 [korma "0.4.3"]
                 [org.xerial/sqlite-jdbc "3.32.3"]]
  :plugins [[lein-ring "0.12.5"]]
  :ring {:handler todo.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.2"]]}})
