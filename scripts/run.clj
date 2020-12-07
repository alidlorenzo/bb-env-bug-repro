#!/usr/bin/env bb

(require '[babashka.process :as proc])
(require '[clojure.tools.cli :as cli])

(def cli-opts
  [["-M" "--main-aliases ALIASES" "Forward aliases to clojure main command."]
   ["-h" "--help" "Print help instructions." :default false]])

(defn- handle-cli
  "Handle main cli command `f`."
  [f]
  (let [args *command-line-args*
        {:keys [arguments options summary]} (cli/parse-opts args cli-opts)]
    (if (:help options)
      (println summary)
      (f arguments options))))

(handle-cli
 (fn [_ _]
   (-> (proc/process
        ["clj"]
        {:inherit true
         :dir "./"
         ;; -- NOTE passing :env map throws error, commenting :env out makes command work.
         :env {}
         :shutdown #(.destroy %)})
       (proc/check))))
