package a2;
public class Main2 {

    public static void main(String[] args) {

        // 果物倉庫のテスト
        System.out.println("果物倉庫:");

        // String型の商品を格納する倉庫を作成
        Warehouse<String> fruitWarehouse =
                new Warehouse<>();

        // バナナを格納
        fruitWarehouse.store("バナナ");

        // バナナを取り出す
        fruitWarehouse.retrieve();

        // 倉庫が空かどうかを確認
        System.out.println(
                "空チェック: " + fruitWarehouse.isEmpty()
        );


        // 日用品倉庫のテスト
        System.out.println("\n日用品倉庫:");

        // String型の商品を格納する倉庫を作成
        Warehouse<String> dailyWarehouse =
                new Warehouse<>();

        // ティッシュを格納
        dailyWarehouse.store("ティッシュ");

        // ティッシュを取り出す
        dailyWarehouse.retrieve();

        // 倉庫が空かどうかを確認
        System.out.println(
                "空チェック: " + dailyWarehouse.isEmpty()
        );
    }
}