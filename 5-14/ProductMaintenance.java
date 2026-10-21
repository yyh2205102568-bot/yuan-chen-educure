import java.sql.*;

public class ProductMaintenance {

    public static void main(String[] args) {
        // データベース接続情報
        String url = "jdbc:postgresql://localhost:5432/educure_db"; // データベースURL
        String username = "postgres"; // データベースのユーザー名
        String password = "CYV94XpcfV"; // データベースのパスワード

        // ここにコードを書いてください

        // SQL文を準備する
        String updatePriceSQL = "UPDATE products SET price = 0 WHERE stock = 0";
        String deleteSQL = "DELETE FROM products WHERE price >= 200000";
        String updateStockSQL = "UPDATE products SET stock = 20 WHERE price >= 100000 AND stock <= 10";

        // データベースに接続する
        try (Connection con = DriverManager.getConnection(url, username, password)) {

            // 自動コミットを無効にする
            con.setAutoCommit(false);

            try {
                // 在庫が0の商品の価格を0にする
                try (PreparedStatement pstmt = con.prepareStatement(updatePriceSQL)) {
                    int result = pstmt.executeUpdate();
                    System.out.println("影響を受けた行数（在庫数0の商品価格を0に設定）: " + result);
                }

                // 価格が200000以上の商品を削除する
                try (PreparedStatement pstmt = con.prepareStatement(deleteSQL)) {
                    int result = pstmt.executeUpdate();
                    System.out.println("影響を受けた行数（価格が200000以上の商品削除）: " + result);
                }

                // 価格が100000以上、在庫が10以下の商品を更新する
                try (PreparedStatement pstmt = con.prepareStatement(updateStockSQL)) {
                    int result = pstmt.executeUpdate();
                    System.out.println("影響を受けた行数（価格100000以上、在庫数10以下の商品を在庫数20に更新）: " + result);
                }

                // すべての処理が成功した場合
                con.commit();

            } catch (Exception e) {

                // エラーが発生した場合は変更を元に戻す
                con.rollback();

                // エラーの詳細を表示する
                e.printStackTrace();
            }

        } catch (Exception e) {

            // 接続エラーなどを表示する
            e.printStackTrace();
        }
    }
}