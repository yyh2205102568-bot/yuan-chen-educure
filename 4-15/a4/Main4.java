package a4;

public class Main4 {

    public static void main(String[] args) {

        // 在庫管理クラスのインスタンスを作成
        InventoryManager manager =
                new InventoryManager();

        // バナナを5個入荷
        manager.addProduct("バナナ", 5);

        // バナナを1個販売
        manager.sellProduct("バナナ");

        // 存在しない商品を検索・販売
        System.out.print("存在しない商品の検索: ");
        manager.sellProduct("りんご");
    }
}