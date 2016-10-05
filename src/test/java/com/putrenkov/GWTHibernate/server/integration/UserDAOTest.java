package com.putrenkov.GWTHibernate.server.integration;

import com.putrenkov.GWTHibernate.server.model.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserDAOTest {

    private static final String USER_LOGIN = "ivan";
    private static final String USER_PASSWORD = "secret";
    private static final String USER_NAME = "Иван";

    private UserDAO userDAO = new UserDAO();
    private User user = new User(USER_LOGIN, USER_PASSWORD, USER_NAME);
    private User userInDB;

    @Test
    public void createUserTest() {
	userDAO.createUser(user);
	userInDB = userDAO.findUserByLogin(user.getLogin());
	assertEquals(user.getLogin(), userInDB.getLogin());
	assertEquals(user.getPassword(), userInDB.getPassword());
	assertEquals(user.getFirstName(), userInDB.getFirstName());
    }

}
