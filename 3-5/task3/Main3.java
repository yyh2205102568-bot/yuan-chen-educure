package task3;

public class Main3 {
     public static void main(String[] args) {
        
        // BankAccountのインスタンスを1つ生成する
        BankAccount account1 = new BankAccount(1000);

        // account2も同じインスタンスを参照する
        BankAccount account2 = account1;

        account1.balance = 3000;

        System.out.println("口座1の残高:" + account1.balance);
        System.out.println("口座2の残高:" + account2.balance);
    }
}
