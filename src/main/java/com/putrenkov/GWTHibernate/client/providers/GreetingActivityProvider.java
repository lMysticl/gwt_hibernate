package com.putrenkov.GWTHibernate.client.providers;

import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.putrenkov.GWTHibernate.client.activities.GreetingActivity;
import com.putrenkov.GWTHibernate.client.resources.messages.Messages;
import com.putrenkov.GWTHibernate.client.services.LogInServiceAsync;
import com.putrenkov.GWTHibernate.client.util.AppUtil;
import com.putrenkov.GWTHibernate.client.views.GreetingView;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GreetingActivityProvider implements Provider<GreetingActivity> {

    private final GreetingView greetingView;
    private final PlaceController placeController;
    private final Messages messages;
    private final LogInServiceAsync logInServiceAsync;
    private final AppUtil appUtil;
    private final Logger logger = Logger.getLogger("");

    @Inject
    public GreetingActivityProvider(GreetingView greetingView, PlaceController placeController, Messages messages,
	    LogInServiceAsync logInServiceAsync, AppUtil appUtil) {
	this.greetingView = greetingView;
	this.placeController = placeController;
	this.messages = messages;
	this.logInServiceAsync = logInServiceAsync;
	this.appUtil = appUtil;
    }

    @Override
    public GreetingActivity get() {
	logger.log(Level.INFO, "Startng new 'greeting' activity.");
	return new GreetingActivity(greetingView, placeController, messages, logInServiceAsync, appUtil);
    }
}
