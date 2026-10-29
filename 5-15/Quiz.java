import java.sql.SQLException;
import java.util.List;
import java.util.Random;

// クイズ機能を管理するクラス
public class Quiz {

    private WordManager wordManager;

    private int score;

    private int totalQuestions;

    // コンストラクタ
    public Quiz(WordManager wordManager) {

        this.wordManager = wordManager;

        this.score = 0;
        this.totalQuestions = 0;
    }

    // 解答の正誤を判定する
    public boolean checkAnswer(Word word, String answer) {

        totalQuestions++;

        boolean correct =
                word.getJapanese().equals(answer.trim());

        if (correct) {
            score++;
        }

        return correct;
    }

    // 登録単語の中からランダムに1語取得する
    public Word getRandomWord() throws SQLException {

        List<Word> words = wordManager.getWords();

        if (words.isEmpty()) {
            return null;
        }

        int index = new Random().nextInt(words.size());

        return words.get(index);
    }

    // 正解数を取得する
    public int getScore() {
        return score;
    }

    // 総問題数を取得する
    public int getTotalQuestions() {
        return totalQuestions;
    }
}