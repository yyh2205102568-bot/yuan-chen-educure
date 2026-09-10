// ゲームの得点に関する例外の基底クラス
public abstract class GameScoreException extends Exception {

    // エラーが発生した得点を保持するフィールド
    private int score;

    // コンストラクタ
    public GameScoreException(String message, int score) {

        // 親クラスExceptionのコンストラクタに
        // エラーメッセージを渡す
        super(message);

        // 得点をフィールドに保存する
        this.score = score;
    }

    // 得点を取得するメソッド
    public int getScore() {

        // 保存されている得点を返す
        return score;
    }
}