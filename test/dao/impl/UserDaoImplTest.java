package dao.impl;

import dao.UserDao;
import entity.PriceTime;
import entity.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoImplTest {
    @Test
    public void values() throws Exception {
        UserDao userDao = new UserDaoImpl();
        User user = new User();
        String[] input = {"U003", "2017-08-02", "13:00~17:00", "B"};
        assertEquals(true, userDao.values(input, user));
    }

}