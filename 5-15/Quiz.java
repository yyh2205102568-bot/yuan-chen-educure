import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// 単語クイズを管理するクラス
public class Quiz {

    private final WordManager wordManager;
    private final Random random = new Random();

    private int questionCount;
    private int correctCount;
    private List<Word> remainingWords;

    // コンストラクタ
    public Quiz(WordManager wordManager) {
        this.wordManager = wordManager;
    }

    // まだ出題していない単語からランダムに取得する
    public Word getRandomWord() throws SQLException {

        // 最初の問題だけデータベースから読み込む
        if (remainingWords == null) {
            remainingWords =
                    new ArrayList<>(wordManager.getWords());
        }

        // 単語がない場合
        if (remainingWords.isEmpty()) {
            return null;
        }

        // ランダムに単語を選択する
        int index = random.nextInt(remainingWords.size());

        // 選択した単語をリストから取り除く
        return remainingWords.remove(index);
    }

    // 解答を判定する
    public boolean checkAnswer(Word word, String answer) {

        questionCount++;

        boolean correct =
                word.getJapanese().equals(answer.trim());

        if (correct) {
            correctCount++;
        }

        return correct;
    }

    // 出題数を取得する
    public int getQuestionCount() {
        return questionCount;
    }

    // 正解数を取得する
    public int getCorrectCount() {
        return correctCount;
    }

    // クイズの成績と出題履歴をリセットする
    public void resetScore() {
        questionCount = 0;
        correctCount = 0;
        remainingWords = null;
    }
}