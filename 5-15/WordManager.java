import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// データベースの単語を管理するクラス
public class WordManager {

    private final DBManager dbManager;

    // コンストラクタ
    public WordManager(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    // 単語を登録する
    public void addWord(Word word) throws SQLException {

        String sql =
                "INSERT INTO words (english, japanese) VALUES (?, ?)";

        try (Connection connection = dbManager.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, word.getEnglish());
            statement.setString(2, word.getJapanese());

            statement.executeUpdate();
        }
    }

    // すべての単語を取得する
    public List<Word> getWords() throws SQLException {

        List<Word> words = new ArrayList<>();

        String sql =
                "SELECT english, japanese FROM words ORDER BY id";

        try (Connection connection = dbManager.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {

            while (result.next()) {

                String english = result.getString("english");
                String japanese = result.getString("japanese");

                words.add(new Word(english, japanese));
            }
        }

        return words;
    }

    // 登録されている単語数を取得する
    public int getWordCount() throws SQLException {

        String sql = "SELECT COUNT(*) FROM words";

        try (Connection connection = dbManager.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {

            if (result.next()) {
                return result.getInt(1);
            }
        }

        return 0;
    }

    // 英単語を指定して削除する
    public boolean deleteWord(String english) throws SQLException {

        String sql = "DELETE FROM words WHERE english = ?";

        try (Connection connection = dbManager.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, english);

            return statement.executeUpdate() > 0;
        }
    }

    // 英単語を指定して日本語訳を更新する
    public boolean updateWord(String english, String japanese)
            throws SQLException {

        String sql =
                "UPDATE words SET japanese = ? WHERE english = ?";

        try (Connection connection = dbManager.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, japanese);
            statement.setString(2, english);

            return statement.executeUpdate() > 0;
        }
    }
}