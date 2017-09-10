import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.Court;
import entity.User;
import service.CourtService;
import service.implService.CourtServiceImpl;
import util.FormatUtil;

public class Factory {

    //统一管理所有场地
    private Court courtA;
    private Court courtB;
    private Court courtC;
    private Court courtD;
    private CourtService courtService;

    private static UserDao userDao = new UserDaoImpl();

    public Factory() {
        courtA = new Court();
        courtB = new Court();
        courtC = new Court();
        courtD = new Court();
        courtService = new CourtServiceImpl();
    }

    /**
     *
     * @param input
     */
    public void execute(String input) {

        //实例化对应用户记录
        User user = new User();

        //检测整体格式是否正确
        if (!FormatUtil.inputFormat(input, user)) {
            System.out.println("> Error: the booking is invalid!");
            return;
        }

        //检测时间格式是否正确,并对entity赋值
        boolean flag = userDao.values(input.split(" "), user);
        if (!flag) {
            System.out.println("> Error: the booking is invalid!");
            return;
        }

        //预订状态与取消状态
        if (user.isBooking()) {
            //跟据场地的不同进行switch分支
            switch (user.getBookingName()) {
                case "A":
                    courtService.booking(user, courtA);
                    break;
                case "B":
                    courtService.booking(user, courtB);
                    break;
                case "C":
                    courtService.booking(user, courtC);
                    break;
                case "D":
                    courtService.booking(user, courtD);
                    break;
            }
        } else {
            //跟据场地的不同进行switch分支
            switch (user.getBookingName()) {
                case "A":
                    courtService.cancel(user, courtA);
                    break;
                case "B":
                    courtService.cancel(user, courtB);
                    break;
                case "C":
                    courtService.cancel(user, courtB);
                    break;
                case "D":
                    courtService.cancel(user, courtB);
                    break;
            }
        }
    }

    public void getSumList() {

    }


    public Court getCourtA() {
        return courtA;
    }
    public void setCourtA(Court courtA) {
        this.courtA = courtA;
    }
    public Court getCourtB() {
        return courtB;
    }
    public void setCourtB(Court courtB) {
        this.courtB = courtB;
    }
    public Court getCourtC() {
        return courtC;
    }
    public void setCourtC(Court courtC) {
        this.courtC = courtC;
    }
    public Court getCourtD() {
        return courtD;
    }
    public void setCourtD(Court courtD) {
        this.courtD = courtD;
    }
}
