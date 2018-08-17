package dao;

import model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.DbHelper;

import javax.persistence.NoResultException;
import java.util.List;

public class UserDaoImplHibernate implements UserDao<User> {

    private static UserDao userDao;

    public static UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDaoImplHibernate();
        }
        return userDao;
    }

    private static Session getSession() {
        return DbHelper.getSessionFactory().openSession();
    }

    @Override
    public void addNewUser(User user) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    @Override
    public User getUserById(int id) {
        Session session = getSession();
        Query query = session.createQuery("from User where id=:id");
        try {
            return (User) query.setParameter("id", id).uniqueResult();
        } catch (NoResultException noResultException) {
            noResultException.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateUser(User user) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    @Override
    public List<User> getAllUsers() {
        Session session = getSession();
        Query query = session.createQuery("from User");
        return query.list();
    }

    @Override
    public void deleteUserById(int id) {
        User user = getUserById(id);
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }
}
