(ns app.recipes.views.recipe-page
  (:require [app.components.page-nav :refer [page-nav]]
            [app.recipes.views.recipe-info :refer [recipe-info]]
            ["@smooth-ui/core-sc" :refer [Box] ]
            [re-frame.core :as rf]))

(defn recipe-page
  []
  (let [{:keys [name]} @(rf/subscribe [:recipe])]
    [:> Box
     [page-nav {:center name}]
     [:> Box
      [:> Box {:row true}
       [:> Box {:col true
                :xs 12
                :sm 6}
        [:> Box {:pb 20}
         [recipe-info]]
        [:> Box {:pb 20}
         "recipe-image"]
        ]
       [:> Box {:col true
                :xs 12
                :sm 6}
        [:> Box {:pb 20}
         "recipe-steps"]]]]]))




















