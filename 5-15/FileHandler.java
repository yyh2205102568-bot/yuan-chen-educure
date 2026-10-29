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

    // 単語リストをCSVファイルに保存する
    public void exportToCSV(
            List<Word> words,
            String filename) throws IOException {

        // UTF-8でCSVファイルを作成する
        try (BufferedWriter writer =
                Files.newBufferedWriter(
                        Path.of(filename),
                        StandardCharsets.UTF_8)) {

            // 登録されている単語を1行ずつ書き出す
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

    // CSVファイルから単語を一括登録する
    public void importFromCSV(
            String filename,
            WordManager wordManager)
            throws IOException, SQLException {

        List<Word> importWords = new ArrayList<>();

        int lineNumber = 0;

        // UTF-8でCSVファイルを読み込む
        try (BufferedReader reader =
                Files.newBufferedReader(
                        Path.of(filename),
                        StandardCharsets.UTF_8)) {

            String line;

            // CSVファイルを1行ずつ読み込む
            while ((line = reader.readLine()) != null) {

                lineNumber++;

                // 空白行は読み飛ばす
                if (line.isBlank()) {
                    continue;
                }

                // カンマで英単語と日本語訳を分割する
                String[] data = line.split(",", -1);

                // CSV形式を確認する
                if (data.length != 2) {

                    throw new IOException(
                            lineNumber
                            + "行目：CSVファイルの形式が正しくありません。");
                }

                String english = data[0].trim();
                String japanese = data[1].trim();

                // 空文字・文字数・文字化けを確認する
                if (english.isEmpty()
                        || japanese.isEmpty()
                        || english.length() > 100
                        || japanese.length() > 100
                        || english.contains("\uFFFD")
                        || japanese.contains("\uFFFD")) {

                    throw new IOException(
                            lineNumber
                            + "行目：単語の内容が正しくありません。");
                }

                // 登録する単語をリストに追加する
                importWords.add(
                        new Word(english, japanese));
            }
        }

        // データベースに単語を登録する
        for (Word word : importWords) {

            wordManager.addWord(word);
        }

        System.out.println(
                importWords.size()
                + "個の単語を読み込みました。");
    }
}