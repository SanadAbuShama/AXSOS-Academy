public class TestAccount {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.deposit("checking", 100);
        account.deposit("savings", 50);
        System.out.println(account.getCheckingBalance());
        System.out.println(account.getSavingsBalance());
        System.out.println("Total balance is: " + account.showBalance());
        account.withdraw("checking", 70);
        account.withdraw("savings", 10);
        System.out.println(account.getCheckingBalance());
        System.out.println(account.getSavingsBalance());
        System.out.println("Total balance is: " + account.showBalance());
    }
}
