package util;

import entity.User;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class ComparatorDate implements Comparator {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    @Override
    public int compare(Object o1, Object o2) {
        User t1 = (User)o1;
        User t2 = (User)o2;

        Date d1=null;
        Date d2=null;
        try {
            d1 = format.parse(t1.getPriceTime().getDate() +
                    " " + t1.getPriceTime().getTimeSegment());
            d2 = format.parse(t2.getPriceTime().getDate() +
                    " " + t2.getPriceTime().getTimeSegment());
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!d1.before(d2)) {
            return 1;
        } else {
            return -1;
        }
    }
}
