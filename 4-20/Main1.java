import java.io.FileWriter;
import java.io.IOException;

public class Main1 {
    public static void main(String[] args){
        try {
            // STEP1：ファイルを作成して開く
            FileWriter writer = new FileWriter("exercise.txt");

            // STEP2：ファイルに文字を書き込む
            writer.write("Hello, World!");

            // STEP3：ファイルを閉じる
            writer.close();

            // 書き込み完了メッセージを表示する
            System.out.println("ファイルに書き込みが完了しました。");

        } catch (IOException e) {
            // エラーが発生した場合
            System.out.println("ファイルの書き込み中にエラーが発生しました。");
        }

    }
}
