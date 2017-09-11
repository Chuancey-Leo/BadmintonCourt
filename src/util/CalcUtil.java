package util;

import entity.Court;
import entity.PriceTime;
import entity.User;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 计算工具类
 */
public class CalcUtil {

    /**
     * 价格计算
     * @param court
     * @param user
     */
    public static void calcPrice(Court court, User user) {

        String date = user.getPriceTime().getDate();
        String[] userTimeSegment = user
                .getPriceTime()
                .getTimeSegment()
                .split("~");
        String a = userTimeSegment[0].replaceAll(":", "");
        String b = userTimeSegment[1].replaceAll(":", "");

        String week = FormatUtil.dateToWeek(date);

        List<PriceTime> priceTimeList=null;
        if (week.equals("星期六") || week.equals("星期日")) {
            priceTimeList = court.getPriceWeekendList();
        } else {
            priceTimeList = court.getPriceTimeList();
        }

        for (int i = 0; i < priceTimeList.size(); i++) {
            PriceTime p = priceTimeList.get(i);

            String[] timeSegment = p.getTimeSegment().split("~");
            String x = timeSegment[0].replaceAll(":", "");
            String y = timeSegment[1].replaceAll(":", "");

            if (Integer.valueOf(b) > Integer.valueOf(y) &&
                    Integer.valueOf(a) < Integer.valueOf(y)) {
                int price = ((Integer.valueOf(y)-
                        Integer.valueOf(a))/100)*p.getPrice();
                double realPrice = user.getBookingPrice() + price;
                user.setBookingPrice(realPrice);
                a = y;
            } else if (Integer.valueOf(a) >= Integer.valueOf(x) &&
                    Integer.valueOf(b) <= Integer.valueOf(y)) {
                int price = ((Integer.valueOf(b)-
                        Integer.valueOf(a))/100)*p.getPrice();
                double realPrice = user.getBookingPrice() + price;
                user.setBookingPrice(realPrice);
                break;
            }
        }
    }

    /**
     * 计算违约金
     * @param price
     * @param x
     * @return
     */
    public static double damagesUtil(double price, double x) {
        double result = price * x;
        return result;
    }
}
