public class Product {

    // 商品名を保存するフィールド
    private String name;

    // 在庫数を保存するフィールド
    private int stock;

    // 商品名と初期在庫数を設定するコンストラクタ
    public Product(String name, int stock) {
        this.name = name;

        // 初期在庫数が正の整数か確認する
        if (stock <= 0) {
            System.out.println("エラー： 在庫数は正の整数で設定してください");
            this.stock = 0;
        } else {
            this.stock = stock;
        }
    }

    // 商品名を取得するgetterメソッド
    public String getName() {
        return this.name;
    }

    // 在庫数を取得するgetterメソッド
    public int getStock() {
        return this.stock;
    }

    // 在庫を追加するメソッド
    public void addStock(int amount) {

        // 追加する個数が正の整数か確認する
        if (amount <= 0) {
            System.out.println("エラー： 在庫数は正の整数で設定してください");
            return;
        }

        // 在庫を追加する
        this.stock += amount;

        System.out.println(amount + "個追加しました");
    }

    // 在庫を減らすメソッド
    public void removeStock(int amount) {

        // 販売する個数が正の整数か確認する
        if (amount <= 0) {
            System.out.println("エラー： 在庫数は正の整数で設定してください");
            return;
        }

        // 現在の在庫数を超える場合は販売しない
        if (amount > this.stock) {
            System.out.println("エラー： 在庫が不足しています");
            return;
        }

        // 在庫を減らす
        this.stock -= amount;

        System.out.println(amount + "個販売しました");
    }
}