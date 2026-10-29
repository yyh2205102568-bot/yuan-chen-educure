
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.List;

// CSVファイルの読み込みと書き出しを管理するクラス
public class FileHandler {

    // CSVファイルから単語を読み込む
    // 登録できた件数を戻り値として返す
    public int importFromCSV(
            String filename, WordManager wordManager)
            throws IOException, SQLException {

        // 登録成功件数
        int count = 0;

        // 現在の行番号
        int lineNumber = 0;

        // UTF-8形式でCSVファイルを開く
        try (BufferedReader reader =
                Files.newBufferedReader(
                        Path.of(filename),
                        StandardCharsets.UTF_8)) {

            String line;

            // ファイルの最後まで1行ずつ読み込む
            while ((line = reader.readLine()) != null) {

                lineNumber++;

                // 空行の場合は読み飛ばす
                if (line.isBlank()) {
                    System.out.println(
                            lineNumber
                            + "行目を読み飛ばしました（空行）。");

                    continue;
                }

                // カンマで英単語と日本語訳に分割する
                String[] columns = line.split(",", -1);

                // カンマがない、または多すぎる場合
                if (columns.length != 2) {

                    System.out.println(
                            lineNumber
                            + "行目：CSVファイルの形式が"
                            + "正しくありません。読み飛ばします。");

                    continue;
                }

                try {

                    // 単語オブジェクトを作成する
                    Word word = new Word(
                            columns[0], columns[1]);

                    // 入力チェック・重複チェックは
                    // WordManagerで行う
                    wordManager.addWord(word);

                    // 登録成功時だけ件数を増やす
                    count++;

                } catch (IllegalArgumentException e) {

                    // 不正な入力や登録済みの単語は
                    // 処理を中断せず読み飛ばす
                    System.out.println(
                            lineNumber
                            + "行目を読み飛ばしました: "
                            + e.getMessage());
                }
            }
        }

        // 実際に登録できた件数を返す
        return count;
    }

    // 単語一覧をCSVファイルに保存する
    public void exportToCSV(
            List<Word> words, String filename)
            throws IOException {

        // UTF-8形式でファイルを書き込む
        try (BufferedWriter writer =
                Files.newBufferedWriter(
                        Path.of(filename),
                        StandardCharsets.UTF_8)) {

            // 単語を1件ずつCSV形式で書き込む
            for (Word word : words) {

                writer.write(
                        word.getEnglish()
                        + ","
                        + word.getJapanese());

                writer.newLine();
            }
        }
    }
}