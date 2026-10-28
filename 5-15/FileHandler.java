import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// CSVファイルの読み書きを管理するクラス
public class FileHandler {

    // UTF-8のCSVファイルから単語を読み込む
    public void importFromCSV(
            String filename,
            WordManager wordManager)
            throws IOException, SQLException {

        List<Word> importWords = new ArrayList<>();
        int lineNumber = 0;

        try (BufferedReader reader = Files.newBufferedReader(
                Path.of(filename),
                StandardCharsets.UTF_8)) {

            String line;

            // ファイルを1行ずつ読み込む
            while ((line = reader.readLine()) != null) {

                lineNumber++;

                if (line.isBlank()) {
                    continue;
                }

                // カンマで英単語と日本語訳を分ける
                String[] data = line.split(",", -1);

                // データの形式が正しくない場合
                if (data.length != 2) {
                    throw new IOException(
                            lineNumber
                            + "行目：CSVファイルの形式が正しくありません。");
                }

                String english = data[0].trim();
                String japanese = data[1].trim();

                // 入力内容を確認する
                if (!isValidWord(english, japanese)) {
                    throw new IOException(
                            lineNumber
                            + "行目：単語の内容が正しくありません。");
                }

                importWords.add(new Word(english, japanese));
            }
        }

        // データベースに単語を登録する
        for (Word word : importWords) {
            wordManager.addWord(word);
        }

        System.out.println(
                importWords.size() + "個の単語を読み込みました。");
    }

    // 単語をUTF-8のCSVファイルへ書き出す
    public void exportToCSV(
            String filename,
            WordManager wordManager)
            throws IOException, SQLException {

        List<Word> words = wordManager.getWords();

        try (BufferedWriter writer = Files.newBufferedWriter(
                Path.of(filename),
                StandardCharsets.UTF_8)) {

            for (Word word : words) {

                writer.write(
                        word.getEnglish()
                        + ","
                        + word.getJapanese());

                writer.newLine();
            }
        }

        System.out.println(
                words.size() + "個の単語を保存しました。");
    }

    // 単語の入力内容を確認する
    private boolean isValidWord(String english, String japanese) {

        return !english.isBlank()
                && !japanese.isBlank()
                && english.length() <= 100
                && japanese.length() <= 100
                && !english.contains("\uFFFD")
                && !japanese.contains("\uFFFD");
    }
}