package com.putrenkov.GWTHibernate.client.gin;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.putrenkov.GWTHibernate.client.AppController;

@GinModules(value = GinModule.class)
public interface AppGin extends Ginjector {
    AppController getAppController();
}
