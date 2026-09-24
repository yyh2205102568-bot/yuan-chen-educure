import java.io.FileWriter;
import java.io.IOException;

public class Main1 {

    public static void main(String[] args) {

        try {
            // ファイルを作成して開く
            FileWriter writer = new FileWriter("exercise.txt");

            // ファイルに文字を書き込む
            writer.write("Hello, World!");

            // ファイルを閉じる
            writer.close();

            System.out.println("ファイルに書き込みが完了しました。");

        } catch (IOException e) {

            // エラーメッセージと原因を表示する
            System.out.println("ファイルの書き込み中にエラーが発生しました。");
            System.out.println("エラーの詳細：" + e.getMessage());

        }
    }
}