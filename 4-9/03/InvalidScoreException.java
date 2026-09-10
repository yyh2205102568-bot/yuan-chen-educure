// 負の得点の場合に使用する独自例外クラス
public class InvalidScoreException extends GameScoreException {

    // コンストラクタ
    public InvalidScoreException(int score) {

        // 親クラスのコンストラクタを呼び出し、
        // エラーメッセージと得点を渡す
        super("Score cannot be negative", score);
    }
}