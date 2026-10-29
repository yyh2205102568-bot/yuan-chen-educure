import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// 単語データを管理するクラス
public class WordManager {

    private DBManager dbManager;

    // コンストラクタ
    public WordManager(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    // 単語を登録する
    public void addWord(Word word) throws SQLException {

        String sql =
                "INSERT INTO words (english, japanese) VALUES (?, ?)";

        Connection connection = dbManager.getConnection();

        // 接続そのものはDBManagerが管理する
        try (PreparedStatement statement =
                connection.prepareStatement(sql)) {

            statement.setString(1, word.getEnglish());
            statement.setString(2, word.getJapanese());

            statement.executeUpdate();
        }
    }

    // 登録されている単語をすべて取得する
    public List<Word> getWords() throws SQLException {

        List<Word> words = new ArrayList<>();

        String sql =
                "SELECT english, japanese FROM words ORDER BY id";

        Connection connection = dbManager.getConnection();

        try (PreparedStatement statement =
                connection.prepareStatement(sql);

             ResultSet result = statement.executeQuery()) {

            while (result.next()) {

                words.add(new Word(
                        result.getString("english"),
                        result.getString("japanese")));
            }
        }

        return words;
    }

    // 単語数を取得する
    public int getWordCount() throws SQLException {

        String sql = "SELECT COUNT(*) FROM words";

        Connection connection = dbManager.getConnection();

        try (PreparedStatement statement =
                connection.prepareStatement(sql);

             ResultSet result = statement.executeQuery()) {

            if (result.next()) {
                return result.getInt(1);
            }
        }

        return 0;
    }

    // 指定された英単語を削除する
    public boolean deleteWord(String english)
            throws SQLException {

        String sql =
                "DELETE FROM words WHERE english = ?";

        Connection connection = dbManager.getConnection();

        try (PreparedStatement statement =
                connection.prepareStatement(sql)) {

            statement.setString(1, english);

            return statement.executeUpdate() > 0;
        }
    }

    // 指定された英単語の日本語訳を更新する
    public boolean updateWord(
            String english,
            String newJapanese) throws SQLException {

        String sql =
                "UPDATE words SET japanese = ? WHERE english = ?";

        Connection connection = dbManager.getConnection();

        try (PreparedStatement statement =
                connection.prepareStatement(sql)) {

            statement.setString(1, newJapanese);
            statement.setString(2, english);

            return statement.executeUpdate() > 0;
        }
    }
}