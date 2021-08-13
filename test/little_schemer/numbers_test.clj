(ns little-schemer.numbers-test
  (:require [clojure.test :refer :all]
            [little-schemer.numbers :refer :all]
            [little-schemer.test-util :refer [is-eq is-true is-false]]))

(deftest add1-test
  (testing "add1 adds 1"
    (is-eq (add1 1) 2)
    (is-eq (add1 20) 21)))

(deftest sub1-test
  (testing "sub1 subtracts 1"
    (is-eq (sub1 1) 0)
    (is-eq (sub1 20) 19)))

(deftest add-test
  (testing "add works correctly"
    (is-eq (add 100 100) 200)
    (is-eq (add 46 12) 58)))

(deftest minus-test
  (testing "minus works correctly"
    (is-eq (minus 14 3) 11)
    (is-eq (minus 17 9) 8)))

(deftest addtup-test
  (testing "addtup sums the numbers in a tup"
    (is-eq (addtup '(3 5 2 8)) 18)
    (is-eq (addtup '(15 6 7 12 3)) 43)))

(deftest multiply-test
  (testing "multiply multiplies two numbers"
    (is-eq (multiply 5 3) 15)
    (is-eq (multiply 13 4) 52)))

(deftest tupadd-test
  (testing "tupadd should add each number in two tups"
    (is-eq (tupadd '(3 6 9 11 4) '(8 5 2 0 7))
           '(11 11 11 11 11))
    (is-eq (tupadd '(2 3) '(4 6))
           '(6 9))
    (is-eq (tupadd '(2 3) '(4 6 10))
           '(6 9 10))
    (is-eq (tupadd '(2 3 10) '(4 6))
           '(6 9 10))))

(deftest greater-test
  (testing "Greater works correctly"
    (is-false (greater 12 133))
    (is-true (greater 133 12))
    (is-false (greater 133 133))))

(deftest less-test
  (testing "Less works correctly"
    (is-true (less 4 6))
    (is-false (less 8 3))
    (is-false (less 6 6))))

(deftest equals-test
  (testing "Equals works correctly"
    (is-true (equals 1 1))
    (is-false (equals 1 2))
    (is-false (equals 2 1))))

(deftest pow-test
  (testing "pow raises numbers to the right power"
    (is-eq (pow 1 1) 1)
    (is-eq (pow 2 3) 8)
    (is-eq (pow 5 3) 125)))

(deftest div-test
  (testing "div does integer division of n1 by n2"
    (is-eq (div 5 1) 5)
    (is-eq (div 15 3) 5)))

(deftest length-test
  (testing "length counts the elements in a list"
    (is-eq (length '(a b c d e f)) 6)
    (is-eq (length '()) 0)
    (is-eq (length '(a a a)) 3)))

(deftest pick-test
  (testing "pick selects the nth item"
    (is-eq (pick 4 '(a b c d e)) 'd)
    (is-eq (pick 1 '(a b)) 'a)))

(deftest rempick-test
  (testing "rempick removes an item at n from lat"
    (is-eq (rempick 3 '(a b c d)) '(a b d))))

(deftest no-nums-test
  (testing "no-nums removes all nums from lat"
    (is-eq (no-nums '(a 1 b 2 c 3)) '(a b c))
    (is-eq (no-nums '(a b c)) '(a b c))
    (is-eq (no-nums '(1 2 3)) '())))

(deftest all-nums-test
  (testing "removes all non-numbers from the lat"
    (is-eq (all-nums '(1 a 2 b 3 c)) '(1 2 3))
    (is-eq (all-nums '(1 2 3)) '(1 2 3))
    (is-eq (all-nums '(a b c)) '())))

(deftest eqan?-test
  (testing "checks if two atoms are equal"
    (is-true (eqan? 'a 'a))
    (is-true (eqan? 1 1))
    (is-false (eqan? 'a 'b))
    (is-false (eqan? 'a 1))
    (is-false (eqan? 1 2))))

(deftest occur-test
  (testing "counts how many times a is in lat"
    (is-eq (occur 'a '(a b a c a)) 3)
    (is-eq (occur 1 '(a 1 b 1)) 2)
    (is-eq (occur 'c '(a b d)) 0)))
