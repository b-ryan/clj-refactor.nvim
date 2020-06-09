(defproject clj-refactor "0.1.1"
  :description ""
  :url ""
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/clojurescript "1.10.748"]
                 [org.clojure/core.async "1.1.587" :exclusions [org.clojure/tools.reader]]
                 [rewrite-cljs "0.4.5" :exclusions [org.clojure/tools.reader]]
                 [cljfmt "0.6.7"]]
  :source-paths ["src"]
  :test-paths ["test"]
  :clean-targets ["rplugin/node/clj-refactor" "target"]
  :profiles {:dev {:dependencies [[cider/piggieback "0.5.0"]]
                   :plugins [[cider/cider-nrepl "0.25.2"]
                             [lein-cljsbuild "1.1.8"]]
                   :repl-options {:nrepl-middleware [cider.piggieback/wrap-cljs-repl]}}}
  :cljsbuild {:builds [{:id "plugin"
                        :source-paths ["src"]
                        :compiler {:main clj-refactor.main
                                   :asset-path "rplugin/node/clj-refactor/build/"
                                   :hashbang false
                                   :output-to "rplugin/node/clj-refactor/compiled.js"
                                   :output-dir "rplugin/node/clj-refactor/build/"
                                   :language-in :ecmascript6
                                   :optimizations :simple
                                   :target :nodejs
                                   :pretty-print true
                                   :cache-analysis true
                                   :source-map "rplugin/node/clj-refactor/compiled.js.map"}}
                       {:id "test"
                        :source-paths ["src" "test"]
                        :compiler {:main clj-refactor.main-test
                                   :output-to "target/out/tests.js"
                                   :output-dir "target/out"
                                   :target :nodejs
                                   :optimizations :none
                                   :source-map true}}]})
