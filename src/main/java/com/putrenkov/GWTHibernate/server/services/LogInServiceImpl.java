package com.putrenkov.GWTHibernate.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.putrenkov.GWTHibernate.client.services.LogInService;
import com.putrenkov.GWTHibernate.server.integration.UserDAO;
import com.putrenkov.GWTHibernate.server.model.User;
import com.putrenkov.GWTHibernate.shared.LogInInfo;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogInServiceImpl extends RemoteServiceServlet implements LogInService {

	private final Logger logger = Logger.getLogger("");
    private UserDAO userDAO = new UserDAO();
    @Override
    public LogInInfo logIn(String login, String password) {
	User user = userDAO.findUserByLogin(login);
	if (user != null) {
	    LogInInfo logInInfo = validateUserPasswordAndReturnLogInInfo(user, password);
	    storeLogInInfoInSession(logInInfo);
	    return logInInfo;
	} else {
	    logger.log(Level.INFO, "There is no such user");
	    return null;
	}
    }

    @Override
    public LogInInfo logInFromSession(String sessionID) {
	LogInInfo logInInfo = null;
	Object LogInInfoObj = getObjectFromSessionByAttribute("logInInfo");
	if (LogInInfoObj != null && LogInInfoObj instanceof LogInInfo) {
	    logInInfo = (LogInInfo) LogInInfoObj;
	    if (!logInInfo.getSessionId().equals(sessionID)) {
		logInInfo = null;
		logger.log(Level.WARNING, "Session ID is not valid");
	    }
	}
	return logInInfo;
    }

    @Override
    public void logOut() {
	HttpServletRequest httpServletRequest = this.getThreadLocalRequest();
	HttpSession session = httpServletRequest.getSession();
	session.removeAttribute("logInInfo");
    }

    private void storeLogInInfoInSession(LogInInfo logInInfo) {
	HttpServletRequest httpServletRequest = this.getThreadLocalRequest();
	HttpSession session = httpServletRequest.getSession(true);
	session.setAttribute("logInInfo", logInInfo);
    }

    private Object getObjectFromSessionByAttribute(String attribute) {
	HttpServletRequest httpServletRequest = this.getThreadLocalRequest();
	HttpSession session = httpServletRequest.getSession();
	return session.getAttribute(attribute);
    }

    /**
     * Access modifier was changed from private to default to enhance
     * testability
     */
    // private
    LogInInfo validateUserPasswordAndReturnLogInInfo(User user, String password) {
	if (user != null && password != null) {
	    if (BCrypt.checkpw(password, user.getPassword())) {
		logger.log(Level.INFO, "Password is valid for user " + user.getLogin());
		LogInInfo logInInfo = new LogInInfo();
		logInInfo.setIsLoggedIn(true);
		logInInfo.setFirstName(user.getFirstName());
		logInInfo.setSessionId(UUID.randomUUID().toString());
		return logInInfo;
	    } else {
		logger.log(Level.INFO, "Password is incorrect for user " + user.getLogin());
		return null;
	    }
	} else {
	    throw new NullPointerException("User or password is null");
	}
    }
}
