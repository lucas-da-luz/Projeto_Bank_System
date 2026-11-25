
import java.util.Scanner;
import java.math.BigDecimal;

public class BasicFunctions {

    public int getOption(Scanner scan, int role) {
        System.out.print("Option: ");
        int option;

        do {
            if (scan.hasNextInt()) {
                option = scan.nextInt();
                scan.nextLine();
            } else {
                scan.nextLine();
                option = -1;
            }

            if (option > role || option < 0) {
                System.out.println("Invalid option. Try again.");
                System.out.print("Option: ");
            }

        } while (option > role || option < 0);

        return option;
    }

    public BigDecimal getAmount(Scanner scan) {

        while (true) {
            System.out.print("Amount: R$ ");

            if (scan.hasNextBigDecimal()) {
                BigDecimal amount = scan.nextBigDecimal();
                scan.nextLine();

                if (amount.compareTo(BigDecimal.ZERO) > 0) {
                    return amount;
                }

                System.out.println("Amount must be greater than zero.");

            } else {
                scan.nextLine();
                System.out.println("Invalid amount.");
            }
        }
    }

    public boolean verifyCpf(String cpf) {

        if (cpf == null) return false;

        cpf = cpf.replaceAll("\\D", "");

        if (cpf.length() != 11) return false;

        boolean allDigitsEqual = true;

        for (int i = 1; i < 11; i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                allDigitsEqual = false;
                break;
            }
        }

        if (allDigitsEqual) return false;

        for (int i = 9; i < 11; i++) {
            int sum = 0;
            int weight = i + 1;

            for (int j = 0; j < i; j++) {
                sum += (cpf.charAt(j) - '0') * weight;
                weight--;
            }

            int remainder = sum % 11;
            int calculatedDigit = (remainder < 2) ? 0 : (11 - remainder);
            int providedDigit = cpf.charAt(i) - '0';

            if (calculatedDigit != providedDigit) {
                return false;
            }
        }

        return true;
    }

    public String formatCpf(String cpf) {
        if (cpf == null) return null;

        cpf = cpf.replaceAll("\\D", "");

        if (cpf.length() != 11) {
            return cpf;
        }

        return cpf.substring(0, 3) + "." +
                cpf.substring(3, 6) + "." +
                cpf.substring(6, 9) + "-" +
                cpf.substring(9, 11);
    }
}
