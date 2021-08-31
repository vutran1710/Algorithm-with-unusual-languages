(ns clj-algo.core)

(defn migratoryBirds
  "Problem at https://www.hackerrank.com/challenges/migratory-birds"
  [arr]

  (let [;; sort from highest to lowest
        sort-ar (sort > arr)
        ;; count occurences of value in vector
        cnt     (frequencies sort-ar)]
    (key (apply max-key val cnt))))

(defn divisibleSumPairs
  "https://www.hackerrank.com/challenges/divisible-sum-pairs1"
  [n k ar]

  (let [divisible? (fn [x1 x2 k]
                     (zero? (mod (+ x1 x2) k)))]
    (reduce-kv
     (fn [cnt idx num]
       (let [sub-ar     (subvec ar (inc idx))
             matches    (filter #(divisible? num % k) sub-ar)
             should-inc (count matches)]
         (+ cnt should-inc)))
     0
     ar)))
