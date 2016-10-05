package com.putrenkov.GWTHibernate.client.providers;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.putrenkov.GWTHibernate.client.activities.LogInActivity;
import com.putrenkov.GWTHibernate.client.resources.messages.Messages;
import com.putrenkov.GWTHibernate.client.services.LogInServiceAsync;
import com.putrenkov.GWTHibernate.client.util.AppUtil;
import com.putrenkov.GWTHibernate.client.views.LogInView;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogInActivityProvider implements Provider<LogInActivity> {

    private final LogInView logInView;
    private final LogInServiceAsync logInServiceAsync;
    private final PlaceController placeController;
    private final Messages messages;
    private final AppUtil appUtil;
    private final Logger logger = Logger.getLogger("");

    @Inject
    public LogInActivityProvider(LogInView logInView, LogInServiceAsync logInServiceAsync,
                                 PlaceController placeController, EventBus eventBus, Messages messages, AppUtil appUtil) {
	this.logInView = logInView;
	this.logInServiceAsync = logInServiceAsync;
	this.placeController = placeController;
	this.messages = messages;
	this.appUtil = appUtil;
    }

    @Override
    public LogInActivity get() {
	logger.log(Level.INFO, "Starting new 'log in' activity");
	return new LogInActivity(logInView, logInServiceAsync, placeController, messages, appUtil);
    }

}
