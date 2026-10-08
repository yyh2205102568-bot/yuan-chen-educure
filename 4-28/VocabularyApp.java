// IOExceptionを使用するために読み込む
import java.io.IOException;

// Scannerを使用するために読み込む
import java.util.Scanner;

// アプリ全体を管理するクラス
public class VocabularyApp {

    // 単語コレクションを管理するWordManager
    private WordManager wordManager;

    // クイズ機能を管理するQuiz
    private Quiz quiz;

    // CSVファイルを管理するFileHandler
    private FileHandler fileHandler;

    // キーボード入力を受け取るScanner
    private Scanner scanner;

    // VocabularyAppのコンストラクタ
    public VocabularyApp() {

        // WordManagerを作成する
        wordManager = new WordManager();

        // WordManagerを使用するQuizを作成する
        quiz = new Quiz(wordManager);

        // FileHandlerを作成する
        fileHandler = new FileHandler();

        // キーボード入力用のScannerを作成する
        scanner = new Scanner(System.in);
    }

    // アプリを開始するメソッド
    public void start() {

        // 終了が選択されるまで繰り返す
        while (true) {

            // メインメニューを表示する
            System.out.println();
            System.out.println("=== 英単語暗記アプリ ===");
            System.out.println("1: 単語を登録する");
            System.out.println("2: クイズを受ける");
            System.out.println(
                    "3: CSVファイルから単語をインポート");
            System.out.println(
                    "4: CSVファイルに単語をエクスポート");
            System.out.println("5: 終了する");

            // メニュー番号の入力を求める
            System.out.print("選択してください: ");

            // 入力された内容を取得する
            String choice = scanner.nextLine();

            // 入力された内容によって処理を分ける
            switch (choice) {

                // 単語登録を選択した場合
                case "1":

                    // 単語登録処理を実行する
                    registerWord();

                    // switch文を終了する
                    break;

                // クイズを選択した場合
                case "2":

                    // クイズ処理を実行する
                    startQuiz();

                    // switch文を終了する
                    break;

                // CSVインポートを選択した場合
                case "3":

                    // CSVインポート処理を実行する
                    importWords();

                    // switch文を終了する
                    break;

                // CSVエクスポートを選択した場合
                case "4":

                    // CSVエクスポート処理を実行する
                    exportWords();

                    // switch文を終了する
                    break;

                // 終了を選択した場合
                case "5":

                    // Scannerを閉じる
                    scanner.close();

                    // アプリを終了する
                    return;

                // 1～5以外が入力された場合
                default:

                    // エラーメッセージを表示する
                    System.out.println(
                            "エラー：1～5の数字を入力してください。");
            }
        }
    }

    // 単語を登録するメソッド
    private void registerWord() {

        // 登録単語数が最大数に達しているか確認する
        if (wordManager.getWordCount() >= WordManager.MAX_WORDS) {

            // 最大数に達している場合はエラーを表示する
            System.out.println(
                    "エラー：登録できる単語は1000個までです。");

            // 単語登録処理を終了する
            return;
        }

        // 英単語の入力を求める
        System.out.print("英単語を入力してください: ");

        // 英単語を取得する
        String english = scanner.nextLine();

        // 英単語の入力内容を確認する
        if (!validateInput(english, "英単語")) {

            // 入力が正しくない場合は処理を終了する
            return;
        }

        // 日本語訳の入力を求める
        System.out.print("日本語訳を入力してください: ");

        // 日本語訳を取得する
        String japanese = scanner.nextLine();

        // 日本語訳の入力内容を確認する
        if (!validateInput(japanese, "日本語訳")) {

            // 入力が正しくない場合は処理を終了する
            return;
        }

        // 入力されたデータからWordを作成する
        Word word = new Word(english, japanese);

        // WordManagerに単語を追加する
        wordManager.addWord(word);

        // 登録完了メッセージを表示する
        System.out.println("単語を登録しました。");
    }

    // 入力内容を確認するメソッド
    private boolean validateInput(
            String input,
            String fieldName) {

        // 入力が空文字の場合
        if (input.trim().isEmpty()) {

            // エラーメッセージを表示する
            System.out.println(
                    "エラー："
                    + fieldName
                    + "が入力されていません。");

            // 入力が正しくないことを返す
            return false;
        }

        // 入力が正しいことを返す
        return true;
    }

    // クイズを開始するメソッド
    private void startQuiz() {

        // 登録されている単語が0件の場合
        if (wordManager.getWordCount() == 0) {

            // エラーメッセージを表示する
            System.out.println(
                    "登録された単語がありません。");

            // クイズ処理を終了する
            return;
        }

        // 正解数と問題数を0から開始する
        quiz = new Quiz(wordManager);

        // クイズ開始メッセージを表示する
        System.out.println(
                "=== クイズを開始します ===");

        // 登録されている単語数だけ問題を出す
        for (int i = 0;
                i < wordManager.getWordCount();
                i++) {

            // 登録単語からランダムに1つ取得する
            Word word = quiz.getRandomWord();

            // 英単語を問題として表示する
            System.out.println(
                    word.getEnglish() + "の意味は?");

            // ユーザーの回答を取得する
            String answer = scanner.nextLine();

            // 回答を判定する
            if (quiz.checkAnswer(word, answer)) {

                // 正解の場合
                System.out.println("正解です！");

            } else {

                // 不正解の場合
                System.out.println(
                        "不正解です。正解は"
                        + word.getJapanese()
                        + "でした。");
            }
        }

        // クイズ終了メッセージを表示する
        System.out.println("クイズ終了！");

        // 最終スコアを表示する
        System.out.println(
                quiz.getTotalQuestions()
                + "問中"
                + quiz.getScore()
                + "問正解でした！");
    }

    // CSVファイルから単語を読み込むメソッド
    private void importWords() {

        // CSVファイル名の入力を求める
        System.out.print(
                "CSVファイル名を入力してください: ");

        // ファイル名を取得する
        String filename = scanner.nextLine();

        try {

            // CSVファイルから単語を読み込む
            int count = fileHandler.importFromCSV(
                    filename,
                    wordManager);

            // 読み込んだ単語数を表示する
            System.out.println(
                    count
                    + "個の単語を読み込みました。");

        } catch (IOException e) {

            // ファイル操作でエラーが発生した場合
            System.out.println(
                    "エラー：" + e.getMessage());
        }
    }

    // 登録されている単語をCSVファイルに保存するメソッド
    private void exportWords() {

        // CSVファイル名の入力を求める
        System.out.print(
                "CSVファイル名を入力してください: ");

        // ファイル名を取得する
        String filename = scanner.nextLine();

        try {

            // 登録されている単語をCSVファイルに保存する
            int count = fileHandler.exportToCSV(
                    wordManager.getWords(),
                    filename);

            // 保存した単語数を表示する
            System.out.println(
                    count
                    + "個の単語を保存しました。");

        } catch (IOException e) {

            // ファイル操作でエラーが発生した場合
            System.out.println(
                    "エラー：" + e.getMessage());
        }
    }

    // プログラムを実行するmainメソッド
    public static void main(String[] args) {

        // VocabularyAppを作成する
        VocabularyApp app = new VocabularyApp();

        // アプリを開始する
        app.start();
    }
}