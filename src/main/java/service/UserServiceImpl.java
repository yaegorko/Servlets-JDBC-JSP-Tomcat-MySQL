package service;

import dao.UserDao;
import dao.UserDaoImplHibernate;
import dao.UserDaoImplJDBC;
import model.User;

import java.util.List;

public class UserServiceImpl implements UserService<User> {

    private static UserDao userDao;
    private static UserServiceImpl userService;

    /*
    JDBC
     */
//    private UserServiceImpl() {
//        userDao = UserDaoImplJDBC.getUserDao();
//    }
    /*
    Hibernate
    */
    private UserServiceImpl() {
        userDao = UserDaoImplHibernate.getUserDao();
    }

    public static UserServiceImpl getUserService() {
        if (userService == null) {
            userService = new UserServiceImpl();
        }
        return userService;
    }

    public void add(User user) {
        userDao.addNewUser(user);
    }

    public User getById(int id) {
        return (User) userDao.getUserById(id);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void deleteUser(int id) {
        userDao.deleteUserById(id);
    }
}
