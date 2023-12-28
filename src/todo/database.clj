(ns todo.database
 (:require [korma.db :as korma]))

;; This namespace provides functions for interacting with the database.

(def db-connection-info
 (korma/sqlite3 {:db "src/todo/db/sqlite.db"}))

(korma/defdb db db-connection-info)