package a3;

// ジェネリックな在庫管理クラス
public class Inventory<T> {

    // 商品を格納するフィールド
    private T item;

    // 商品カテゴリ
    private final ProductCategory category;

    // コンストラクタ
    public Inventory(ProductCategory category) {
        this.category = category;
    }

    // 商品を入荷するメソッド
    public void stockIn(T item) {

        // 商品を設定
        this.item = item;

        // 入荷情報を表示
        System.out.println(
                category.getDisplayName()
                + "コーナー: "
                + item
                + "を入荷"
        );
    }

    // 商品を出荷するメソッド
    public T stockOut() {

        // 現在の商品を一時変数に保存
        T temp = item;

        // 在庫を空にする
        item = null;

        // 保存しておいた商品を返す
        return temp;
    }

    // 現在の在庫を取得するメソッド
    public T getCurrentStock() {
        return item;
    }
}