package task4;

public class Product {
    String name;   // 商品名（しょうひんめい）
    int price;     // 価格（かかく）

    public Product(String name, int price) {

        this.name = name;

        this.price = price;
    }

    // 商品情報を表示する
    public void displayInfo() {

        System.out.println("商品名：" + name);
        System.out.println("価格：" + price + "円");
    }
}
