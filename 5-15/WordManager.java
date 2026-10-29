import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// 単語の入力チェックとデータベース操作を管理するクラス
public class WordManager {

    private final DBManager dbManager;

    // コンストラクタ
    public WordManager(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    // 単語を登録する
    public void addWord(Word word) throws SQLException {

        if (word == null) {
            throw new IllegalArgumentException(
                    "エラー: 単語が指定されていません。");
        }

        String english = word.getEnglish();
        String japanese = word.getJapanese();

        // 英単語が空か確認する
        if (english == null || english.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "エラー: 英単語が入力されていません。");
        }

        // 日本語訳が空か確認する
        if (japanese == null || japanese.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "エラー: 日本語訳が入力されていません。");
        }

        // 前後の空白を取り除く
        english = english.trim();
        japanese = japanese.trim();

        // 英単語の文字数を確認する
        if (english.length() > 100) {
            throw new IllegalArgumentException(
                    "エラー: 英単語が100文字を超えています。");
        }

        // 日本語訳の文字数を確認する
        if (japanese.length() > 100) {
            throw new IllegalArgumentException(
                    "エラー: 日本語訳が100文字を超えています。");
        }

        // 英単語にカンマが含まれていないか確認する
        if (english.contains(",")) {
            throw new IllegalArgumentException(
                    "エラー: 英単語にカンマ (,) は使用できません。");
        }

        // 日本語訳にカンマが含まれていないか確認する
        if (japanese.contains(",")) {
            throw new IllegalArgumentException(
                    "エラー: 日本語訳にカンマ (,) は使用できません。");
        }

        // DBManagerで保存した接続を取得する
        Connection connection = dbManager.getConnection();

        // 同じ英単語が登録されているか確認する
        try (PreparedStatement statement =
                connection.prepareStatement(
                        "SELECT 1 FROM words WHERE english = ?")) {

            statement.setString(1, english);

            try (ResultSet result = statement.executeQuery()) {

                if (result.next()) {
                    throw new IllegalArgumentException(
                            "エラー: 英単語 '" + english
                            + "' はすでに登録されています。");
                }
            }
        }

        // 最大1000語まで登録可能
        if (getWordCount() >= 1000) {
            throw new IllegalArgumentException(
                    "エラー: 登録できる単語は1000個までです。");
        }

        // データベースに登録する
        try (PreparedStatement statement =
                connection.prepareStatement(
                        "INSERT INTO words (english, japanese) "
                        + "VALUES (?, ?)")) {

            statement.setString(1, english);
            statement.setString(2, japanese);
            statement.executeUpdate();

        } catch (SQLException e) {

            // UNIQUE制約による重複登録エラー
            if ("23505".equals(e.getSQLState())) {
                throw new IllegalArgumentException(
                        "エラー: 英単語 '" + english
                        + "' はすでに登録されています。", e);
            }

            throw e;
        }
    }

    // 登録されている単語をすべて取得する
    public List<Word> getWords() throws SQLException {

        List<Word> words = new ArrayList<>();

        Connection connection = dbManager.getConnection();

        try (PreparedStatement statement =
                connection.prepareStatement(
                        "SELECT english, japanese FROM words ORDER BY id");

             ResultSet result = statement.executeQuery()) {

            while (result.next()) {
                words.add(new Word(
                        result.getString("english"),
                        result.getString("japanese")));
            }
        }

        return words;
    }

    // 登録されている単語数を取得する
    public int getWordCount() throws SQLException {

        Connection connection = dbManager.getConnection();

        try (PreparedStatement statement =
                connection.prepareStatement(
                        "SELECT COUNT(*) FROM words");

             ResultSet result = statement.executeQuery()) {

            if (result.next()) {
                return result.getInt(1);
            }
        }

        return 0;
    }

    // 単語を削除する
    public boolean deleteWord(String english) throws SQLException {

        // 英単語が空か確認する
        if (english == null || english.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "エラー: 英単語が入力されていません。");
        }

        english = english.trim();

        // 文字数を確認する
        if (english.length() > 100) {
            throw new IllegalArgumentException(
                    "エラー: 英単語が100文字を超えています。");
        }

        // カンマを確認する
        if (english.contains(",")) {
            throw new IllegalArgumentException(
                    "エラー: 英単語にカンマ (,) は使用できません。");
        }

        Connection connection = dbManager.getConnection();

        // データベースから削除する
        try (PreparedStatement statement =
                connection.prepareStatement(
                        "DELETE FROM words WHERE english = ?")) {

            statement.setString(1, english);

            // 削除対象がない場合
            if (statement.executeUpdate() == 0) {
                throw new IllegalArgumentException(
                        "エラー: 指定された英単語 '"
                        + english + "' が見つかりません。");
            }
        }

        return true;
    }

    // 日本語訳を更新する
    public boolean updateWord(
            String english, String newJapanese) throws SQLException {

        // 英単語が空か確認する
        if (english == null || english.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "エラー: 英単語が入力されていません。");
        }

        // 日本語訳が空か確認する
        if (newJapanese == null
                || newJapanese.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "エラー: 日本語訳が入力されていません。");
        }

        english = english.trim();
        newJapanese = newJapanese.trim();

        // 英単語の文字数を確認する
        if (english.length() > 100) {
            throw new IllegalArgumentException(
                    "エラー: 英単語が100文字を超えています。");
        }

        // 日本語訳の文字数を確認する
        if (newJapanese.length() > 100) {
            throw new IllegalArgumentException(
                    "エラー: 日本語訳が100文字を超えています。");
        }

        // 英単語のカンマを確認する
        if (english.contains(",")) {
            throw new IllegalArgumentException(
                    "エラー: 英単語にカンマ (,) は使用できません。");
        }

        // 日本語訳のカンマを確認する
        if (newJapanese.contains(",")) {
            throw new IllegalArgumentException(
                    "エラー: 日本語訳にカンマ (,) は使用できません。");
        }

        Connection connection = dbManager.getConnection();

        // 日本語訳を更新する
        try (PreparedStatement statement =
                connection.prepareStatement(
                        "UPDATE words SET japanese = ? WHERE english = ?")) {

            statement.setString(1, newJapanese);
            statement.setString(2, english);

            // 更新対象がない場合
            if (statement.executeUpdate() == 0) {
                throw new IllegalArgumentException(
                        "エラー: 指定された英単語 '"
                        + english + "' が見つかりません。");
            }
        }

        return true;
    }
}