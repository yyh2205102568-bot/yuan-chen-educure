package a4;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// 在庫管理クラス
public class InventoryManager {

    // 商品を格納するMap
    private Map<String, Product> inventory = new HashMap<>();

    // 商品を追加するメソッド
    public void addProduct(String name, int stock) {

        // 新しい商品を作成
        Product product = new Product(name, stock);

        // 在庫に追加
        inventory.put(name, product);

        // 入荷メッセージを表示
        System.out.println(name + "を入荷しました");
    }

    // 商品を検索するメソッド
    private Optional<Product> findProduct(String name) {

        // 商品が存在しない場合は空のOptionalになる
        return Optional.ofNullable(inventory.get(name));
    }

    // 商品を販売するメソッド
    public void sellProduct(String name) {

        // 商品を検索
        Optional<Product> product = findProduct(name);

        // 商品が存在する場合
        if (product.isPresent()) {

            // Productを取り出す
            Product foundProduct = product.get();

            // 在庫を1個減らす
            foundProduct.decreaseStock();

            System.out.println(
                    name + "の販売: 在庫から1個減少"
            );

        } else {

            // 商品が存在しない場合
            System.out.println("商品が見つかりません");
        }
    }
}