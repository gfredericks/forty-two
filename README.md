# forty-two

forty-two is a tiny Clojure library that converts non-negative integers
into english words, up to but not including 10<sup>66</sup>.

## Usage

In the `project.clj`: `[com.gfredericks/forty-two "1.0.0"]`

In the code:

```clojure
(ns foo.bar
  (:use [com.gfredericks.forty-two :only [words]]))

(assert (= (words 98254) "ninety-eight thousand two hundred and fifty-four"))
```

## License

Copyright (C) 2012 Gary Fredericks

Distributed under the Eclipse Public License, the same as Clojure.
