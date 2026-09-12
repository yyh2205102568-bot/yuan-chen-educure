package a1;

public class GameItem {

    private String name;
    private int price;

    public GameItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "[" + name + "] 価格: " + price + "G";
    }
}