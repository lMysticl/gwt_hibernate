package com.putrenkov.GWTHibernate.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.putrenkov.GWTHibernate.server.integration.UserDAO;
import com.putrenkov.GWTHibernate.server.model.User;
import org.junit.Before;
import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;

import static org.junit.Assert.assertEquals;

public class LogInServiceImplTest extends RemoteServiceServlet {


    private static final String LOGIN = "john";
    private static final String CORRECT_PASSWORD = "smith";
    private static final String HASHED_CORRECT_PASSWORD = BCrypt.hashpw(CORRECT_PASSWORD, BCrypt.gensalt());
    private static final String USER_NAME = "John";
    private static final String WRONG_PASSWORD = "12345";

    private final User user = new User(LOGIN, HASHED_CORRECT_PASSWORD, USER_NAME);
    private final UserDAO userDAO = new UserDAO();
    private final LogInServiceImpl logInServiceImpl = new LogInServiceImpl();

    @Before
    public void setUp() {
	userDAO.createUser(user);
    }

    @Test
    public void validateUserPasswordAndReturnLogInInfoTestSucces() {
	String userName = logInServiceImpl.validateUserPasswordAndReturnLogInInfo(user, CORRECT_PASSWORD)
		.getFirstName();
	assertEquals(USER_NAME, userName);
	assertEquals(null, logInServiceImpl.validateUserPasswordAndReturnLogInInfo(user, WRONG_PASSWORD));

    }

    @Test(expected = NullPointerException.class)
    public void validateUserPasswordAndReturnLogInInfoTestFail() {
	assertEquals(null, logInServiceImpl.validateUserPasswordAndReturnLogInInfo(null, CORRECT_PASSWORD));
    }

}
