(ns little-schemer.friends-and-relations-test
  (:require [clojure.test :refer :all]
            [little-schemer.friends-and-relations :refer :all]
            [little-schemer.test-util :refer :all]))

(deftest -set?-test
 (is-false (-set? '(apple peaches apple plum)))
 (is-true (-set? '(apples peaches pears plums)))
 (is-true (-set? '())))

