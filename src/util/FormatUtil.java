package util;

import entity.Court;
import entity.PriceTime;
import entity.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 格式工具类
 */
public class FormatUtil {
    private static SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");

    /**
     * 输入整体格式验证
     * @param input
     * @return
     */
    public static boolean inputFormat(String input, User user) {
        String bookingRegx = "U(\\d){3} " +
                "((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))[ ]"
                +"((([0-1][0-9])|2[0-3]):00~(([0-1][0-9])|2[0-3]):00)([ ][A-D])";

        String cancelRegx = "U(\\d){3} " +
                "((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))[ ]"
                +"((([0-1][0-9])|2[0-3]):00~(([0-1][0-9])|2[0-3]):00)([ ][A-D]|[ ][A-D][ ][C])";

        Pattern bookingPattern = Pattern.compile(bookingRegx);
        Matcher bookingMatcher = bookingPattern.matcher(input);
        Pattern cancelPattern = Pattern.compile(cancelRegx);
        Matcher cancelMatcher = cancelPattern.matcher(input);

        if (bookingMatcher.matches()) {
            return true;
        } else if (cancelMatcher.matches()) {
            user.setBooking(false);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 时间片格式验证,用户可能输入的区间在
     * 多个场地时间表区间,即跨区间选择
     * @param timeSegment
     * @return
     * @throws Exception
     */
    public static boolean timeSegmentFormat(String timeSegment, Court court) throws Exception{
        String regx = "[0-2][0-9]:00~[0-2][0-9]:00";
        Pattern pattern = Pattern.compile(regx);
        Matcher timeSegmentMatcher = pattern.matcher(timeSegment);

        if (timeSegmentMatcher.matches()) {

            String[] times = timeSegment.split("~");
            for (int i = 0; i < times.length; i++) {
                times[i] = times[i].replaceAll(":","");
            }

            if (Integer.valueOf(times[1]) <= Integer.valueOf(times[0])) {
                return false;
            }

            for (PriceTime p:court.getPriceTimeList()) {
                String[] existTimes = p.getTimeSegment().split("~");
                for (int i = 0; i < existTimes.length; i++) {
                    existTimes[i] = existTimes[i].replaceAll(":","");
                }
                if (Integer.valueOf(times[0]) < Integer.valueOf(existTimes[0])) {
                    return false;
                } else if (Integer.valueOf(times[1]) > Integer.valueOf(existTimes[1])) {
                    times[0] = existTimes[1];
                } else if (Integer.valueOf(times[1]) <= Integer.valueOf(existTimes[1])) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断输入时间片与已预订时间片是否有交集
     * @param exist
     * @param user
     * @return
     */
    public static boolean compareTimeSegment(User exist,
                                             User user) {
        PriceTime existPriceTime = exist.getPriceTime();
        PriceTime priceTime = user.getPriceTime();
        String existCourt = exist.getBookingName();
        String court = user.getBookingName();

        if (existPriceTime.getDate().equals(priceTime.getDate())
                && existCourt.equals(court)
                && exist.isBooking()) {
            String[] existTimeSegment = existPriceTime.getTimeSegment().split("~");
            String[] timeSegment = priceTime.getTimeSegment().split("~");

            String a = existTimeSegment[0].replaceAll(":", "");
            String b = existTimeSegment[1].replaceAll(":", "");

            String c = timeSegment[0].replaceAll(":", "");
            String d = timeSegment[1].replaceAll(":", "");

            int left = Integer.valueOf(a) - Integer.valueOf(d);
            int right = Integer.valueOf(b) - Integer.valueOf(c);

            if (left*right < 0) {
                return false;
            }
            return true;
        }
        return true;
    }

    /**
     * 转化yyyy-MM-dd为星期几
     * @param date
     * @return
     */
    public static String dateToWeek(String date) {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdw = new SimpleDateFormat("E");
        Date d = null;
        try {
            d = sd.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sdw.format(d);
    }
}
