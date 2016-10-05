package com.putrenkov.GWTHibernate.server.services;

import com.putrenkov.GWTHibernate.server.integration.UserDAO;
import com.putrenkov.GWTHibernate.server.model.User;
import com.putrenkov.GWTHibernate.server.util.HibernateUtil;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.ArrayList;
import java.util.List;

/**
 * This service class add default users into database before the web application
 * is started.
 */
public class DbStartInitService implements ServletContextListener {

    private UserDAO userDAO = new UserDAO();

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
	HibernateUtil.closeEntityManager();
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
	List<User> defaultUsers = new ArrayList<>();
	defaultUsers.add(new User("ivan", "secret", "Иван"));
	defaultUsers.add(new User("john", "smith", "John"));
	for (User user : defaultUsers) {
	    userDAO.createUser(new User(user.getLogin(), BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()), user
		    .getFirstName()));
	}
    }
}