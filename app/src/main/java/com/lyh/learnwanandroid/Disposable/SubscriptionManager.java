package com.lyh.learnwanandroid.Disposable;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class SubscriptionManager implements SubscriptionHelper<Object> {
    public static SubscriptionManager subscriptionManager;
    private CompositeDisposable mDisposables;

    public SubscriptionManager() {
        if (mDisposables == null) {
            mDisposables = new CompositeDisposable();
        }
    }
    @Override
    public void add(Disposable subscription) {
        if (subscription == null) return;
        mDisposables.add(subscription);
    }

    @Override
    public void cancel(Disposable t) {
        if (mDisposables != null) {
            mDisposables.delete(t);
        }
    }

    @Override
    public void cancelall() {
        if (mDisposables != null) {
            mDisposables.clear();
        }
    }

    public static SubscriptionManager getInstance() {
        if (subscriptionManager == null) {
            synchronized (SubscriptionManager.class) {
                if (subscriptionManager == null) {
                    subscriptionManager = new SubscriptionManager();
                }
            }
        }
        return subscriptionManager;
    }
}
