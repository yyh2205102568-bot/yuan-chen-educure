// 100点を超えた場合に使用する独自例外クラス
public class ScoreOverflowException extends GameScoreException {

    // コンストラクタ
    public ScoreOverflowException(int score) {

        // 親クラスのコンストラクタを呼び出し、
        // エラーメッセージと得点を渡す
        super("Score cannot exceed 100", score);
    }
}