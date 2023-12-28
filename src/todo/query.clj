(ns todo.query
  (:require [todo.database]
            [korma.core :refer :all]))

(defentity items)

;; Retrieves all todos from the database.
(defn get-todos []
  (select items))

;; Adds a new todo to the database.
;;
;; title - The title of the todo.
;; description - The description of the todo.
(defn add-todo [title description]
  (insert items
          (values {:title title :description description})))

;; Deletes a todo from the database.
;;
;; id - The ID of the todo to delete.
(defn delete-todo [id]
  (delete items
          (where {:id [= id]})))

;; Updates a todo in the database.
;;
;; id - The ID of the todo to update.
;; title - The new title of the todo.
;; is-complete - The new completion status of the todo.
(defn update-todo [id title is-complete]
  (update items
          (set-fields {:title title
                       :is_complete is-complete})
          (where {:id [= id]})))

;; Retrieves a specific todo from the database.
;;
;; id - The ID of the todo to retrieve.
(defn get-todo [id]
  (first
    (select items
            (where {:id [= id]}))))
