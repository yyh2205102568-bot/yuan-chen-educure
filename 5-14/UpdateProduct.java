import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateProduct {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/educure_db"; // データベースURL
        String user = "postgres"; // データベースのユーザー名
        String password = "CYV94XpcfV"; // データベースのパスワード

        String updatePriceSQL = "UPDATE products SET price = price - 5000 WHERE product_name = 'タブレット'";
        String updateStockSQL = "UPDATE products SET stock = stock + 5 WHERE price < 50000";
        // ここにコードを書いてください

        // データベースに接続する
        try (Connection con = DriverManager.getConnection(url, user, password)) {

            // タブレットの価格を5000円下げる
            try (PreparedStatement pstmt = con.prepareStatement(updatePriceSQL)) {

                // SQL文を実行して更新した行数を取得する
                int result = pstmt.executeUpdate();

                // 更新した行数を表示する
                System.out.println("価格を値下げした行数: " + result);
            }

            // 価格が50000円未満の商品の在庫を5増やす
            try (PreparedStatement pstmt = con.prepareStatement(updateStockSQL)) {

                // SQL文を実行して更新した行数を取得する
                int result = pstmt.executeUpdate();

                // 更新した行数を表示する
                System.out.println("在庫を増やした行数: " + result);
            }

        // エラーが発生した場合
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}