(ns app.nav.views.authenticated
  (:require ["@smooth-ui/core-sc" :refer [Box]]
            [reagent.core :as r]
            [re-frame.core :as rf]
            [app.router :as router]
            [app.nav.views.nav-item :refer [nav-item]]))

(defn authenticated
  []
  (let [active-page @(rf/subscribe [:active-page])
        nav-items [{:id :saved
                    :name "Saved"
                    :href (router/path-for :saved)
                    :dispatch #(rf/dispatch [:set-active-nav :saved])}
                   {:id :recipes
                    :name "Recipes"
                    :href (router/path-for :recipes)
                    :dispatch #(rf/dispatch [:set-active-nav :recipes])}
                   {:id :inboxes
                    :name "Inbox"
                    :href (router/path-for :inboxes)
                    :dispatch #(rf/dispatch [:set-active-nav :inboxes])}
                   {:id :become-a-chef
                    :name "Chef"
                    :href (router/path-for :become-a-chef)
                    :dispatch #(rf/dispatch [:set-active-nav :become-a-chef])}
                   {:id :profile
                    :name "Profile"
                    :href (router/path-for :profile)
                    :dispatch #(rf/dispatch [:set-active-nav :profile]) }
                  ]]
    [:> Box {:display "flex"
             :justify-content "flex-end"
             :py 1}
     (for [{:keys [id name href dispatch]} nav-items]
       [nav-item {:key id
                  :id id
                  :name name
                  :href href
                  :active-page active-page
                  :dispatch dispatch}])]))
