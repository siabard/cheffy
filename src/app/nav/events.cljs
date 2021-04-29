(ns app.nav.events
  (:require [re-frame.core :refer [reg-event-db]]))

(reg-event-db
 :set-active-nav ;; (rf/dispatch [:set-active-nav :saved])
 (fn [db [_ active-nav]]
   (assoc-in db [:nav :active-nav] active-nav)))
