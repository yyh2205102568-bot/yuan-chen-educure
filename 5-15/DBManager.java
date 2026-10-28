import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// PostgreSQLへの接続を管理するクラス
public class DBManager {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/vocabulary_db";

    private static final String USER = "postgres";

    // 学習用のデータベースパスワード
    private static final String PASSWORD = "CYV94XpcfV";

    // データベースへ接続する
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // 単語テーブルとインデックスを作成する
    public void initializeDatabase() throws SQLException {

        String createTable = """
                CREATE TABLE IF NOT EXISTS words (
                    id SERIAL PRIMARY KEY,
                    english VARCHAR(100) NOT NULL,
                    japanese VARCHAR(100) NOT NULL,
                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                )
                """;

        String createIndex =
                "CREATE INDEX IF NOT EXISTS idx_words_english ON words (english)";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(createTable);
            statement.executeUpdate(createIndex);
        }
    }

    // 接続は各メソッドで自動的に閉じる
    public void close() {
        // ここでは特別な処理は必要ない
    }
}