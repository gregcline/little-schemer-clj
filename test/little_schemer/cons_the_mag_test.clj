(ns little-schemer.cons-the-mag-test
  (:require [clojure.test :refer :all]
            [little-schemer.cons-the-mag :refer :all]
            [little-schemer.test-util :refer [is-eq]]))

(deftest rember-test
  (testing "rember works correctly"
    (is-eq (rember 'mint '(lamb chops and mint jelly)) '(lamb chops and jelly))
    (is-eq (rember 'a '(a b c a d)) '(b c a d))
    (is-eq (rember 'a '(b c d)) '(b c d))
    (is-eq (rember 'a '(d c b a)) '(d c b))))

(deftest firsts-test
  (testing "firsts works correctly"
    (is-eq (firsts '((a b) (b c) (c d))) '(a b c))
    (is-eq (firsts '()) '())
    (is-eq (firsts '((a b) (c) ((c)))) '(a c (c)))
    (is-eq (firsts '(((a b) c) (d) ((e) f)))
           '((a b) d (e)))))

(deftest insertR-test
  (testing "insertR works correctly"
    (is-eq (insertR 'a 'b '(a b c d))
           '(a b a c d))
    (is-eq (insertR 'e 'd '(a b c d))
           '(a b c d e))
    (is-eq (insertR 'a 'd '(a b c))
           '(a b c))))

(deftest insertL-test
  (testing "insertL works correctly"
    (is-eq (insertL 'a 'b '(a b c d))
           '(a a b c d))
    (is-eq (insertL 'a 'b '(a c d))
           '(a c d))))

(deftest subst-test
  (testing "subst works correctly"
    (is-eq (subst 'a 'b '(a b c d))
           '(a a c d))
    (is-eq (subst 'a 'b '(a c d))
           '(a c d))))

(deftest subst2-test
  (testing "subst2 works correctly"
    (is-eq (subst2 'a 'b 'c '(a c b d))
           '(a a b d))
    (is-eq (subst2 'a 'b 'c '(a b c d))
           '(a a c d))))

(deftest multirember-test
  (testing "multirember works correctly"
    (is-eq (multirember 'a '(a b a c a d))
           '(b c d))
    (is-eq (multirember 'a '(b c d e))
           '(b c d e))))

(deftest multiinsertR-test
  (testing "multiinsertR works correctly"
    (is-eq (multiinsertR 'a 'b '(a b c b))
           '(a b a c b a))
    (is-eq (multiinsertR 'a 'b '(a c d))
           '(a c d))))

(deftest multiinsertL-test
  (testing "multiinsertL works correctly"
    (is-eq (multiinsertL 'a 'b '(a b c b))
           '(a a b c a b))
    (is-eq (multiinsertL 'a 'b '(a c d))
           '(a c d))))

(deftest multisubst-test
  (testing "multisubst works correctly"
    (is-eq (multisubst 'a 'b '(a b c b))
           '(a a c a))
    (is-eq (multisubst 'a 'b '(a c d))
           '(a c d))))
