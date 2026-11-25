
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        int role = 3;

        Menu menus = new Menu();
        BasicFunctions util = new BasicFunctions();
        BankServices services = new BankServices();

        Scanner scan = new Scanner(System.in);

        List<BankAccounts> accounts = new ArrayList<>();

        boolean running = true;

        while (running) {

            menus.menuInitial();

            int register = util.getOption(scan, 2);

            switch (register) {

                case 1:
                    menus.screenRegister();

                    System.out.print("Name: ");
                    String name = scan.nextLine();

                    String cpf;

                    do {
                        System.out.print("CPF: ");
                        cpf = scan.nextLine();

                        if (!util.verifyCpf(cpf)) {
                            System.out.println("Invalid CPF.");
                        }

                    } while (!util.verifyCpf(cpf));

                    System.out.print("Password: ");
                    String password = scan.nextLine();

                    System.out.print("Contact: ");
                    String contact = scan.nextLine();

                    BankAccounts newAccount = new BankAccounts(
                            name, cpf, password, contact
                    );

                    boolean exists = false;

                    for (BankAccounts account : accounts) {
                        if (account.getCpf().equals(newAccount.getCpf())) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        System.out.println("CPF already registered.");
                    } else {
                        accounts.add(newAccount);
                        System.out.println("Registration successful!");
                    }

                    break;

                case 2:
                    menus.screenLogin();

                    System.out.print("CPF: ");
                    String loginCpf = scan.nextLine();

                    System.out.print("Password: ");
                    String loginPassword = scan.nextLine();

                    BankAccounts loggedAccount = null;

                    for (BankAccounts account : accounts) {

                        if (account.getCpf().equals(
                                loginCpf.replaceAll("\\D", ""))) {

                            if (account.verifyPassword(loginPassword)) {
                                loggedAccount = account;
                            }

                            break;
                        }
                    }

                    if (loggedAccount == null) {
                        System.out.println("Invalid CPF or password.");
                        break;
                    }

                    System.out.println("Login successful!");

                    boolean loggedIn = true;

                    while (loggedIn) {

                        menus.menuCustomer(loggedAccount.getName());

                        int option = util.getOption(scan, 5);

                        switch (option) {

                            case 1:
                                System.out.println(
                                        "Balance: R$ " +
                                        loggedAccount.getBalance()
                                );
                                break;

                            case 2:
                                System.out.print("Recipient CPF: ");
                                String destinationCpf = scan.nextLine();

                                System.out.print("Confirm your password: ");
                                String transferPassword = scan.nextLine();

                                BigDecimal transferAmount = util.getAmount(scan);

                                services.transfer(
                                        accounts,
                                        loggedAccount,
                                        destinationCpf,
                                        transferPassword,
                                        transferAmount
                                );
                                break;

                            case 3:
                                System.out.println("Statement under development.");
                                break;

                            case 4:
                                System.out.print("Confirm your password: ");
                                String withdrawPassword = scan.nextLine();

                                BigDecimal withdrawAmount = util.getAmount(scan);

                                if (!loggedAccount.verifyPassword(withdrawPassword)) {
                                    System.out.println("Incorrect password.");
                                } else if (loggedAccount.withdraw(withdrawAmount)) {
                                    System.out.println("Withdrawal successful!");
                                } else {
                                    System.out.println("Insufficient balance.");
                                }
                                break;

                            case 5:
                                System.out.print("Confirm your password: ");
                                String depositPassword = scan.nextLine();

                                BigDecimal depositAmount = util.getAmount(scan);

                                services.deposit(
                                        loggedAccount,
                                        depositAmount,
                                        depositPassword
                                );
                                break;

                            case 0:
                                loggedIn = false;
                                System.out.println("Logging out...");
                                break;
                        }
                    }

                    break;

                case 0:
                    running = false;
                    System.out.println("Thank you for using Moak Digital Bank!");
                    break;
            }
        }

        scan.close();
    }
}
