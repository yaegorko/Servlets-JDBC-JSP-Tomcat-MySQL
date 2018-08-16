package dao;

import model.User;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UserDaoImplTest {

    @Test
    public void testCreateNewUser() {
        User egor = new User("egor", "123");
        UserDaoImpl.addNewUser(egor);
        User user  = new User("user", "pass2");
        UserDaoImpl.addNewUser(user);
    }

    @Test
    public void testGetUserById() throws SQLException {
        User user = UserDaoImpl.getUserById(1);
        assertThat(user.getName(), is("egor"));
    }


    @Test
    public void testDeleteById() throws SQLException {
        UserDaoImpl.deleteUserById(4);
    }

    @Test
    public void testUpdateUsers() {
        User user = new User(1,"Ivan", "321");
        UserDaoImpl.updateUser(user);
    }

    @Test
    public void testGetAll() {
       List<User> list = UserDaoImpl.getAllUsers();
       User user = list.get(1);
       assertThat(user.getName(), is("user"));
    }
}
