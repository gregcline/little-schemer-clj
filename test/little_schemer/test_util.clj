(ns little-schemer.test-util
  (:require [clojure.test :refer :all]))

(defmacro is-eq
  [assert1 assert2]
  `(is (= ~assert1 ~assert2)))

(defmacro is-true
  [assert]
  `(is (= ~assert true)))

(defmacro is-false
  [assert]
  `(is (= ~assert false)))
