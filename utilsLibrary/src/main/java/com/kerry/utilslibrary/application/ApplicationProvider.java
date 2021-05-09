package com.kerry.utilslibrary.application;

import android.content.Context;
import android.content.res.Resources;

public class ApplicationProvider implements IApplicationProvider {
    private static volatile ApplicationProvider sInstance;

    private IApplicationProvider mProvider;

    public void init(IApplicationProvider provider) {
        this.mProvider = provider;
    }

    public static ApplicationProvider getInstance() {
        if (sInstance == null) {
            synchronized (ApplicationProvider.class) {
                if (sInstance == null) {
                    sInstance = new ApplicationProvider();
                }
            }
        }

        return sInstance;
    }

    @Override
    public Context getProviderAppContext() {
        return mProvider.getProviderAppContext();
    }

    @Override
    public Resources getProviderAppResources() {
        return mProvider.getProviderAppResources();
    }
}
