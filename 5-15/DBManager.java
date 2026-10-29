import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// データベース接続を管理するクラス
public class DBManager {

    private Connection connection;

    private final String URL =
            "jdbc:postgresql://localhost:5432/vocabulary_db";

    private final String USER = "postgres";

    // 学習用のデータベースパスワード
    private final String PASSWORD = "CYV94XpcfV";

    // コンストラクタ
    public DBManager() throws SQLException {
        initializeDatabase();
    }

    // wordsテーブルとインデックスを初期化する
    private void initializeDatabase() throws SQLException {

        String createTable = """
                CREATE TABLE IF NOT EXISTS words (
                    id SERIAL PRIMARY KEY,
                    english VARCHAR(100) NOT NULL,
                    japanese VARCHAR(100) NOT NULL,
                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                )
                """;

        String createIndex =
                "CREATE INDEX IF NOT EXISTS idx_english "
                + "ON words (english)";

        try (Statement statement =
                getConnection().createStatement()) {

            statement.executeUpdate(createTable);
            statement.executeUpdate(createIndex);
        }
    }

    // データベース接続を取得する
    public Connection getConnection() throws SQLException {

        if (connection == null
                || connection.isClosed()
                || !connection.isValid(1)) {

            if (connection != null) {

                try {
                    connection.close();

                } catch (SQLException e) {
                    // 接続が切れている場合は新しい接続を作成する
                }
            }

            connection = DriverManager.getConnection(
                    URL, USER, PASSWORD);
        }

        return connection;
    }

    // データベース接続を閉じる
    public void close() {

        if (connection != null) {

            try {

                connection.close();

            } catch (SQLException e) {

                System.out.println(
                        "データベース接続の終了に失敗しました: "
                        + e.getMessage());

            } finally {

                connection = null;
            }
        }
    }
}