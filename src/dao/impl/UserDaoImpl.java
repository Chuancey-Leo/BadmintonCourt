package dao.impl;

import dao.UserDao;
import entity.PriceTime;
import entity.User;

public class UserDaoImpl implements UserDao{

    @Override
    public boolean values(String[] input, User user) {
        user.setUserId(input[0]);
        user.setPriceTime(new PriceTime(input[1], input[2]));
        user.setBookingName(input[3]);
        return true;
    }
}
