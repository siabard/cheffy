(ns app.core
  (:require [reagent.core :as r]
            [reagent.dom :as rd]
            [re-frame.core :as rf]
            ["@smooth-ui/core-sc" :refer [Normalize Button Box]]
            ["styled-components" :refer [ThemeProvider]]
            [app.db]
            [app.router :as router]
            ;; -- auth --
            [app.auth.views.profile :refer [profile]]
            [app.auth.views.sign-up :refer [sign-up]]
            [app.auth.views.log-in :refer [log-in]]
            [app.auth.events]
            [app.auth.subs]
            ;; -- become-a-chef --
            [app.become-a-chef.views.become-a-chef :refer [become-a-chef]]
            ;; -- recipes --
            [app.recipes.events]
            [app.recipes.subs]
            [app.recipes.views.recipes-page :refer [recipes-page]]
            [app.recipes.views.recipe-page :refer [recipe-page]]
            ;; -- inbox
            [app.inbox.views.inboxes :refer [inboxes]]
            ;; -- nav --
            [app.nav.views.nav :refer [nav]]
            [app.nav.events]
            [app.nav.subs]
            [app.theme :refer [cheffy-theme]]))

(defn pages
  [page-name]
  (case page-name
    :profile [profile]
    :sign-up [sign-up]
    :log-in [log-in]
    :become-a-chef [become-a-chef]
    :inboxes [inboxes]
    :recipes [recipes-page]
    :recipe [recipe-page]
    [recipes-page]))

(defn app
  []
  (let [active-page @(rf/subscribe [:active-page])]
    [:<>
     [:> Normalize]
     [:> ThemeProvider {:theme cheffy-theme}
      [:> Box {:mx "auto" :px 20 :maxWidth 800}
       [:> Box {:row true}
        [:> Box {:col true}
         [nav]
         [pages active-page]]]]
      ]]))

(defn ^:dev/after-load start
  []
  (rd/render [app]
             (.getElementById js/document "app")))

(defn ^:export init
  []
  (router/start!)
  (rf/dispatch-sync [:initialize-db])
  (start))
