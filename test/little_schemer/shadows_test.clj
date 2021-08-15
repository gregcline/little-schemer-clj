(ns little-schemer.shadows-test
  (:require [clojure.test :refer :all]
            [little-schemer.shadows :refer :all]
            [little-schemer.test-util :refer :all]))

(deftest numbered?-test
  (is-true (numbered? 1))
  (is-true (numbered? '(3 + (4 ↑ 5))))
  (is-false (numbered? '(2 * sausage))))

(deftest value-test
  (is-eq (value 13) 13)
  (is-eq (value '(+ 1 3)) 4)
  (is-eq (value '(+ 1 (↑ 3 4))) 82))
