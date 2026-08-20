public class SavingsAccount implements BankAccount {

    String accountHolder;
    int balance;

    public SavingsAccount(String accountHolder, int balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    @Override
    public void deposit(int amount) {

        if (amount <= 0) {
            System.out.println("入金額は1円以上にしてください");
            return;
        }

        balance += amount;
        System.out.println(amount + "円入金しました");
    }

    @Override
    public void withdraw(int amount) {

        if (amount <= 0) {
            System.out.println("出金額は1円以上にしてください");
            return;
        }

        if (amount > balance) {
            System.out.println("残高不足のため出金できません");
            return;
        }

        balance -= amount;
        System.out.println(amount + "円出金しました");
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public void displayAccountInfo() {
        System.out.println("口座名義人：" + accountHolder);
        System.out.println("残高：" + balance);
    }
}