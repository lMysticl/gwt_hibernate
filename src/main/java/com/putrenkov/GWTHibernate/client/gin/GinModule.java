package com.putrenkov.GWTHibernate.client.gin;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.putrenkov.GWTHibernate.client.AppController;
import com.putrenkov.GWTHibernate.client.activities.GreetingActivity;
import com.putrenkov.GWTHibernate.client.activities.LogInActivity;
import com.putrenkov.GWTHibernate.client.places.AppPlaceHistoryMapper;
import com.putrenkov.GWTHibernate.client.providers.GreetingActivityProvider;
import com.putrenkov.GWTHibernate.client.providers.LogInActivityProvider;
import com.putrenkov.GWTHibernate.client.resources.messages.Messages;
import com.putrenkov.GWTHibernate.client.views.*;
import com.putrenkov.GWTHibernate.client.AppControllerImpl;
import com.putrenkov.GWTHibernate.client.activities.MainActivityMapper;
import com.putrenkov.GWTHibernate.client.util.AppUtil;
import com.putrenkov.GWTHibernate.client.views.AppLayout;
import com.putrenkov.GWTHibernate.client.views.AppLayoutImpl;
import com.putrenkov.GWTHibernate.client.views.GreetingView;
import com.putrenkov.GWTHibernate.client.views.LogInView;
import com.putrenkov.GWTHibernate.client.views.LogInViewImpl;

public class GinModule extends AbstractGinModule {

    @Override
    protected void configure() {

	// Views
	bind(AppLayout.class).to(AppLayoutImpl.class).in(Singleton.class);
	bind(LogInView.class).to(LogInViewImpl.class).in(Singleton.class);
	bind(GreetingView.class).to(GreetingViewImpl.class).in(Singleton.class);

	// Activities
	bind(LogInActivity.class).toProvider(LogInActivityProvider.class).in(Singleton.class);
	bind(GreetingActivity.class).toProvider(GreetingActivityProvider.class).in(Singleton.class);

	// Places
	bind(PlaceHistoryMapper.class).to(AppPlaceHistoryMapper.class).in(Singleton.class);

	// Application event bus
	bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);

	// Application controller
	bind(AppController.class).to(AppControllerImpl.class).in(Singleton.class);

	// Internationalization
	bind(Messages.class).in(Singleton.class);

	bind(AppUtil.class).in(Singleton.class);

    }

    @Provides
    @Singleton
    public ActivityManager getActivityManager(MainActivityMapper activityMapper, EventBus eventBus) {
	return new ActivityManager(activityMapper, eventBus);
    }

    @SuppressWarnings("deprecation")
    @Provides
    @Singleton
    public PlaceController getPlaceController(EventBus eventBus) {
	return new PlaceController(eventBus);
    }

    @Provides
    @Singleton
    public PlaceHistoryHandler getHistoryHandler(PlaceController placeController, PlaceHistoryMapper historyMapper,
	    EventBus eventBus) {
	PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
	return historyHandler;
    }

}
