public class Main2 {

    public static String shortenMessage(String message, int maxLength) {

        // メッセージが指定された長さ以下の場合は、そのまま返す
        if (message.length() <= maxLength) {
            return message;
        }

        // StringBuilderを使用して省略後の文字列を作成する
        StringBuilder sb = new StringBuilder();

        // 指定された長さまで文字列を取り出す
        sb.append(message.substring(0, maxLength));

        // 末尾に「...」を追加する
        sb.append("...");

        return sb.toString();
    }

    public static void main(String[] args) {

        String message = "これは非常に長いチャットメッセージです。省略する必要があります。";

        System.out.println("原文: " + message);
        System.out.println("省略後(10文字): " + shortenMessage(message, 10));
        System.out.println("省略後(20文字): " + shortenMessage(message, 20));
    }
}