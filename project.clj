(defproject little_schemer "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.0"]]
  :main nil
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  :plugins [[cider/cider-nrepl "0.24.0"]])
