package a2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main2 {

    public static void main(String[] args) {

        // プロパティファイルのパス
        String filePath = "a2/exercise.properties";

        // Propertiesオブジェクトを作成
        Properties properties = new Properties();

        try (FileInputStream input = new FileInputStream(filePath)) {

            // プロパティファイルを読み込む
            properties.load(input);

            // usernameとpasswordを取得
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");

            // 取得した値を表示
            System.out.println("username=" + username);
            System.out.println("password=" + password);

        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}