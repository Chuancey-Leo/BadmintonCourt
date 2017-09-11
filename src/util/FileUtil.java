package util;

import entity.Court;
import entity.User;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;

public class FileUtil {
    public static void printToTxt(List<Court> courts) {
        try {
            File f=new File("out.txt");
            f.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(f);
            PrintStream printStream = new PrintStream(fileOutputStream);
            System.setOut(printStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        double sum=0d;
        for (int i = 0; i < courts.size(); i++) {
            List<User> userList = courts.get(i).getUserList();
            for (int j = 0; j < userList.size(); j++) {
                sum+=userList.get(j).getBookingPrice();
            }
        }


        System.out.println("收入汇总");

        System.out.println("---");
        for (int i = 0; i < courts.size(); i++) {
            System.out.println("场地:"+courts.get(i).getName());

            List<User> userList = courts.get(i).getUserList();
            ComparatorDate c = new ComparatorDate();
            Collections.sort(userList, c);

            for (int j = 0; j < userList.size(); j++) {
                User user = userList.get(j);

                if (user.isBooking()) {
                    System.out.println(user.getPriceTime().getDate()
                            + " " + user.getPriceTime().getTimeSegment() + " "
                            + (int)user.getBookingPrice() + "元");
                } else {
                    System.out.println(user.getPriceTime().getDate()
                            + " " + user.getPriceTime().getTimeSegment() + " 违约金 "
                            + (int)user.getBookingPrice() + "元");
                }
            }
            IntSummaryStatistics stats = userList.stream().mapToInt((x)
                    -> (int) x.getBookingPrice()).summaryStatistics();

            System.out.println("小计:"+stats.getSum()+"元");
            if(i < courts.size()-1) {
                System.out.println("");
            }
        }

        System.out.println("---");
        System.out.println("总计:"+(int)sum+"元");
    }
}
