(ns com.gfredericks.test.forty-two
  (:use clojure.test
        com.gfredericks.forty-two))

(deftest words-test
  (are [n s] (= s (words n))
       0 "zero"
       1 "one"
       6 "six"
       10 "ten"
       11 "eleven"
       18 "eighteen"
       20 "twenty"
       22 "twenty-two"
       99 "ninety-nine"
       100 "one hundred"
       173 "one hundred and seventy-three"
       84894734275 "eighty-four billion eight hundred and ninety-four million seven hundred and thirty-four thousand two hundred and seventy-five"
       80000000004 "eighty billion and four"
       3000000000000 "three trillion"
       1002 "one thousand and two"
       1012 "one thousand and twelve"
       1112 "one thousand one hundred and twelve"
       1100 "one thousand one hundred"))