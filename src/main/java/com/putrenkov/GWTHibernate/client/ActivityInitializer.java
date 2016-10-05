package com.putrenkov.GWTHibernate.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.inject.Inject;
import com.putrenkov.GWTHibernate.client.views.AppLayout;

/**
 * This class is responsible for ActivityManager instantiations through GIN
 *
 */
public class ActivityInitializer {

    @Inject
    public ActivityInitializer(AppLayout appPanelView, ActivityManager activityManager) {
	activityManager.setDisplay(appPanelView.getMainConteiner());
    }
}
