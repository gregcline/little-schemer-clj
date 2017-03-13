(ns little-schemer.toys-test
  (:require [clojure.test :refer :all]
            [little-schemer.toys :refer :all]))

(defmacro is-eq
  [assert1 assert2]
  `(is (= ~assert1 ~assert2)))

(deftest car-test
  (testing "car works correctly"
    (is-eq (car '(a b c)) 'a)
    (is-eq (car '((a b c) d e)) '(a b c))
    (is-eq (car '()) nil)))

(deftest cdr-test
  (testing "cdr works correctly"
    (is-eq (cdr '(a b c)) '(b c))
    (is-eq (cdr '((a b) c d)) '(c d))
    (is-eq (cdr 'a) nil)
    (is-eq (cdr '()) nil)))

(deftest cons-test
  (testing "cons works correctly"
    (is-eq (cons 'b '(a)) '(b a))
    (is-eq (cons 'b '()) '(b))
    (is-eq (cons '(b a) '(c)) '((b a) c))))

(deftest null?-test
  (testing "null? works correctly"
    (is-eq (null? '()) 'true)
    (is-eq (null? '(a)) 'false)
    (is-eq (null? 'a) nil)))

(deftest atom?-test
  (testing "atom? works correctly"
    (is-eq (atom? (car '(Harry had a heap of apples)))
           'true)
    (is-eq (atom? (cdr '(Harry had a heap of apples)))
           'false)
    (is-eq (atom? 7) 'false)
    (is-eq (atom? '()) 'false)))

(deftest eq?-test
  (testing "eq? works correctly"
    (is-eq (eq? 'a 'a) 'true)
    (is-eq (eq? 'a 'b) 'false)
    (is-eq (eq? 6 6) nil)
    (is-eq (eq? '() '()) nil)))
