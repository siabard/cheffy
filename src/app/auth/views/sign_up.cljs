(ns app.auth.views.sign-up
  (:require [reagent.core :as r]
            [re-frame.core :as rf]
            [app.components.page-nav :refer [page-nav]]
            [app.components.form-group :refer [form-group]]
            [app.router :as router]
            ["@smooth-ui/core-sc" :refer [Box Button Form FormField FormFieldLabel Input]]))

(defn sign-up
  []
  (let [initial-value {:first-name "" :last-name "" :email "" :password ""}
        values (r/atom initial-value)]
    (fn []
      [:> Box
       [:> Box {:row true :justify-content "center"}
        [:> Box {:col true :xs 12 :sm 6}
         [page-nav {:center "Sign up"}]
         [:> Form
          [form-group {:id :first-name
                       :label "First name"
                       :type "text"
                       :values values}]
          [form-group {:id :last-name
                       :label "Last name"
                       :type "text"
                       :values values}]
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
             [:a {:href (router/path-for :log-in)
                  :on-click #(rf/dispatch [:set-active-page :log-in])}
              "Aleady have ac account? Log in!"]]]
           [:> Button {:on-click #(rf/dispatch [:sign-up @values])} "Sign in"]
           ]]]]])))
