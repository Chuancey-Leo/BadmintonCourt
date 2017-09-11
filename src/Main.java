import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Controller controller = new Controller();
        do{
            String input = s.nextLine();
            if (input.equals("")) {
                controller.getSumList();
                break;
            } else {
                controller.execute(input);
            }
        } while (true);
    }
}
