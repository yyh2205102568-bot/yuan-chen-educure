import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UpdateStock {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/educure_db"; // データベースURL
        String user = "postgres"; // データベースのユーザー名
        String password = "CYV94XpcfV"; // データベースのパスワード

        // 在庫がすべて0かを確認するSQL
        String checkStockSQL = "SELECT COUNT(*) FROM products WHERE stock > 0";
        String updateSQL = "UPDATE products SET stock = CASE WHEN stock >= 10 THEN stock - 10 ELSE 0 END";

        // ここにコードを書いてください

        // データベースに接続する
        try (Connection con = DriverManager.getConnection(url, user, password)) {

            // 在庫がある商品を確認する
            try (PreparedStatement pstmt = con.prepareStatement(checkStockSQL);
                 ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {
                    int count = rs.getInt(1);

                    // 在庫がすべて0の場合
                    if (count == 0) {
                        System.out.println("更新できる商品がありません。");
                        return;
                    }
                }
            }

            // 在庫を10減らす
            try (PreparedStatement pstmt = con.prepareStatement(updateSQL)) {

                int result = pstmt.executeUpdate();

                // 更新が成功した場合
                if (result > 0) {
                    System.out.println("在庫が正常に更新されました。");
                }
            }

        } catch (Exception e) {
            // エラーの詳細を表示する
            e.printStackTrace();
        }
    }
}