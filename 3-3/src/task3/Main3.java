package task3;

public class Main3 {
    public static void main(String[] args) {
        
        BankAccount account=new BankAccount(); // 银行账户を1つ作る

        System.out.println("残高:"+account.getBalance()+"円");// 初始余额を表示する

        account.deposit(10000);// 10000円を預ける（deposit）預ける

        System.out.println("残高:"+account.getBalance()+"円");//getBalance　残高

        account.withdraw(3000);//withdraw 引き出す

        System.out.println("残高:"+account.getBalance()+"円");

        account.withdraw(8000);


    }
}
