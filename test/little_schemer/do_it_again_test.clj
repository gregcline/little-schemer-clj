(ns little-schemer.do-it-again-test
  (:require [clojure.test :refer :all]
            [little-schemer.do-it-again :refer :all]
            [little-schemer.test-util :refer [is-eq is-true is-false]]))

(deftest lat?-test
  (testing "does lat? work correctly"
    (is-true (lat? '(Jack Sprat could eat no chicken fat)))
    (is-false (lat? '((Jack) Sprat could eat no chicken fat)))
    (is-false (lat? '(Jack Sprat could eat (no) chicken fat)))
    (is-true (lat? '()))))

(deftest member?-test
  (testing "does member? work correctly"
    (is-true (member? 'a '(a b c d)))
    (is-true (member? 'c '(a b c d)))
    (is-false (member? 'a '(b c d)))
    (is-false (member? 'a '()))))
