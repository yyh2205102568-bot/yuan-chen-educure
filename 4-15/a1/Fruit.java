package a1;

public class Fruit {

    // 果物の名前
    private String name;

    // 果物の価格
    private int price;

    // 果物の名前と価格を設定する
    public void setData(String name, int price) {
        this.name = name;
        this.price = price;
    }

    // 果物の情報を表示する
    public void displayInfo() {
        System.out.println("果物: " + name);
        System.out.println("価格: " + price + "円");
    }
}