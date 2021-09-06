(ns clj-algo.core-test
  (:require [clojure.test :refer :all]
            [clj-algo.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (zero? 0))))

(deftest test-divisible-sum-pairs
  (testing "Test divisibleSumPairs"
    (let [n        6
          k        3
          ar       [1 3 2 6 1 2]
          expected 5
          actual   (divisibleSumPairs n k ar)]
      (is (= actual expected)))))

(deftest test-picking-numbers
  (is (= (pickingNumbers [4 6 5 3 3 1]) 3))
  (is (= (pickingNumbers [1 1 1]) 3))
  (is (= (pickingNumbers [1 1 1 3]) 3))
  (is (= (pickingNumbers [1 2 2 3 1 2]) 5)))

(deftest test-saveThePrisoner
  (is (= (saveThePrisoner 5 2 1) 2))
  (is (= (saveThePrisoner 5 2 2) 3))
  (is (= (saveThePrisoner 7 19 2) 6))
  (is (= (saveThePrisoner 3 7 3) 3))
  (is (= (saveThePrisoner 2 576581 1) 1))
  (is (= (saveThePrisoner 46934 543563655 46743) 20809))
  (is (= (saveThePrisoner 436776012 436776012 436776011) 436776010))
  (is (= (saveThePrisoner 3 1 2) 2)))
