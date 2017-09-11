package dao.impl;

import dao.UserDao;
import entity.PriceTime;
import entity.User;

/**
 * dao实现层
 */
public class UserDaoImpl implements UserDao{

    /**
     * user的值设置
     * @param input
     * @param user
     * @return
     */
    @Override
    public boolean values(String[] input, User user) {
        user.setUserId(input[0]);
        user.setPriceTime(new PriceTime(input[1], input[2]));
        user.setBookingName(input[3]);
        return true;
    }
}
