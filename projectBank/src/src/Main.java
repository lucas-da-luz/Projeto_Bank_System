import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int role = 3;

        Menu menus = new Menu();
        BasicFunctions util = new BasicFunctions();

        Scanner scan = new Scanner(System.in);

        menus.menuInitial();

        if (register == admin || register == customer) {
            role = 2;
        }
        util.getOption(scan, role);
    }
}