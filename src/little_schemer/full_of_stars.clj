(ns little-schemer.full-of-stars
  (:require [little-schemer.toys :refer :all]
            [little-schemer.numbers :refer :all]))

(defn rember*
  "Removes `a` from all levels of `l` recursively"
  [a l]
  (loop [l l acc '()]
    (cond
      (null? l) (reverse acc)
      (= a (car l)) (recur (cdr l) acc)
      (seq? (car l)) (recur (cdr l) (cons (rember* a (car l)) acc))
      :else (recur (cdr l) (cons (car l) acc)))))

(defn insertR*
  "Inserts `new` to the right of `old` in `l` recursively"
  [new old l]
  (loop [l l acc '()]
    (cond
      (null? l) (reverse acc)
      (= old (car l)) (recur (cdr l) (cons new (cons old acc)))
      (seq? (car l)) (recur (cdr l) (cons (insertR* new old (car l)) acc))
      :else (recur (cdr l) (cons (car l) acc)))))

(defn occur*
  "Finds how many occuances of `a` are in `l` recursively"
  [a l]
  (loop [l l acc 0]
    (cond
      (null? l) acc
      (= a (car l)) (recur (cdr l) (inc acc))
      (seq? (car l)) (recur (cdr l) (+ (occur* a (car l)) acc))
      :else (recur (cdr l) acc))))

(defn subst*
  "Replaces `old` with `new` in all recursive levels of `l`"
  [new old l]
  (loop [l l acc '()]
    (cond
      (null? l) (reverse acc)
      (= old (car l)) (recur (cdr l) (cons new acc))
      (seq? (car l)) (recur (cdr l) (cons (subst* new old (car l)) acc))
      :else (recur (cdr l) (cons (car l) acc)))))

(defn insertL*
  "Inserts `new` to the left of `old` in `l` recursively"
  [new old l]
  (loop [l l acc '()]
    (cond
      (null? l) (reverse acc)
      (= old (car l)) (recur (cdr l) (cons old (cons new acc)))
      (seq? (car l)) (recur (cdr l) (cons (insertL* new old (car l)) acc))
      :else (recur (cdr l) (cons (car l) acc)))))

(defn member*
  "Finds if `a` exists in `l` recursively"
  [a l]
  (loop [l l]
    (cond
      (null? l) 'false
      (= a (car l)) 'true
      (seq? (car l)) (member* a (car l))
      :else (recur (cdr l)))))

(defn leftmost
  "Finds the leftmost atom in `l`"
  [l]
  (loop [l l]
    (cond
      (atom? (car l)) (car l)
      :else (recur (car l)))))

(declare equal?)

(defn eqlist?
  "Tests whether two lists are equal recursively"
  [l1 l2]
  (loop [l1 l1 l2 l2]
    (cond
      (and (null? l1) (null? l2))
      'true

      (or (null? l1) (null? l2))
      false

      :else
      (and (equal? (car l1) (car l2))
           (eqlist? (cdr l1) (cdr l2))))))

(defn equal?
  "Tests whether two S-expressions are equal"
  [s1 s2]
  (cond
    (and (atom? s1) (atom? s2))
    (eqan? s1 s2)

    (or (atom? s1) (atom? s2))
    false

    :else (eqlist? s1 s2)))
