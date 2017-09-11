package util;

import entity.Court;
import entity.User;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;

import static org.junit.Assert.*;

public class FormatUtilTest {
    @Test
    public void dateToWeek() throws Exception {
        String date = "2017-09-11";
        assertEquals("星期一", FormatUtil.dateToWeek(date));

        String date2 = "2017-09-12";
        assertEquals("星期二", FormatUtil.dateToWeek(date2));

        String date3 = "2017-08-05";
        assertEquals("星期六", FormatUtil.dateToWeek(date3));
    }

    @Test
    public void timeSegmentFormat() throws Exception {
        Court court = new Court("A");

        boolean flag = FormatUtil.timeSegmentFormat("10:00~12:00", court);
        assertEquals(true, flag);

        boolean flag2 = FormatUtil.timeSegmentFormat("08:00~12:00", court);
        assertEquals(false, flag2);
    }

    @Test
    public void inputFormat() throws Exception {
        User user = new User();
        boolean flag = FormatUtil.inputFormat("U001 2016-06-02 22:00~22:00 A", user);
        boolean flag2 = FormatUtil.inputFormat("abcdefghijklmnopqrst1234567890", user);
        assertEquals(true, flag);
        assertEquals(false, flag2);
    }

}