package a1;

public class Main1 {

    public static void main(String[] args) {

        // Fruitのインスタンスを作成する
        Fruit fruit = new Fruit();

        // 果物の名前と価格を設定する
        fruit.setData("りんご", 150);

        // 果物の情報を表示する
        fruit.displayInfo();
    }
}
