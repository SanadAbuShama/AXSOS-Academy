public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    @SuppressWarnings("unused")
    private String accountNumber;
    @SuppressWarnings("unused")
    private static int numAccounts = 0;
    private static int totalBalance = 0;

    public BankAccount() {
        accountNumber = createNumber();
        numAccounts++;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void deposit(String account, double amount) {
        if (account.equals("checking")) {
            checkingBalance += amount;
        } else {
            savingsBalance += amount;
        }

        totalBalance += amount;
    }

    public void withdraw(String account, double amount) {
        if (account.equals("checking") && checkingBalance >= amount) {
            checkingBalance -= amount;
            totalBalance -= amount;
        } else {
            if (savingsBalance >= amount) {
                savingsBalance -= amount;
                totalBalance -= amount;
            }
        }

    }

    public double showBalance() {
        return totalBalance;
    }

    private String createNumber() {
        String str = "";
        for (int i = 0; i < 10; i++) {
            str += i;
        }
        return str;
    }
}
