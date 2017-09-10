package dao.impl;

import dao.UserDao;
import entity.PriceTime;
import entity.User;
import util.FormatUtil;

public class UserDaoImpl implements UserDao{

    @Override
    public boolean values(String[] input, User user) {

        try {
            if (!FormatUtil.timeSegmentFormat(input[2])) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        user.setUserId(input[0]);
        user.setPriceTime(new PriceTime(input[1], input[2]));
        user.setBookingName(input[4]);
        return true;
    }
}
