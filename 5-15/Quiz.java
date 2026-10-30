import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// クイズの出題と採点を管理するクラス
public class Quiz {

    // 単語を管理するWordManager
    private final WordManager wordManager;

    // ランダムに出題するためのRandom
    private final Random random = new Random();

    // まだ出題していない単語を保存するリスト
    private List<Word> remainingWords;

    // 正解数
    private int score;

    // 解答した問題数
    private int totalQuestions;

    // コンストラクタ
    public Quiz(WordManager wordManager) {
        this.wordManager = wordManager;
    }

    // クイズを最初の状態に戻す
    public void reset() throws SQLException {

        // 正解数を0に戻す
        score = 0;

        // 解答数を0に戻す
        totalQuestions = 0;

        // データベースから単語を読み込み直す
        remainingWords = new ArrayList<>(wordManager.getWords());
    }

    // まだ出題していない単語からランダムに1語選ぶ
    public Word getRandomWord() throws SQLException {

        // 最初の出題時にリストを準備する
        if (remainingWords == null) {
            reset();
        }

        // すべて出題したらnullを返す
        if (remainingWords.isEmpty()) {
            return null;
        }

        // リストからランダムに位置を選ぶ
        int index = random.nextInt(remainingWords.size());

        // 選んだ単語をリストから削除して返す
        // 削除することで同じ単語が再び出題されない
        return remainingWords.remove(index);
    }

    // 解答を判定する
    public boolean checkAnswer(Word word, String answer) {

        // 不正な解答をチェックする
        if (word == null || answer == null) {
            throw new IllegalArgumentException(
                    "エラー: 解答が正しくありません。");
        }

        // 解答した問題数を1増やす
        totalQuestions++;

        // 正解かどうかを確認する
        boolean correct =
                word.getJapanese().equals(answer.trim());

        // 正解なら得点を1増やす
        if (correct) {
            score++;
        }

        return correct;
    }

    // 正解数を取得する
    public int getScore() {
        return score;
    }

    // 解答した問題数を取得する
    public int getTotalQuestions() {
        return totalQuestions;
    }
}