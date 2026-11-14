import java.util.Scanner;

public class BasicFunctions {

    public static int getOption;

    public int getOption(Scanner scan) {
        System.out.print("Option: ");
        if (scan.hasNextInt()) {
            int option = scan.nextInt();
            scan.nextLine(); // Clear buffer
            return option;
        } else {
            scan.nextLine();
            return -1;
        }
    }

    public void convertInt(Scanner scan, String stringInfo) {
        // Colocar pra quando o usuário inserir algo com caracteres que não sejam números, converta pra INT automaticamente.
    }

    // Verificador de cpf aqui
    public boolean getCpf(int CPF) {
        // Se cpf não for válido return false; else return true
        if (false) {
            return false;
        } else {
            return true;
        }
    }

    public void convertCpfFormat(int CPF) {
        //Adiciona . e - (ex: xxx.xxx.xxx-xx)
    }
}
