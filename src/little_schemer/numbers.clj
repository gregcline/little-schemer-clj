(ns little-schemer.numbers
  (:require [little-schemer.toys :refer :all]))

(defn add1
  "Adds 1 to n"
  [n]
  (+ n 1))

(defn sub1
  "Subtracts 1 from n"
  [n]
  (- n 1))

(defn add
  "Adds two numbers together"
  [n1 n2]
  (loop [n1 n1 n2 n2]
    (if (zero? n1)
      n2
      (recur (sub1 n1) (add1 n2)))))

(defn minus
  "Subtracts one number from another"
  [n1 n2]
  (loop [n1 n1 n2 n2]
    (if (zero? n2)
      n1
      (recur (sub1 n1) (sub1 n2)))))

(defn addtup
  "Sums the numbers in a tuple"
  [tup]
  (loop [tup tup acc 0]
    (if (null? tup)
      acc
      (recur (cdr tup) (add (car tup) acc)))))

(defn multiply
  "Multiplies two numbers"
  [n1 n2]
  (loop [n2 n2 acc 0]
    (if (zero? n2)
      acc
      (recur (sub1 n2) (add n1 acc)))))

(defn tupadd
  "Adds each number in two tups"
  [tup1 tup2]
  (loop [tup1 tup1 tup2 tup2 acc '()]
    (cond
      (and (null? tup1) (null? tup2))
      (reverse acc)
      (null? tup1)
      (concat (reverse acc) tup2)
      (null? tup2)
      (concat (reverse acc) tup1)
      :else
      (recur
        (cdr tup1)
        (cdr tup2)
        (cons
          (add (car tup1) (car tup2))
          acc)))))

; (defn tupadd
;   [tup1 tup2]
;   (if (and (null? tup1) (null? tup2))
;     '()
;     (cons
;       (add
;         (car tup1)
;         (car tup2))
;       (tupadd
;         (cdr tup1)
;         (cdr tup2)))))

(defn greater
  "Tests whether n1 is greater than n2"
  [n1 n2]
  (loop [n1 n1 n2 n2]
    (cond
      (zero? n1) 'false
      (zero? n2) 'true
      :else (recur (sub1 n1) (sub1 n2)))))

(defn less
  "Tests whether n1 is less than n2"
  [n1 n2]
  (loop [n1 n1 n2 n2]
    (cond
      (zero? n2) 'false
      (zero? n1) 'true
      :else (recur (sub1 n1) (sub1 n2)))))

(defn equals
  "Tests whether n1 and n2 are equal"
  [n1 n2]
  (loop [n1 n1 n2 n2]
    (cond
      (and (zero? n1) (zero? n2)) 'true
      (or (zero? n1) (zero? n2)) 'false
      :else (recur (sub1 n1) (sub1 n2)))))

(defn pow
  "Raises n1 to power n2"
  [n1 n2]
  (loop [n2 n2 acc 1]
    (if (zero? n2)
      acc
      (recur (sub1 n2) (multiply acc n1)))))

(defn div
  "Divides n1 by n2"
  [n1 n2]
  (loop [n1 n1 acc 0]
    (if (less n1 n2)
      acc
      (recur (minus n1 n2) (add1 acc)))))

(defn length
  "Counts the number of elements in lat"
  [lat]
  (loop [lat lat acc 0]
    (if (null? lat)
      acc
      (recur (cdr lat) (add1 acc)))))

(defn pick
  "Selects the nth item from the list"
  [n lat]
  (loop [n n lat lat]
    (if (zero? (sub1 n))
      (car lat)
      (recur (sub1 n) (cdr lat)))))

(defn rempick
  "Removes the nth item from the list"
  [n lat]
  (loop [n n lat lat acc '()]
    (if (zero? (sub1 n))
      (concat (reverse acc) (cdr lat))
      (recur (sub1 n) (cdr lat) (cons (car lat) acc)))))

(defn no-nums
  "Removes all the numbers from lat"
  [lat]
  (loop [lat lat acc '()]
    (cond
      (null? lat) (reverse acc)
      (number? (car lat)) (recur (cdr lat) acc)
      :else (recur (cdr lat) (cons (car lat) acc)))))

(defn all-nums
  "Removes all non-numbers from lat"
  [lat]
  (loop [lat lat acc '()]
    (cond
      (null? lat) (reverse acc)
      (not (number? (car lat))) (recur (cdr lat) acc)
      :else (recur (cdr lat) (cons (car lat) acc)))))

(defn eqan?
  "Tests if two atoms are the same"
  [a1 a2]
  (= a1 a2))

(defn occur
  "Counts how many times `a` occurs in `lat`"
  [a lat]
  (loop [lat lat acc 0]
    (cond
      (null? lat) acc
      (eqan? a (car lat)) (recur (cdr lat) (inc acc))
      :else (recur (cdr lat) acc))))
