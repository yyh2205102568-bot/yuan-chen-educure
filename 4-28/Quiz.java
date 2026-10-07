// Randomを使用するために読み込む
import java.util.Random;

// クイズ機能を提供するクラス
public class Quiz {

    // 登録されている単語を管理するWordManager
    private WordManager wordManager;

    // 正解数
    private int score;

    // 総問題数
    private int totalQuestions;

    // Quizのコンストラクタ
    public Quiz(WordManager wordManager) {

        // VocabularyAppで作成したWordManagerを受け取る
        this.wordManager = wordManager;

        // 正解数を0にする
        this.score = 0;

        // 総問題数を0にする
        this.totalQuestions = 0;
    }

    // 登録された単語からランダムに1つ取得するメソッド
    public Word getRandomWord() {

        // ランダムな数字を作成する
        Random random = new Random();

        // 単語リストの中からランダムな位置を取得する
        int index = random.nextInt(wordManager.getWordCount());

        // ランダムに選ばれた単語を返す
        return wordManager.getWords().get(index);
    }

    // 回答が正しいか判定するメソッド
    public boolean checkAnswer(Word word, String answer) {

        // 1問回答したため総問題数を1増やす
        totalQuestions++;

        // 登録されている日本語訳と回答を比較する
        if (word.getJapanese().equals(answer)) {

            // 正解の場合は正解数を1増やす
            score++;

            // 正解であることを返す
            return true;
        }

        // 不正解であることを返す
        return false;
    }

    // 正解数を取得するメソッド
    public int getScore() {

        // 正解数を返す
        return score;
    }

    // 総問題数を取得するメソッド
    public int getTotalQuestions() {

        // 総問題数を返す
        return totalQuestions;
    }
}