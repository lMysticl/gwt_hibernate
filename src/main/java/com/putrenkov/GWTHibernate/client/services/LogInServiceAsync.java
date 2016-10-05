package com.putrenkov.GWTHibernate.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.putrenkov.GWTHibernate.shared.LogInInfo;

public interface LogInServiceAsync {

    void logIn(String login, String password, AsyncCallback<LogInInfo> callback);

    void logInFromSession(String sessionID, AsyncCallback<LogInInfo> callback);

    void logOut(AsyncCallback<Void> callback);

}
