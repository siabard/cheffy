(ns app.auth.subs
  (:require [re-frame.core :as rf]))

(rf/reg-sub
 :logged-in?
 (fn [db _]
   (boolean (get-in db [:auth :uid]))))

(rf/reg-sub
 :user-profile
 (fn [db _]
   (let [uid (get-in db [:auth :uid])]
     (get-in db [:users uid :profile]))))

(rf/reg-sub
 :user
 (fn [db _]
   (let [uid (get-in db [:auth :uid])]
     (get-in db [:users uid]))))
