(ns clj-algo.algo-2
  (:require [clojure.spec.alpha :as s]))

(defn queenAttackSearch [queen bounds obstacles direction]
  (let [[x0 y0 x1 y1]      bounds
        [h v]              direction
        [queen-x  queen-y] queen
        x                  (atom (+ queen-x h))
        y                  (atom (+ queen-y v))
        cnt                (atom 0)]
    (while (and
            (s/int-in-range? x0 (inc x1) @x)
            (s/int-in-range? y0 (inc y1) @y)
            (not (contains? obstacles (str @x "_" @y))))
      (reset! cnt (inc @cnt))
      (reset! x (+ @x h))
      (reset! y (+ @y v)))
    @cnt))

(defn queensAttack [n k r_q c_q obstacles]
  (let [obs-set    (set (map #(str (nth % 0) "_" (nth % 1)) obstacles))
        queen-cord [r_q c_q]
        bounds     [1 1 n n]
        result     (atom 0)]
    (doseq [x (range -1 2)
            y (range -1 2)]
      (when-not (= x y 0)
        (reset! result
                (+
                 (queenAttackSearch queen-cord bounds obs-set [x y])
                 @result))))
    @result))
