public class Main3 {

    public static void main(String[] args) {

        // ScoreManagerクラスのインスタンスを作成する
        ScoreManager manager = new ScoreManager();

        // 正常な得点を確認する
        System.out.println("得点：50");

        try {

            // 得点50をチェックする
            manager.validateScore(50);

            // 例外が発生しなければOKを表示する
            System.out.println("OK");

        } catch (GameScoreException e) {

            // 例外が発生した場合は
            // メッセージと得点を表示する
            System.out.println(
                "エラー：" + e.getMessage()
                + " (" + e.getScore() + ")"
            );
        }

        System.out.println();

        // 負の得点を確認する
        System.out.println("得点：-10");

        try {

            // 得点-10をチェックする
            manager.validateScore(-10);

            // 例外がなければOKを表示する
            System.out.println("OK");

        } catch (GameScoreException e) {

            // 負の得点のエラー内容を表示する
            System.out.println(
                "エラー：" + e.getMessage()
                + " (" + e.getScore() + ")"
            );
        }

        System.out.println();

        // 100点を超える得点を確認する
        System.out.println("得点：150");

        try {

            // 得点150をチェックする
            manager.validateScore(150);

            // 例外がなければOKを表示する
            System.out.println("OK");

        } catch (GameScoreException e) {

            // 100点を超えた場合のエラー内容を表示する
            System.out.println(
                "エラー：" + e.getMessage()
                + " (" + e.getScore() + ")"
            );
        }
    }
}