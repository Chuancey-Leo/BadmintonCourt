import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Factory factory = new Factory();
        do{
            String input = s.nextLine();
            if (input.equals("")) {
                //factory
                break;
            } else {
                factory.execute(input);
            }
        } while (true);
    }
}
