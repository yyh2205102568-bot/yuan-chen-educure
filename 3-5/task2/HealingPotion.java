package task2;

public class HealingPotion {

    // Player型の引数を受け取る
    public void heal(Player player) {

        // HPを50回復する
        player.hp += 50;

        System.out.println("回復ポーションを使用しました");
    }
}
