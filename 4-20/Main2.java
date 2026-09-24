import java.io.FileReader;
import java.io.IOException;

public class Main2 {
    public static void main(String[] args) {

        try {
            // STEP1：exercise.txtファイルを開く
            FileReader reader = new FileReader("exercise.txt");

            // STEP2：ファイルの内容を1文字ずつ読み取る
            int data;

            while ((data = reader.read()) != -1) {
                System.out.print((char) data);
            }

            // STEP3：ファイルを閉じる
            reader.close();

        } catch (IOException e) {
            // ファイルの読み込み中にエラーが発生した場合
            System.out.println("ファイルの読み込み中にエラーが発生しました。");
        }
    }
}