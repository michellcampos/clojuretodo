(ns todo.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.json :as json]
            [ring.util.response :refer [response]]
            [todo.query :refer :all]))

;; This namespace defines the handler for the todo application.
;; It includes routes for handling HTTP requests related to todos.

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/api/todos" [] (response (get-todos)))
  (POST "/api/todos" {params :params}
    (let [title (:title params)
          description (:description params)]
      (add-todo title description)
      (response {:status "success"})))
  (route/not-found "Not Found"))

(def app
  (-> app-routes
      (wrap-defaults (assoc site-defaults :security false))
      (json/wrap-json-response)
      (json/wrap-json-params)))
