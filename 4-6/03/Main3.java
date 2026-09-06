import java.util.HashMap;

public class Main3 {
    public static void main(String[] args) {

        // 商品名と在庫数を管理するHashMapを作成
        HashMap<String, Integer> stock = new HashMap<>();

        // 商品を入荷（在庫を追加）
        stock.put("おにぎり", 15);
        stock.put("サンドイッチ", 8);
        stock.put("お弁当", 5);

        // 現在の在庫状況を表示
        System.out.println("在庫状況:" + stock);

        // おにぎりを1個販売
        int onigiriStock = stock.get("おにぎり");
        stock.put("おにぎり", onigiriStock - 1);

        System.out.println("おにぎりを1個販売しました");

        // 更新後の在庫状況を表示
        System.out.println("在庫状況:" + stock);

        // アイスクリームの在庫確認
        boolean hasIceCream = stock.containsKey("アイスクリーム");

        System.out.println("アイスクリームは在庫がありますか？:" + hasIceCream);
    }
}