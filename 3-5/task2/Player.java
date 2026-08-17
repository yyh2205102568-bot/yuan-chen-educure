package task2;

public class Player {
    String name;   //プレイヤー名
    int hp;        // HP 

   // コンストラクタ
    public Player(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    // プレイヤー名とHPを表示する
    public void displayInfo() {
        System.out.println("プレイヤー名：" + name);
        System.out.println("プレイヤーのHP:" + hp);
    }
}
