package com.putrenkov.GWTHibernate.client.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.putrenkov.GWTHibernate.shared.LogInInfo;


@RemoteServiceRelativePath("login")
public interface LogInService extends RemoteService {

    /**
     * This method perform authentication check for user. Returns LogInInfo
     * object that holds information about logged in user if login and password
     * are correct and null if not.
     *
     * @param login
     *            user login
     * @param password
     *            user password
     * @return LogInInfo object or null
     */
    LogInInfo logIn(String login, String password);

    /**
     * This method perform authentication from current session. Returns
     * LogInInfo object that holds information about logged in user if session
     * is still valid and null if not.
     *
     * @return LogInInfo object or null
     */
    LogInInfo logInFromSession(String sessionID);

    /**
     * Remove logged in user from current session.
     *
     */
    void logOut();
}
