import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// PostgreSQLへの接続とテーブルを管理するクラス
public class DBManager {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/vocabulary_db";

    private static final String USER = "postgres";

    // 学習用のデータベースパスワード
    private static final String PASSWORD = "CYV94XpcfV";

    // データベースの接続を保存する
    private Connection connection;

    // コンストラクタで一度だけ接続する
    public DBManager() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);

        try {
            initializeDatabase();
        } catch (SQLException | RuntimeException e) {
            close();
            throw e;
        }
    }

    // テーブルの作成とUNIQUE制約の設定
    private void initializeDatabase() throws SQLException {

        try (Statement statement = connection.createStatement()) {

            // wordsテーブルを作成する
            statement.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS words (
                        id SERIAL PRIMARY KEY,
                        english VARCHAR(100) NOT NULL,
                        japanese VARCHAR(100) NOT NULL,
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        CONSTRAINT uq_words_english UNIQUE (english)
                    )
                    """);

            // UNIQUE制約がすでに存在するか確認する
            boolean hasUniqueConstraint;

            try (ResultSet result = statement.executeQuery("""
                    SELECT EXISTS (
                        SELECT 1 FROM pg_constraint
                        WHERE conrelid = 'words'::regclass
                          AND conname = 'uq_words_english'
                    )
                    """)) {

                result.next();
                hasUniqueConstraint = result.getBoolean(1);
            }

            // 既存のテーブルにもUNIQUE制約を追加する
            if (!hasUniqueConstraint) {

                // 重複する英単語が存在するか確認する
                try (ResultSet result = statement.executeQuery("""
                        SELECT english FROM words
                        GROUP BY english
                        HAVING COUNT(*) > 1
                        LIMIT 1
                        """)) {

                    if (result.next()) {
                        throw new SQLException(
                                "既存のwordsテーブルに重複した英単語があります: "
                                + result.getString(1)
                                + "。重複を確認してから再実行してください。");
                    }
                }

                statement.executeUpdate("""
                        ALTER TABLE words
                        ADD CONSTRAINT uq_words_english UNIQUE (english)
                        """);
            }

            // 英単語検索用のインデックスを作成する
            statement.executeUpdate(
                    "CREATE INDEX IF NOT EXISTS idx_english ON words (english)");
        }
    }

    // 保存済みの接続を返すだけ
    public Connection getConnection() {
        return connection;
    }

    // アプリ終了時に接続を閉じる
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