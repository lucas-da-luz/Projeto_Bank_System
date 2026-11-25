
import java.math.BigDecimal;
import java.util.List;

public class BankServices {

    public void deposit(BankAccounts account, BigDecimal amount, String password) {

        if (!account.verifyPassword(password)) {
            System.out.println("Incorrect password.");
            return;
        }

        if (account.deposit(amount)) {
            System.out.println("Deposit successful!");
            System.out.println("New balance: R$ " + account.getBalance());
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void transfer(
            List<BankAccounts> accounts,
            BankAccounts sender,
            String destinationCpf,
            String password,
            BigDecimal amount) {

        if (!sender.verifyPassword(password)) {
            System.out.println("Incorrect password.");
            return;
        }

        destinationCpf = destinationCpf.replaceAll("\\D", "");

        if (sender.getCpf().equals(destinationCpf)) {
            System.out.println("You cannot transfer to yourself.");
            return;
        }

        BankAccounts recipient = null;

        for (BankAccounts account : accounts) {
            if (account.getCpf().equals(destinationCpf)) {
                recipient = account;
                break;
            }
        }

        if (recipient == null) {
            System.out.println("Recipient not found.");
            return;
        }

        if (!sender.withdraw(amount)) {
            System.out.println("Insufficient balance or invalid amount.");
            return;
        }

        recipient.deposit(amount);

        System.out.println("Transfer successful!");
        System.out.println("Recipient: " + recipient.getName());
        System.out.println("Transferred amount: R$ " + amount);
        System.out.println("Remaining balance: R$ " + sender.getBalance());
    }
}
