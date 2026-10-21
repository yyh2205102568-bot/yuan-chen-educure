import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertProduct {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/educure_db";
        String user = "postgres";
        String password = "CYV94XpcfV";

        String insertSQL = "INSERT INTO products (product_name, price, stock) VALUES (?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, user, password);
        PreparedStatement pstmt = con.prepareStatement(insertSQL)) {
    
        
        pstmt.setString(1, "スマートフォン");
        pstmt.setInt(2, 80000);
        pstmt.setInt(3, 30);
        int result = pstmt.executeUpdate();
        
        if (result > 0) {
            System.out.println("商品が正常に追加されました。");
            }
            
        } catch (Exception e) {
        e.printStackTrace();
        } 
} 

}