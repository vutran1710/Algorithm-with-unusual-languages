(ns clj-algo.core)

;; Supporting functions
(defn abs
  [n]
  (max n (- n)))

(defn find-first
  [f coll]
  (first (filter f coll)))

;; Solutions
(defn migratoryBirds
  "Problem at https://www.hackerrank.com/challenges/migratory-birds"
  [arr]

  (let [;; sort from highest to lowest
        sort-ar (sort > arr)
        ;; count occurences of value in vector
        cnt     (frequencies sort-ar)]
    (key (apply max-key val cnt))))

(defn divisibleSumPairs
  "https://www.hackerrank.com/challenges/divisible-sum-pairs"
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

(defn bonAppetit
  "https://www.hackerrank.com/challenges/bon-appetit/problem"

  [bill k b]
  (let [total-cost (reduce + bill)
        anna-share (/ (- total-cost (nth bill k)) 2)
        diff       (- b anna-share)
        output     (if (zero? diff) "Bon Appetit" diff)]
    (println output)))

(defn pickingNumbers
  "https://www.hackerrank.com/challenges/picking-numbers/problem"
  [a]

  (let [occur   (frequencies a)
        keyes   (sort < (keys occur))
        indexes (range (dec (count keyes)))]
    (if (= 1 (count keyes))
      (first (vals occur))
      (reduce
       (fn [res i]
         (let [k1   (nth keyes i)
               k2   (nth keyes (inc i))
               v1   (get occur k1)
               v2   (get occur k2)
               cnt  (+ v1 v2)
               diff (abs (- k1 k2))]
           (cond
             (= 1 diff) (max res cnt)
             (< 1 diff) (max v1 v2 res))))
       0
       indexes))))

(defn permutationEquation
  "https://www.hackerrank.com/challenges/permutation-equation/problem"
  [p]

  (let [x (range 1 (inc (count p)))]
    (map
     (fn [v]
       (let [ix (find-first #(= (nth p (dec %)) v) x)
             ex (find-first #(= (nth p (dec %)) ix) x)]
         ex))
     x)))

(defn saveThePrisoner
  "https://www.hackerrank.com/challenges/save-the-prisoner/problem
  Dmm hoi anh Hieu!!! Review sin cos Math"
  [n m s]
  (inc (mod (+ s m -2) n)))

(defn minimumNumber
  "https://www.hackerrank.com/challenges/strong-password/problem"
  [n password]
  (let [count-upper-chars (atom 0)
        count-lower-chars (atom 0)
        count-numberic    (atom 0)
        count-special     (atom 0)
        check-char        (reduce
                           (fn [res char]
                             (cond
                               (and
                                (zero? @count-lower-chars)
                                (re-find #"[a-z]" (str char)))
                               (do
                                 (reset! count-lower-chars 1)
                                 (dec res))

                               (and
                                (zero? @count-upper-chars)
                                (re-find #"[A-Z]" (str char)))
                               (do
                                 (reset! count-upper-chars 1)
                                 (dec res))

                               (and
                                (zero? @count-numberic)
                                (re-find #"[0-9]" (str char)))
                               (do
                                 (reset! count-numberic 1)
                                 (dec res))

                               (and
                                (zero? @count-special)
                                (clojure.string/includes?  "!@#$%^&*()-+" (str char)))
                               (do
                                 (reset! count-special 1)
                                 (dec res))

                               :default res))
                           4 password)
        missing-count (if (>= (count password) 6)
                        0 (- 6 (count password)))]

    (max missing-count check-char)))
