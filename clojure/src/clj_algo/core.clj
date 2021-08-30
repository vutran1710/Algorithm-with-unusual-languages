(ns clj-algo.core)

(defn migratoryBirds
  "Problem at https://www.hackerrank.com/challenges/migratory-birds."
  [arr]

  (let [;; sort from highest to lowest
        sort-ar (sort > arr)
        ;; count occurences of value in vector
        cnt     (frequencies sort-ar)]
    (key (apply max-key val cnt))))
