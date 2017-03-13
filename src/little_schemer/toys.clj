(ns little-schemer.toys
  (:gen-class))

(defn car
  [l]
  (first l))

(defn- -cdr
  [l]
  (case l
    (()) nil
    (rest l)))

(defn cdr
  [l]
  (cond
    (seq? l) (-cdr l)
    :else nil))

(defn null?
  [l]
  (cond
    (seq? l) (empty? l)
    :else nil))

(defn atom?
  [item]
  (not (or (seq? item)
           (null? item)
           (number? item))))

(defn eq?
  [atom1 atom2]
  (if (and (atom? atom1) (atom? atom2))
    (= atom1 atom2)
    nil))
