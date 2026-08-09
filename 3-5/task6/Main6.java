package task6;

public class Main6 {
    public static void main(String[] args) {

        // 口座を作成
        Account account = new Account("12345");

        // 1000円入金
        account.deposit(1000);

        // 口座番号と残高を表示
        System.out.println("口座番号：" + account.accountNumber);
        System.out.println("残高：" + account.balance + "円");

        // 500円出金
        account.withdraw(500);

        // 出金後の残高を表示
        System.out.println("出金後残高：" + account.balance + "円");
    }  
}
