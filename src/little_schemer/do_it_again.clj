(ns little-schemer.do-it-again
  (:require [little-schemer.toys :refer :all]))

(defn lat?
  "Checks is a list is composed only of atoms"
  [l]
  (cond
    (null? l) 'true
    (not (atom? (car l))) 'false
    :else (lat? (cdr l))))

(defn member?
  "Checks if an atom exists in a list"
  [atom lat]
  (cond
    (null? lat) 'false
    :else (or (eq? atom (car lat))
              (member? atom (cdr lat)))))
