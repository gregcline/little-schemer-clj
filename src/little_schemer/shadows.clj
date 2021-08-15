(ns little-schemer.shadows
  (:require [little-schemer.toys :refer :all]
            [little-schemer.numbers :refer :all]))

(defn numbered?
  [aexp]
  (cond
    (atom? aexp) (number? aexp)
    :else (and (numbered? (car aexp))
               (numbered? (car (cdr (cdr aexp)))))))

(defn operator
  [aexp]
  (car aexp))

(defn first-sub-expr
  [aexp]
  (car (cdr aexp)))

(defn second-sub-expr
  [aexp]
  (car (cdr (cdr aexp))))

(defn value
  [aexp]
  (cond
    (and (atom? aexp) (number? aexp)) aexp
    (eq? (operator aexp) '+) (add (value (first-sub-expr aexp))
                                  (value (second-sub-expr aexp)))
    (eq? (operator aexp) '*) (multiply (value (first-sub-expr aexp))
                                       (value (second-sub-expr aexp)))
    (eq? (operator aexp) '↑) (pow (value (first-sub-expr aexp))
                                  (value (second-sub-expr aexp)))))

