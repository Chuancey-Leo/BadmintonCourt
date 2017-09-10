package service.implService;

import entity.Court;
import entity.User;
import service.CourtService;
import util.FormatUtil;

/**
 * 对于场地操作的实现层
 */
public class CourtServiceImpl implements CourtService {
    @Override
    public void booking(User user, Court court) {
        boolean flag=false;
        for (User u: court.getUserList()) {
             flag = FormatUtil.compareTimeSegment(u, user);
            if (flag) {
                System.out.println("> Success: the booking is accepted!");
                break;
            }
        }

        if (!flag){
            System.out.println("> Error: the booking conflicts with existing bookings!");
            court.addUser(user);
        }

    }

    @Override
    public void cancel(User user, Court court) {
        for (User u:court.getUserList()) {
            if (u.toString().equals(user.toString())) {
                System.out.println("> Success: the booking is accepted!");
                court.getUserList().remove(u);
                u.setBooking(false);
                court.addUser(u);
                return;
            }
        }
        System.out.println("> Error: the booking being cancelled does not exist!");
    }

    @Override
    public int sum() {
        return 0;
    }
}
