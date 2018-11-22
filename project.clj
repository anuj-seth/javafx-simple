(defproject javafx-simple "0.1.0-SNAPSHOT"
  :description "hello javafx"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0-alpha16"]]
  :main javafx-simple.core
  :aot [javafx-simple.core]
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
