package task6;

public class Account {
    String accountNumber; // 口座番号
    int balance;          // 残高

    // コンストラクタ
    // 口座番号を設定し、残高を0で初期化する
    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    // 入金メソッド
    public void deposit(int amount) {
        balance += amount;
    }

    // 出金メソッド
    public void withdraw(int amount) {
        balance -= amount;
    }
}
