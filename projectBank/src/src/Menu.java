
public class Menu {

    public void menuInitial() {
        System.out.print("""
                Welcome to Moak Digital Bank

                Select an option for access our bank:

                1 - Register (New Customers)
                2 - Login
                0 - End session
                """);
    }

    public void menuCustomer(String userName) {
        System.out.printf("""
                Welcome %s

                How can we help you today?

                1 - Check Balance
                2 - Transfer
                3 - Statement
                4 - Withdraw
                5 - Deposit
                0 - Logout
                """, userName);
    }

    public void menuAdmin() {
        System.out.println("""
                \n--- ADMIN PANEL ---
                1 - List All Customers
                2 - Edit Customer Data
                0 - Logout
                """);
    }

    public void screenLogin() {
        System.out.println("""
                Welcome back!

                We need some information about you
                before starting:
                """);
    }

    public void screenRegister() {
        System.out.println("""
                Welcome!

                For registration we need some information about you
                """);
    }
}
