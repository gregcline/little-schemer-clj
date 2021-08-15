(ns little-schemer.friends-and-relations
  (:require [little-schemer.toys :refer :all]
            [little-schemer.do-it-again :refer :all]
            [little-schemer.cons-the-mag :refer :all]))

(defn -set?
  [lat]
  (cond
    (null? lat) true
    (member? (car lat) (cdr lat)) false
    :else (-set? (cdr lat))))

(defn make-set
  [lat]
  (cond
    (null? lat) '()
    :else (cons (car lat)
                (multirember (car lat)
                             (make-set (cdr lat))))))

(defn subset?
  [set1 set2]
  (cond
    (null? set1) true
    :else (and
            (member? (car set1) set2)
            (subset? (cdr set1) set2))))

(defn eqset?
  [set1 set2]
  (and (subset? set1 set2)
       (subset? set2 set1)))
