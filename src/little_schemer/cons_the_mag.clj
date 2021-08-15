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
  [new old lat]
  (cond
    (null? lat)
    '()

    (eq? (car lat) old)
    (cons old (cons new (cdr lat)))

    :else
    (cons (car lat)
          (insertR new old (cdr lat)))))

(defn insertL
  [new old lat]
  (cond
    (null? lat)
    '()

    (eq? (car lat) old)
    (cons new lat)

    :else
    (cons (car lat)
          (insertL new old (cdr lat)))))

(defn subst
  [new old lat]
  (cond
    (null? lat)
    '()

    (eq? (car lat) old)
    (cons new (cdr lat))

    :else
    (cons (car lat)
          (subst new old (cdr lat)))))

(defn subst2
  [new o1 o2 lat]
  (cond
    (null? lat)
    '()

    (or
      (eq? (car lat) o1)
      (eq? (car lat) o2))
    (cons new (cdr lat))

    :else
    (cons (car lat)
          (subst2 new o1 o2 (cdr lat)))))

(defn multirember
  [a lat]
  (cond
    (null? lat)
    '()

    (eq? (car lat) a)
    (multirember a (cdr lat))

    :else
    (cons (car lat) (multirember a (cdr lat)))))

(defn multiinsertR
  [new old lat]
  (cond
    (null? lat)
    '()

    (eq? (car lat) old)
    (cons old (cons new (multiinsertR new old (cdr lat))))

    :else
    (cons (car lat) (multiinsertR new old (cdr lat)))))

(defn multiinsertL
  [new old lat]
  (cond
    (null? lat)
    '()

    (eq? (car lat) old)
    (cons new (cons old (multiinsertL new old (cdr lat))))

    :else
    (cons (car lat) (multiinsertL new old (cdr lat)))))

(defn multisubst
  [new old lat]
  (cond
    (null? lat)
    '()

    (eq? (car lat) old)
    (cons new (multisubst new old (cdr lat)))

    :else
    (cons (car lat) (multisubst new old (cdr lat)))))
