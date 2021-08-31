(ns clj-algo.core-test
  (:require [clojure.test :refer :all]
            [clj-algo.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (zero? 1))))

(deftest test-divisible-sum-pairs
  (testing "Test divisibleSumPairs"
    (let [n        6
          k        3
          ar       [1 3 2 6 1 2]
          expected 5
          actual   (divisibleSumPairs n k ar)]
      (is (= actual expected)))))
