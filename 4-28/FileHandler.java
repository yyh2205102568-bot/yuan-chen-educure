// ファイル操作に必要なクラスを読み込む
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

// UTF-8を使用するために読み込む
import java.nio.charset.StandardCharsets;

// ファイルを扱うために読み込む
import java.nio.file.Files;
import java.nio.file.Path;

// Listを使用するために読み込む
import java.util.List;

// CSVファイルの読み書きを管理するクラス
public class FileHandler {

    // CSVファイルから単語を読み込むメソッド
    public int importFromCSV(
            String filename,
            WordManager wordManager) throws IOException {

        // 読み込んだ単語数
        int count = 0;

        // UTF-8でCSVファイルを開く
        try (BufferedReader reader = Files.newBufferedReader(
                Path.of(filename),
                StandardCharsets.UTF_8)) {

            // CSVファイルの1行分を保存する変数
            String line;

            // ファイルを1行ずつ読み込む
            while ((line = reader.readLine()) != null) {

                // 空行の場合は読み飛ばす
                if (line.trim().isEmpty()) {
                    continue;
                }

                // カンマで英単語と日本語訳に分割する
                String[] data = line.split(",", -1);

                // データが2つでない場合はエラーにする
                if (data.length != 2) {
                    throw new IOException(
                            "CSVファイルの形式が正しくありません。");
                }

                // 英単語を取得する
                String english = data[0];

                // 日本語訳を取得する
                String japanese = data[1];

                // 英単語または日本語訳が空の場合はエラーにする
                if (english.isEmpty() || japanese.isEmpty()) {
                    throw new IOException(
                            "CSVファイルの形式が正しくありません。");
                }

                // 読み込んだデータからWordを作成する
                Word word = new Word(english, japanese);

                // WordManagerに単語を追加する
                wordManager.addWord(word);

                // 読み込んだ単語数を1増やす
                count++;
            }
        }

        // 読み込んだ単語数を返す
        return count;
    }

    // 登録されている単語をCSVファイルに保存するメソッド
    public int exportToCSV(
            List<Word> words,
            String filename) throws IOException {

        // UTF-8でCSVファイルを作成する
        try (BufferedWriter writer = Files.newBufferedWriter(
                Path.of(filename),
                StandardCharsets.UTF_8)) {

            // 登録されている単語を1件ずつ処理する
            for (Word word : words) {

                // 英単語を書き込む
                writer.write(word.getEnglish());

                // 区切り文字のカンマを書き込む
                writer.write(",");

                // 日本語訳を書き込む
                writer.write(word.getJapanese());

                // CRLFで改行する
                writer.write("\r\n");
            }
        }

        // 保存した単語数を返す
        return words.size();
    }
}