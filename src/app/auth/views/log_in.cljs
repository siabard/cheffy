(ns app.auth.views.log-in
  (:require [reagent.core :as r]
            [re-frame.core :as rf]
            [app.components.page-nav :refer [page-nav]]
            [app.components.form-group :refer [form-group]]
            [app.router :as router]
            ["@smooth-ui/core-sc" :refer [Box Button Form FormField FormFieldLabel Input]]))

(defn log-in
  []
  (let [initial-value {:email "" :password ""}
        values (r/atom initial-value)]
    (fn []
      [:> Box
       [:> Box {:row true :justify-content "center"}
        [:> Box {:col true :xs 12 :sm 6}
         [page-nav {:center "Log in"}]
         [:> Form
          [form-group {:id :email
                       :label "email"
                       :type "email"
                       :values values}]
          [form-group {:id :password
                       :label "Password"
                       :type "password"
                       :values values}]
          [:> FormField {:row true}
           [:> Box {:col true
                    :display "flex"
                    :justify-content "space-between"}
            [:> Box {:py 1
                     :pr 2}
             [:a {:href (router/path-for :sign-up)
                  :on-click #(rf/dispatch [:set-active-nage :sign-up])}
             "New to Cheffy? Create an account!"]]]
           [:> Button {:on-click #(rf/dispatch [:log-in @values])} "Log in"]
           ]]]]])))
