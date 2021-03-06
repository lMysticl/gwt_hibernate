package com.putrenkov.GWTHibernate.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.putrenkov.GWTHibernate.client.gin.AppGin;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class HelloGWTHibernate implements EntryPoint {

    private final AppGin injector = GWT.create(AppGin.class);

    @Override
    public void onModuleLoad() {
	AppController appController = injector.getAppController();
	appController.launchApp();
    }
}
