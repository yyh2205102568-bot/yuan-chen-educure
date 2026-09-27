package a1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Main1 {

    public static void main(String[] args) {

        String fileName = "exercise.csv";

        // CSVファイルを作成
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {

            writer.println("名前,年齢,職業");
            writer.println("山田,28,プログラマー");

            System.out.println("CSVファイルを作成しました: " + fileName);

        } catch (IOException e) {

            e.printStackTrace();

        }

        // CSVファイルを読み込む
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            // ヘッダー行をスキップ
            br.readLine();

            // データの1行目を取得
            String line = br.readLine();

            // カンマで分割
            String[] values = line.split(",");

            // 各要素を1つずつ表示
            for (String value : values) {
                System.out.println(value);
            }

        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}