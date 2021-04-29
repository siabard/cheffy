(ns app.components.form-group
  (:require [reagent.core :as r]
            [re-frame.core :as rf]
            ["@smooth-ui/core-sc" :refer [FormField FormFieldLabel Input]]))

(defn form-group
  [{:keys [id label type values]}]
  [:> FormField
   [:> FormFieldLabel {:html-for id} label]
   [:> Input {:id id
              :type type
              :value (id @values)
              :on-change #(swap! values assoc id (.. % -target -value))}]])














