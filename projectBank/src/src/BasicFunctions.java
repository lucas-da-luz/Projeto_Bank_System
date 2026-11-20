import java.util.Scanner;

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
            }

        } while (option > role || option < 0);
        return option;
    }

    public boolean verifyCpf(String cpf) {

        // Basic logical validation
        if (cpf == null) return false;
        // replaceAll for exclude other char types.
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

        // Secure validation
        cpf = cpf.replaceAll("\\D", "");

        if (cpf.length() != 11) {
            return cpf;
        }

        //return cpf : xxx.xxx.xxx-xx
        // When print cpf by now show formated again
        return cpf.substring(0, 3) + "." +
                cpf.substring(3, 6) + "." +
                cpf.substring(6, 9) + "-" +
                cpf.substring(9, 11);
    }
}

