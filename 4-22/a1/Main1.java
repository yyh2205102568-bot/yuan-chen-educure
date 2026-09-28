package a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main1 {

    public static void main(String[] args) {

        String fileName = "a1/exercise.csv";

        try (BufferedReader br =
                new BufferedReader(new FileReader(fileName))) {

            // ヘッダー行をスキップする
            br.readLine();

            // データの1行目を読み込む
            String line = br.readLine();

            // データが存在し、空でない場合のみ分割する
            if (line != null && !line.trim().isEmpty()) {

                String[] values = line.split(",");

                for (String value : values) {
                    System.out.println(value);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}