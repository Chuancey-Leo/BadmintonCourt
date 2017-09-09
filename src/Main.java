import util.FormatUtil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        do{
            String x = s.nextLine();
            if (x.equals("")) {
                break;
            } else {
                if (FormatUtil.inputFormat(x)) {
                    System.out.println("yes");
                }
            }
        } while (true);
    }
}
