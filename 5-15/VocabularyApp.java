import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

// 英単語暗記アプリのメインクラス
public class VocabularyApp {

    // 単語管理クラス
    private WordManager wordManager;

    // クイズ管理クラス
    private Quiz quiz;

    // CSVファイル管理クラス
    private FileHandler fileHandler;

    // キーボード入力用
    private Scanner scanner;

    // データベース管理クラス
    private DBManager dbManager;

    // コンストラクタ
    public VocabularyApp() throws SQLException {

        // データベースに接続する
        dbManager = new DBManager();

        // 各クラスを初期化する
        wordManager = new WordManager(dbManager);
        quiz = new Quiz(wordManager);
        fileHandler = new FileHandler();

        // ターミナルの文字コードを設定する
        String specified = System.getProperty("app.input.charset");
        Charset charset;

        if (specified != null && !specified.isBlank()) {
            charset = Charset.forName(specified);
        } else if (System.console() != null) {
            charset = System.console().charset();
        } else {
            charset = Charset.forName(
                    System.getProperty("native.encoding", "UTF-8"));
        }

        // キーボード入力を受け取る
        scanner = new Scanner(System.in, charset);
    }

    // メインメニュー
    public void start() {

        try {
            while (true) {

                System.out.println();
                System.out.println("=== 英単語暗記アプリ ===");
                System.out.println("1: 単語を登録する");
                System.out.println("2: クイズを受ける");
                System.out.println("3: CSVファイルから単語をインポート");
                System.out.println("4: CSVファイルに単語をエクスポート");
                System.out.println("5: 単語を削除する");
                System.out.println("6: 単語を更新する");
                System.out.println("7: 単語一覧を表示する");
                System.out.println("8: 終了する");
                System.out.print("番号を入力してください: ");

                // 入力が終了した場合
                if (!scanner.hasNextLine()) {
                    return;
                }

                String choice = scanner.nextLine().trim();

                try {
                    // 入力された番号に応じて処理する
                    switch (choice) {

                        case "1" -> registerWord();

                        case "2" -> startQuiz();

                        case "3" -> importWords();

                        case "4" -> exportWords();

                        case "5" -> deleteWord();

                        case "6" -> updateWord();

                        case "7" -> showWords();

                        case "8" -> {
                            System.out.println("アプリを終了します。");
                            return;
                        }

                        default -> System.out.println(
                                "無効な選択です。");
                    }

                } catch (IllegalArgumentException e) {

                    // 入力エラーや重複登録などのエラーを表示する
                    System.out.println(e.getMessage());

                } catch (SQLException | IOException e) {

                    // データベースやファイルのエラーを表示する
                    System.out.println("エラー: " + e.getMessage());
                }
            }

        } finally {

            // 終了時に接続を閉じる
            cleanup();
        }
    }

    // 単語を登録する
    private void registerWord() throws SQLException {

        System.out.print("英単語を入力してください: ");
        String english = scanner.nextLine();

        System.out.print("日本語訳を入力してください: ");
        String japanese = scanner.nextLine();

        // 入力チェックと重複登録チェックは
        // WordManagerで行う
        wordManager.addWord(new Word(english, japanese));

        System.out.println("単語を登録しました。");
    }

    // クイズを開始する
    private void startQuiz() throws SQLException {

        // クイズを初期化する
        quiz.reset();

        // 登録済みの単語数を取得する
        int count = wordManager.getWordCount();

        // 単語がない場合
        if (count == 0) {
            System.out.println("登録された単語がありません。");
            return;
        }

        System.out.println("=== クイズを開始します ===");

        // 登録されている単語を1回ずつ出題する
        for (int i = 0; i < count; i++) {

            // 未出題の単語からランダムに取得する
            Word word = quiz.getRandomWord();

            if (word == null) {
                break;
            }

            // 問題を表示する
            System.out.println(
                    word.getEnglish() + "の意味は？");

            if (!scanner.hasNextLine()) {
                break;
            }

            // 解答を入力する
            String answer = scanner.nextLine();

            // 正誤判定
            if (quiz.checkAnswer(word, answer)) {

                System.out.println("正解です！");

            } else {

                System.out.println(
                        "不正解です。正解は"
                        + word.getJapanese()
                        + "でした。");
            }
        }

        // クイズの結果を表示する
        System.out.println("クイズ終了！");

        System.out.println(
                quiz.getTotalQuestions()
                + "問中"
                + quiz.getScore()
                + "問正解でした！");
    }

    // CSVファイルから単語を読み込む
    private void importWords()
            throws IOException, SQLException {

        System.out.print("CSVファイル名を入力してください: ");
        String filename = scanner.nextLine().trim();

        // ファイル名のチェック
        if (filename.isEmpty()) {
            System.out.println("エラー: ファイル名が空です。");
            return;
        }

        // 登録成功件数を受け取る
        int count = fileHandler.importFromCSV(
                filename, wordManager);

        // 登録成功件数を表示する
        System.out.println(
                count + "個の単語を読み込みました。");
    }

    // 単語をCSVファイルに保存する
    private void exportWords()
            throws IOException, SQLException {

        System.out.print("CSVファイル名を入力してください: ");
        String filename = scanner.nextLine().trim();

        if (filename.isEmpty()) {
            System.out.println("エラー: ファイル名が空です。");
            return;
        }

        // 登録済みの単語を取得する
        List<Word> words = wordManager.getWords();

        // CSVファイルに書き込む
        fileHandler.exportToCSV(words, filename);

        System.out.println(
                words.size() + "個の単語を保存しました。");
    }

    // 単語を削除する
    private void deleteWord() throws SQLException {

        System.out.print("削除する英単語を入力してください: ");
        String english = scanner.nextLine();

        // WordManagerで削除する
        wordManager.deleteWord(english);

        System.out.println("単語を削除しました。");
    }

    // 単語の日本語訳を更新する
    private void updateWord() throws SQLException {

        System.out.print("更新する英単語を入力してください: ");
        String english = scanner.nextLine();

        System.out.print("新しい日本語訳を入力してください: ");
        String japanese = scanner.nextLine();

        // WordManagerで更新する
        wordManager.updateWord(english, japanese);

        System.out.println("単語を更新しました。");
    }

    // 登録済みの単語一覧を表示する
    private void showWords() throws SQLException {

        List<Word> words = wordManager.getWords();

        if (words.isEmpty()) {
            System.out.println("登録された単語がありません。");
            return;
        }

        System.out.println(
                "=== 登録単語一覧（" + words.size() + "件） ===");

        for (Word word : words) {
            System.out.println(
                    word.getEnglish() + "：" + word.getJapanese());
        }
    }

    // アプリ終了時の処理
    private void cleanup() {

        // Scannerを閉じる
        scanner.close();

        // データベース接続を閉じる
        dbManager.close();
    }

    // プログラムの開始位置
    public static void main(String[] args) {

        try {

            VocabularyApp app = new VocabularyApp();
            app.start();

        } catch (SQLException e) {

            System.out.println(
                    "データベースへの接続に失敗しました: "
                    + e.getMessage());
        }
    }
}