import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchProduct {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/educure_db"; // データベースURL
        String user = "postgres"; // データベースのユーザー名
        String password = "CYV94XpcfV"; // データベースのパスワード
        
        String query = "SELECT product_name, price FROM products WHERE price >= ?";
          // データベースに接続する
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = con.prepareStatement(query)) {

            // 1番目の?に100000を設定する
            pstmt.setInt(1, 100000);

            // SELECT文を実行する
            try (ResultSet rs = pstmt.executeQuery()) {

                // 検索結果を1行ずつ取得する
                while (rs.next()) {

                    // 商品名を取得する
                    String productName = rs.getString("product_name");

                    // 価格を取得する
                    int price = rs.getInt("price");

                    // 商品名と価格を表示する
                    System.out.println("商品名: " + productName + ", 価格: " + price);
                }
            }

        // エラーが発生した場合
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}