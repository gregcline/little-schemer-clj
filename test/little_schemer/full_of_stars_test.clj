(ns little-schemer.full-of-stars-test
  (:require [clojure.test :refer :all]
            [little-schemer.full-of-stars :refer :all]
            [little-schemer.test-util :refer [is-eq is-true is-false]]))

(deftest rember*-test
  (testing "removes a from all levels of the list recursively"
    (is-eq (rember* 'cup '((coffee) cup ((tea) cup)
                           (and (hick) cup)))
           '((coffee) ((tea)) (and (hick))))))

(deftest insertR*-test
  (testing "adds new to the right of every old recursively"
    (is-eq (insertR* 'roast 'chuck '((how much (wood))
                                     could
                                     ((a (wood) chuck))
                                     (((chuck)))
                                     (if (a) ((wood chuck)))
                                     could chuck wood))
          '((how much (wood))
            could
            ((a (wood) chuck roast))
            (((chuck roast)))
            (if (a) ((wood chuck roast)))
            could chuck roast wood))))

(deftest occur*-test
  (testing "finds how many occurances of a are in l recursively"
    (is-eq (occur* 'a '(a b ((a (a c)) b (a))))
           4)
    (is-eq (occur* 'a '(b c ((d (e )) b)))
           0)))

(deftest subst*-test
  (testing "replaces new with old in l recursively"
    (is-eq (subst* 'orange 'banana '((banana)
                                     (split ((((banana ice)))
                                             (cream (banana))
                                             sherbet))
                                     (banana)
                                     (bread)
                                     (banana brandy)))
           '((orange)
             (split ((((orange ice)))
                     (cream (orange))
                     sherbet))
             (orange)
             (bread)
             (orange brandy)))))

(deftest insertL*-test
  (testing "inserts new to the left of old in l recursively"
    (is-eq (insertL* 'pecker 'chuck '((how much (wood))
                                      could
                                      ((a (wood) chuck))
                                      (((chuck)))
                                      (if (a) ((wood chuck)))
                                      could chuck wood))
           '((how much (wood))
             could
             ((a (wood) pecker chuck))
             (((pecker chuck)))
             (if (a) ((wood pecker chuck)))
             could pecker chuck wood))))

(deftest member*-test
  (testing "member* finds if a is in l recursively"
    (is-true (member* 'a '(b (((c (a)) d)))))
    (is-false (member* 'a '(b (((c d))) e)))))

(deftest leftmost-test
  (testing "leftmost finds the leftmost atom in l"
    (is-eq (leftmost '((((a))) b)) 'a)
    (is-eq (leftmost '(b)) 'b)))

(deftest eqlist?-test
  (testing "elist? tests whether two lists are equal recursively"
    (is-true (eqlist? '(a ((b) c) d) '(a ((b) c) d)))
    (is-false (eqlist? '(a ((b) c) d) '(a ((c) c) d)))))
