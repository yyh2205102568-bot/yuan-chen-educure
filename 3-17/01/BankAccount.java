public class BankAccount {

    // 口座残高を保存するフィールド
    // privateにすることで、外部から直接変更できないようにする
    private int balance;

    // コンストラクタ
    // 銀行口座を作成するときに初期残高を設定する
    public BankAccount(int balance) {
        this.balance = balance;
    }

    // 現在の残高を取得するgetterメソッド
    public int getBalance() {
        return this.balance;
    }

    // 入金するメソッド
    public void deposit(int amount) {

        // 0以下の値が指定された場合は入金しない
        if (amount <= 0) {
            System.out.println("入金額は正の整数を指定してください。");
            return;
        }

        // 残高に入金額を加算する
        this.balance += amount;
        System.out.println(amount + "円入金しました");
    }

    // 出金するメソッド
    public void withdraw(int amount) {

        // 0以下の値が指定された場合は出金しない
        if (amount <= 0) {
            System.out.println("出金額は正の整数を指定してください。");
            return;
        }

        // 残高より大きい金額は出金できない
        if (amount > this.balance) {
            System.out.println("引き出しに失敗しました。残高が不足しています。");
            return;
        }

        // 残高から出金額を減算する
        this.balance -= amount;
        System.out.println(amount + "円引き出しました");
    }
}