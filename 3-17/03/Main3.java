public class Main3 {

    public static void main(String[] args) {

        // 商品「りんご」を初期在庫100個で作成する
        Product product = new Product("りんご", 100);

        // 商品名を表示する
        System.out.println("商品名： " + product.getName());

        // 初期在庫数を表示する
        System.out.println("在庫数： " + product.getStock() + "個");

        // 50個販売する
        product.removeStock(50);

        // 販売後の商品名と在庫数を表示する
        System.out.println("商品名： " + product.getName());
        System.out.println("在庫数： " + product.getStock() + "個");

        // 在庫を10個追加する
        product.addStock(10);

        // 追加後の商品名と在庫数を表示する
        System.out.println("商品名： " + product.getName());
        System.out.println("在庫数： " + product.getStock() + "個");

        // 現在の在庫60個を超える100個を販売してエラーを確認する
        product.removeStock(100);
    }
}