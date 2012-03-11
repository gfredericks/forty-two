(ns com.gfredericks.forty-two
  (:require [clojure.string :as s]))


(def ^:private smalls ["zero"
                       "one"
                       "two"
                       "three"
                       "four"
                       "five"
                       "six"
                       "seven"
                       "eight"
                       "nine"
                       "ten"
                       "eleven"
                       "twelve"
                       "thirteen"
                       "fourteen"
                       "fifteen"
                       "sixteen"
                       "seventeen"
                       "eighteen"
                       "nineteen"])

(def ^:private tens ["twenty"
                     "thirty"
                     "forty"
                     "fifty"
                     "sixty"
                     "seventy"
                     "eighty"
                     "ninety"])

(def ^:private magnitudes ["thousand"
                           "million"
                           "billion"
                           "trillion"
                           "quadrillion"
                           "quintillion"
                           "sextillion"
                           "septillion"
                           "octillion"
                           "nonillion"
                           "decillion"
                           "undecillion"
                           "duodecillion"
                           "tredecillion"
                           "quattuordecillion"
                           "quindecillion"
                           "quinquadecillion"
                           "sexdecillion"
                           "sedecillion"
                           "septendecillion"
                           "octodecillion"
                           "novemdecillion"
                           "novendecillion"
                           "vigintillion"
                           #_"centillion"])

(defn words
  [n]
  {:pre [(not (neg? n))]}
  (cond
   (< n 20) (smalls n)
   (< n 100) (let [pre (tens (- (quot n 10) 2)),
                   x (rem n 10)]
               (if (zero? x) pre (str pre "-" (words x))))
   (< n 1000) (let [hun (quot n 100),
                    x (rem n 100),
                    s (str (words hun) " hundred")]
                (if (zero? x) s (str s " and " (words x))))
   :else (loop [parts [] n n mag -1]
           (if (zero? n)
             (s/join " " parts)
             (let [x (rem n 1000)
                   n (quot n 1000)
                   parts (if (zero? x)
                           parts
                           (let [s (words x)]
                             (cons
                              (if (neg? mag)
                                (if (< x 100)
                                  (str "and " s)
                                  s)
                                (str s " " (magnitudes mag)))
                              parts)))]
               (recur parts n (inc mag)))))))