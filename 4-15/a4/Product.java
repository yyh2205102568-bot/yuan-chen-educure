package a4;

// 商品クラス
public class Product {

    // 商品名
    private String name;

    // 在庫数
    private int stock;

    // コンストラクタ
    public Product(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }

    // 在庫を1個減らす
    public void decreaseStock() {

        // 在庫がある場合のみ減らす
        if (stock > 0) {
            stock--;
        }
    }

    // 在庫数を取得する
    public int getStock() {
        return stock;
    }

    // 商品情報を文字列で返す
    @Override
    public String toString() {
        return name + " (在庫: " + stock + "個)";
    }
}