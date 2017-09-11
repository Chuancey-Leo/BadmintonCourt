package service.implService;

import entity.Court;
import entity.User;
import service.CourtService;
import util.CalcUtil;
import util.ComparatorDate;
import util.FormatUtil;

import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * 对于场地操作的实现层
 */
public class CourtServiceImpl implements CourtService {

    /**
     * 预订场地
     * @param user
     * @param court
     */
    @Override
    public void booking(User user, Court court) {
        boolean flag=false;
        boolean timeSegmentFlag = false;
        try {
            timeSegmentFlag = FormatUtil.timeSegmentFormat(
                    user.getPriceTime()
                    .getTimeSegment(), court);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!timeSegmentFlag) {
            System.out.println("> Error: the booking is invalid!");
            return;
        }

        for (User u: court.getUserList()) {
             flag = FormatUtil.compareTimeSegment(u, user);
            if (flag) {
                System.out.println("> Success: the booking is accepted!");
                try {
                    CalcUtil.calcPrice(court, user);
                    court.addUser(user);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        if (court.getUserList().size() == 0) {
            System.out.println("> Success: the booking is accepted!");
            try {
                CalcUtil.calcPrice(court, user);
                flag = true;
                court.addUser(user);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if (!flag){
            System.out.println("> Error: the booking conflicts with existing bookings!");
        }

    }

    /**
     * 取消预订
     * @param user
     * @param court
     */
    @Override
    public void cancel(User user, Court court) {
        for (User u:court.getUserList()) {
            if (u.toString().equals(user.toString()) && u.isBooking()) {
                System.out.println("> Success: the booking is accepted!");
                court.getUserList().remove(u);
                u.setBooking(false);
                String week = FormatUtil.dateToWeek(u.getPriceTime().getDate());

                if (week == "星期六" || week == "星期日") {
                    double price = CalcUtil.damagesUtil(u.getBookingPrice(), 0.25);
                    u.setBookingPrice(price);
                } else {
                    double price = CalcUtil.damagesUtil(u.getBookingPrice(), 0.5);
                    u.setBookingPrice(price);
                }
                court.addUser(u);
                return;
            }
        }
        System.out.println("> Error: the booking being cancelled does not exist!");
    }

    /**
     * 计算总和
     * @param courts
     */
    @Override
    public void sum(List<Court> courts) {
        double sum=0d;
        for (int i = 0; i < courts.size(); i++) {
            List<User> userList = courts.get(i).getUserList();
            for (int j = 0; j < userList.size(); j++) {
                sum+=userList.get(j).getBookingPrice();
            }
        }


        System.out.println("> 收入汇总");
        System.out.println("> ---");
        for (int i = 0; i < courts.size(); i++) {
            System.out.println("> 场地:"+courts.get(i).getName());

            List<User> userList = courts.get(i).getUserList();
            ComparatorDate c = new ComparatorDate();
            Collections.sort(userList, c);

            for (int j = 0; j < userList.size(); j++) {
                User user = userList.get(j);

                if (user.isBooking()) {
                    System.out.println("> "+user.getPriceTime().getDate()
                    + " " + user.getPriceTime().getTimeSegment() + " "
                    + (int)user.getBookingPrice() + "元");
                } else {
                    System.out.println("> "+user.getPriceTime().getDate()
                            + " " + user.getPriceTime().getTimeSegment() + " 违约金 "
                            + (int)user.getBookingPrice() + "元");
                }
            }
            IntSummaryStatistics stats = userList.stream().mapToInt((x)
                    -> (int) x.getBookingPrice()).summaryStatistics();

            System.out.println("> 小计:"+stats.getSum()+"元");
            if(i < courts.size()-1) {
                System.out.println(">");
            }
        }

        System.out.println("> ---");
        System.out.println("> 总计:"+(int)sum+"元");
    }
}
