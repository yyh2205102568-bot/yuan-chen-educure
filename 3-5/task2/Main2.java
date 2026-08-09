package task2;

public class Main2 {
public static void main(String[] args) {

        // Playerのインスタンスを生成する
        Player player = new Player("勇者", 30);

        player.displayInfo();

        HealingPotion potion = new HealingPotion();

        potion.heal(player);

        System.out.println("プレイヤーのHP：" + player.hp);
    }
}
