package dao;

import entity.User;

/**
 * user接口
 */
public interface UserDao {
    public boolean values(String[] input, User user);
}
