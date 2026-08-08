package task1;//ペットがどんなデータを持っているかを定義する
public class Pet {
    String name;
    int energy;

    public void eat(){//ペットの動作内容を定義する。
        energy +=10;//体力を10回復する
        System.out.println(name+"は食事をして元気になった!");
    }
    
     public void play(){//void 戻り値がない
        energy -=20;  
        System.out.println(name+"は遊んで疲れた！");  
    }
    
    public void showEnergy(){
        System.out.println("現在の体力:"+energy);

    }

}
