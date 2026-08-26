public class Main1 {

    public static void main(String[] args) {

        // 初期残高1000円の銀行口座を作成する
        BankAccount account = new BankAccount(1000);

        // 現在の残高を表示する
        System.out.println("残高：" + account.getBalance() + "円");

        // 2000円を入金する
        account.deposit(2000);

        // 入金後の残高を表示する
        System.out.println("残高：" + account.getBalance() + "円");

        // 1500円を出金する
        account.withdraw(1500);

        // 出金後の残高を表示する
        System.out.println("残高：" + account.getBalance() + "円");

        // 残高より大きい金額を出金してみる
        account.withdraw(2000);
    }
}