(ns little-schemer.cons-the-mag
  (:require [little-schemer.toys :refer :all]))

; (defn rember
;   "Removes the first instance of `atom` from the `lat`"
;   [atom lat]
;   (cond
;     (null? lat)
;     '()
;     (eq? (car lat) atom)
;     (cdr lat)
;     :else
;     (cons (car lat) (rember atom (cdr lat)))))

(defn rember
  "Removes the first instance of `atom` from the `lat`"
  [atom lat]
  (loop [lat lat acc '()]
    (cond
      (null? lat)
      (reverse acc)
      (eq? (car lat) atom)
      (concat (reverse acc) (cdr lat))
      :else
      (recur (cdr lat) (cons (car lat) acc)))))

; (defn firsts
;   "Takes the first element of each sublist in a list"
;   [l]
;   (cond
;     (null? l) '()
;     :else (cons (car (car l))
;                 (firsts (cdr l)))))

(defn firsts
  "Takes the first element of each sublist in a list"
  [l]
  (loop [l l acc '()]
    (cond
      (null? l)
      (reverse acc)
      :else
      (recur (cdr l)
             (cons (car (car l)) acc)))))

(defn insertR
  "Takes a new element and inserts it to the right of the old in the list"
  [new old l]
  (cond
    (null? l) '()
    (eq? (car l) old) (cons old (cons new (cdr l)))
    :else (cons (car l) (insertR new old (cdr l)))))

; (defn insertR
;   "Takes a new element and inserts it to the right of the old in the list"
;   [new old l]
;   (loop [l l acc '()]
;     (cond
;       (null? l)
;       (reverse acc)
;       (eq? (car l) old)
;       (reverse (cons old (cons new acc)))
;       :else
;       (recur (cdr l) (cons (car l) acc)))))

(defn insertL
  "Takes a new element and inserts it to the left of the old one"
  [new old l]
  (cond
    (null? l) '()
    (eq? (car l) old) (cons new l)
    :else (cons (car l) (insertL new old (cdr l)))))

(defn subst
  "Takes a new element and replaces the old element with the new"
  [new old l]
  (cond
    (null? l) '()
    (eq? (car l) old) (cons new (cdr l))
    :else (cons (car l) (subst new old (cdr l)))))

(defn subst2
  "Takes a new element and two old elements, replacing the first old it finds with new"
  [new o1 o2 l]
  (cond
    (null? l)
    '()
    (or (eq? (car l) o1)
        (eq? (car l) o2))
    (cons new (cdr l))
    :else
    (cons (car l) (subst2 new o1 o2 (cdr l)))))

(defn multirember
  "Removes all instances of the atom from the list"
  [atom l]
  (cond
    (null? l) '()
    (eq? (car l) atom) (multirember atom (cdr l))
    :else (cons (car l) (multirember atom (cdr l)))))

(defn multiinsertR
  "Adds new to the right of each instance of old"
  [new old l]
  (cond
    (null? l)
    '()
    (eq? (car l) old)
    (cons old
      (cons new
        (multiinsertR new old (cdr l))))
    :else
    (cons (car l)
      (multiinsertR new old (cdr l)))))

(defn multiinsertL
  "Inserts new to the left of each instance of old"
  [new old l]
  (cond
    (null? l)
    '()
    (eq? (car l) old)
    (cons new
      (cons old
        (multiinsertL new old
          (cdr l))))
    :else
    (cons (car l)
      (multiinsertL new old (cdr l)))))

(defn multisubst
  "Substitutes all instances of old with new"
  [new old l]
  (cond
    (null? l)
    '()
    (eq? (car l) old)
    (cons new
      (multisubst new old (cdr l)))
    :else
    (cons (car l)
      (multisubst new old (cdr l)))))
