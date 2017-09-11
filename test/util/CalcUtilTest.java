package util;

import entity.Court;
import entity.PriceTime;
import entity.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalcUtilTest {
    @Test
    public void calcPrice() throws Exception {
        Court court = new Court("A");
        User user = new User();
        PriceTime priceTime = new PriceTime("2017-08-05", "09:00~11:00");
        user.setPriceTime(priceTime);

        CalcUtil.calcPrice(court, user);

        assertEquals(80, (int)user.getBookingPrice());
    }

}