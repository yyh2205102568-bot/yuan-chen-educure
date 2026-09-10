public class ScoreManager {

    // 得点が正しい範囲か確認するメソッド
    public void validateScore(int score)
            throws GameScoreException {

        // 得点が0未満の場合
        if (score < 0) {

            // 負の得点用の例外をスローする
            throw new InvalidScoreException(score);
        }

        // 得点が100を超えている場合
        if (score > 100) {

            // 100点超過用の例外をスローする
            throw new ScoreOverflowException(score);
        }

        // 0以上100以下の場合は正常なので何もしない
    }
}