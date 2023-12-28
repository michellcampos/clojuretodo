(ns todo.database
  (:require [korma.db :as korma]))

(def db-connection-info
  (korma/mysql
    {:classname   ""
     :subprotocol ""
     :user        ""
     :subname     ""}))

(korma/defdb db db-connection-info)