package a2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Main2 {

    public static void main(String[] args) {

        try {
            // 検索キーワードをCQL形式で設定
            String query =  "title = Java";

            // 検索キーワードをURL用にエンコード
            String encodedQuery = URLEncoder.encode(query, "UTF-8");

            // 国立国会図書館APIのエンドポイント
            String endpoint = "https://ndlsearch.ndl.go.jp/api/sru";

            // APIリクエストのURLを構築
            String requestUrl = endpoint
                    + "?operation=searchRetrieve"
                    + "&version=1.2"
                    + "&query=" + encodedQuery
                    + "&maximumRecords=10"
                    + "&recordSchema=dc";

            // URLオブジェクトを作成
            URL url = new URL(requestUrl);

            // HTTP接続を確立
            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();

            // HTTPメソッドをGETに設定
            connection.setRequestMethod("GET");

            // レスポンスを読み込む
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );

            String line;

            // XMLを1行ずつコンソールに表示
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // ストリームを閉じる
            reader.close();

            // HTTP接続を切断
            connection.disconnect();

        } catch (Exception e) {
            // 例外が発生した場合はスタックトレースを表示
            e.printStackTrace();
        }
    }
}