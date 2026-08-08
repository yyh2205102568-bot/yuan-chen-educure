package task3;//amount（金额、参数 / 金額・引数）、deposit()（存钱 / 預ける）、
// withdraw()（取钱 / 引き出す）、getBalance()（获取余额 / 残高を取得する）

public class BankAccount {
    
    int balance;
    
    public int getBalance(){ // 現在の残高を取得する
        
        return balance; // balanceの値を返す（かえす）
    }
    
    public void deposit(int amount){// お金を預ける
        
        balance +=amount;// 残高に預ける金額を足す
        
        System.out.println(amount+"円を預けました");// 預けた金額を表示する
    }
    
    public void withdraw(int amount){// お金を引き出す
        
        if(balance>=amount){// 残高が引き出す金額以上なら
            
            balance -=amount;

            System.out.println(amount+"円引き出しました");

        }else{

            System.out.println("残高が不足しています");
        }
    }

}

