package a2;

// ジェネリックな倉庫クラス
public class Warehouse<T> {

    // 商品を格納するフィールド
    private T item;

    // 商品を格納するメソッド
    public void store(T item) {
        this.item = item;
        System.out.println("商品追加: " + item);
    }

    // 商品を取り出すメソッド
    public T retrieve() {

        // 現在の商品を一時変数に保存
        T temp = item;

        // 倉庫を空にする
        item = null;

        // 取り出した商品を表示
        System.out.println("取り出し: " + temp);

        // 保存しておいた商品を返す
        return temp;
    }

    // 倉庫が空かどうかを確認するメソッド
    public boolean isEmpty() {
        return item == null;
    }
}