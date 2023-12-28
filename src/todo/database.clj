(ns todo.database
 (:require [korma.db :as korma]))

(def db-connection-info
 (korma/sqlite3 {:db "src/todo/db/sqlite.db"}))

(korma/defdb db db-connection-info)