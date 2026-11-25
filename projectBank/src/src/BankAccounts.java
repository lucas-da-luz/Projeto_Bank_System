
import java.math.BigDecimal;

public class BankAccounts {

    private String name, password;
    private String contact, cpf;
    private BigDecimal balance = BigDecimal.ZERO;

    public BankAccounts(String name, String cpf, String password, String contact) {
        this.name = name;
        this.cpf = cpf;
        this.password = password;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf.replaceAll("\\D", "");
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public boolean verifyPassword(String password) {
        return this.password.equals(password);
    }

    public boolean deposit(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            return false;
        }

        balance = balance.add(amount);
        return true;
    }

    public boolean withdraw(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0
                || balance.compareTo(amount) < 0) {
            return false;
        }

        balance = balance.subtract(amount);
        return true;
    }
}
