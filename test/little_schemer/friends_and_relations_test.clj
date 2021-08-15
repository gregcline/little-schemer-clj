(ns little-schemer.friends-and-relations-test
  (:require [clojure.test :refer :all]
            [little-schemer.friends-and-relations :refer :all]
            [little-schemer.test-util :refer :all]))

(deftest -set?-test
 (is-false (-set? '(apple peaches apple plum)))
 (is-true (-set? '(apples peaches pears plums)))
 (is-true (-set? '()))
 (is-false (-set? '(apple 3 pear 4 9 apple 3 4))))

(deftest make-set-test
  (is-eq (make-set '(apple peach pear peach plum apple lemon peach))
         '(apple peach pear plum lemon))
  (is-eq (make-set '(apple 3 pear 4 9 apple 3 4))
         '(apple 3 pear 4 9)))

(deftest subset?-test
  (is-true (subset? '(5 chicken wings)
                    '(5 hamburgers 2 pieces fried chicken
                      and light duckling wings)))
  (is-false (subset? '(4 pounds of horseradish)
                     '(four pounds chicken and 5 ounces horseradish))))

(deftest eqset?-test
  (is-true (eqset? '(6 large chickens with wings)
                   '(6 chickens with large wings)))
  (is-false (eqset? '(6 large chickens with wings)
                    '(6 large chickens with wings and tail))))

