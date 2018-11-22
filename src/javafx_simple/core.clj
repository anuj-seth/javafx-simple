(ns javafx-simple.core
  (:require [clojure.java.io :as io])
  (:import (javafx.event EventHandler)
           (javafx.scene.control Button)
           (javafx.scene.image Image)
           (javafx.scene.layout StackPane)
           (javafx.scene Scene))
  (:gen-class
   :extends javafx.application.Application))

(defn -start
  [app stage]
  (let [btn-event-handler (proxy [EventHandler] []
                            (handle [event] (println "Hello World!")))
        btn (doto (Button.)
              (.setText "Say 'Hello World'")
              (.setOnAction btn-event-handler))
        root (StackPane.)
        scene (Scene. root 300 250)]
    (do
      (.add (.getChildren root) btn)
      (doto stage
        (-> .getIcons
            (.add (Image. (io/input-stream
                           (io/resource "icon.png")))))
        (.setTitle "Hello World !")
        (.setScene scene)
        (.show)))))

(defn -main
  "A direct translation of a javafx sample program to clojure"
  [& args]
  ;; passing the name of our class as the first argument to launch is mandatory.
  ;; if not passed, javafx gives an error that core/-main is not a subclass of
  ;; javafx.application.Application
  (javafx.application.Application/launch javafx_simple.core
                                         (into-array String args)))
