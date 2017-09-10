package dao;

import entity.User;

public interface UserDao {
    public boolean values(String[] input, User user);
}
