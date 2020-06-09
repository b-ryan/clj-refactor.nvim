(ns ^:figwheel-always clj-refactor.main-test
    (:require [cljs.nodejs :as nodejs]
              [cljs.test :refer-macros [run-tests]]
              [clj-refactor.edit-test :as et]
              [clj-refactor.transform-test :as tt]))

(nodejs/enable-util-print!)

(defn -main []
  (run-tests 'clj-refactor.edit-test
             'clj-refactor.transform-test))

(set! *main-cli-fn* -main)

#_(require 'cljs.repl.node)
#_(cider.piggieback/cljs-repl (cljs.repl.node/repl-env))
