import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

// 英単語暗記アプリのメインクラス
public class VocabularyApp {

    private WordManager wordManager;
    private Quiz quiz;
    private FileHandler fileHandler;
    private Scanner scanner;
    private DBManager dbManager;

    // コンストラクタ
    public VocabularyApp() throws SQLException {

        // データベース管理クラスを作成する
        dbManager = new DBManager();

        // 単語管理クラスを作成する
        wordManager = new WordManager(dbManager);

        // クイズ管理クラスを作成する
        quiz = new Quiz(wordManager);

        // CSV管理クラスを作成する
        fileHandler = new FileHandler();

        // ターミナルの文字コードで入力する
        String specified =
                System.getProperty("app.input.charset");

        Charset charset;

        if (specified != null && !specified.isBlank()) {

            charset = Charset.forName(specified);

        } else if (System.console() != null) {

            charset = System.console().charset();

        } else {

            charset = Charset.forName(
                    System.getProperty(
                            "native.encoding", "UTF-8"));
        }

        scanner = new Scanner(System.in, charset);
    }

    // アプリケーションを開始する
    public void start() {

        try {

            while (true) {

                // メニューを表示する
                System.out.println();

                System.out.println(
                        "=== 英単語暗記アプリ ===");

                System.out.println(
                        "1: 単語を登録する");

                System.out.println(
                        "2: クイズを受ける");

                System.out.println(
                        "3: CSVファイルから単語をインポート");

                System.out.println(
                        "4: CSVファイルに単語をエクスポート");

                System.out.println(
                        "5: 単語を削除する");

                System.out.println(
                        "6: 単語を更新する");

                System.out.println(
                        "7: 終了する");

                System.out.print(
                        "番号を入力してください: ");

                String choice =
                        scanner.nextLine().trim();

                try {

                    switch (choice) {

                        case "1" -> registerWord();

                        case "2" -> startQuiz();

                        case "3" -> importWords();

                        case "4" -> exportWords();

                        case "5" -> deleteWord();

                        case "6" -> updateWord();

                        case "7" -> {

                            System.out.println(
                                    "アプリを終了します。");

                            return;
                        }

                        default -> System.out.println(
                                "1から7の番号を入力してください。");
                    }

                } catch (SQLException | IOException e) {

                    System.out.println(
                            "エラー: " + e.getMessage());
                }
            }

        } finally {

            cleanup();
        }
    }

    // 単語を登録する
    private void registerWord() throws SQLException {

        // 英単語を入力する
        System.out.print(
                "英単語を入力してください: ");

        String english =
                scanner.nextLine().trim();

        // 日本語訳を入力する
        System.out.print(
                "日本語訳を入力してください: ");

        String japanese =
                scanner.nextLine().trim();

        // 英単語の空文字チェック
        if (english.isEmpty()) {

            System.out.println(
                    "エラー: 英単語が空です。");

            return;
        }

        // 日本語訳の空文字チェック
        if (japanese.isEmpty()) {

            System.out.println(
                    "エラー: 日本語訳が空です。");

            return;
        }

        // 英単語の文字数チェック
        if (english.length() > 100) {

            System.out.println(
                    "エラー: 英単語が100文字を超えています。");

            return;
        }

        // 日本語訳の文字数チェック
        if (japanese.length() > 100) {

            System.out.println(
                    "エラー: 日本語訳が100文字を超えています。");

            return;
        }

        // 文字化けとCSV形式を確認する
        if (english.contains("\uFFFD")
                || japanese.contains("\uFFFD")
                || english.contains(",")
                || japanese.contains(",")) {

            System.out.println(
                    "エラー: 入力文字またはCSV形式が正しくありません。");

            return;
        }

        // データベースに単語を登録する
        wordManager.addWord(
                new Word(english, japanese));

        System.out.println(
                "単語を登録しました。");
    }

    // クイズを開始する
    private void startQuiz() throws SQLException {

        // 登録されている単語数を取得する
        int wordCount = wordManager.getWordCount();

        // 単語が登録されていない場合
        if (wordCount == 0) {

            System.out.println(
                    "登録された単語がありません。");

            return;
        }

        // 毎回新しいQuizを作り、得点をリセットする
        quiz = new Quiz(wordManager);

        System.out.println(
                "=== クイズを開始します ===");

        // 登録されている単語数分だけ出題する
        for (int i = 0; i < wordCount; i++) {

            // ランダムに単語を取得する
            Word word = quiz.getRandomWord();

            if (word == null) {
                break;
            }

            // 問題を表示する
            System.out.println(
                    word.getEnglish() + "の意味は？");

            // 解答を入力する
            String answer = scanner.nextLine();

            // 解答の正誤を判定する
            if (quiz.checkAnswer(word, answer)) {

                System.out.println("正解です！");

            } else {

                System.out.println(
                        "不正解です。正解は"
                        + word.getJapanese()
                        + "でした。");
            }
        }

        // クイズの終了を表示する
        System.out.println("クイズ終了！");

        // 最終成績を表示する
        System.out.println(
                quiz.getTotalQuestions()
                + "問中"
                + quiz.getScore()
                + "問正解でした！");
    }

    // CSVファイルから単語をインポートする
    private void importWords()
            throws IOException, SQLException {

        // ファイル名を入力する
        System.out.print(
                "CSVファイル名を入力してください: ");

        String filename =
                scanner.nextLine().trim();

        // ファイル名が空の場合
        if (filename.isEmpty()) {

            System.out.println(
                    "エラー: ファイル名が空です。");

            return;
        }

        // CSVファイルを読み込む
        fileHandler.importFromCSV(
                filename, wordManager);
    }

    // CSVファイルへ単語をエクスポートする
    private void exportWords()
            throws IOException, SQLException {

        // ファイル名を入力する
        System.out.print(
                "CSVファイル名を入力してください: ");

        String filename =
                scanner.nextLine().trim();

        // ファイル名が空の場合
        if (filename.isEmpty()) {

            System.out.println(
                    "エラー: ファイル名が空です。");

            return;
        }

        // データベースから単語を取得する
        List<Word> words = wordManager.getWords();

        // CSVファイルに単語を保存する
        fileHandler.exportToCSV(words, filename);
    }

    // 単語を削除する
    private void deleteWord() throws SQLException {

        // 削除する英単語を入力する
        System.out.print(
                "削除する英単語を入力してください: ");

        String english =
                scanner.nextLine().trim();

        // 英単語の空文字チェック
        if (english.isEmpty()) {

            System.out.println(
                    "エラー: 英単語が空です。");

            return;
        }

        // データベースから単語を削除する
        if (wordManager.deleteWord(english)) {

            System.out.println(
                    "単語を削除しました。");

        } else {

            System.out.println(
                    "エラー: 指定された英単語 '"
                    + english
                    + "' が見つかりません。");
        }
    }

    // 単語の日本語訳を更新する
    private void updateWord() throws SQLException {

        // 更新する英単語を入力する
        System.out.print(
                "更新する英単語を入力してください: ");

        String english =
                scanner.nextLine().trim();

        // 新しい日本語訳を入力する
        System.out.print(
                "新しい日本語訳を入力してください: ");

        String japanese =
                scanner.nextLine().trim();

        // 英単語の空文字チェック
        if (english.isEmpty()) {

            System.out.println(
                    "エラー: 英単語が空です。");

            return;
        }

        // 日本語訳の空文字チェック
        if (japanese.isEmpty()) {

            System.out.println(
                    "エラー: 日本語訳が空です。");

            return;
        }

        // 英単語の文字数チェック
        if (english.length() > 100) {

            System.out.println(
                    "エラー: 英単語が100文字を超えています。");

            return;
        }

        // 日本語訳の文字数チェック
        if (japanese.length() > 100) {

            System.out.println(
                    "エラー: 日本語訳が100文字を超えています。");

            return;
        }

        // 文字化けとCSV形式を確認する
        if (english.contains("\uFFFD")
                || japanese.contains("\uFFFD")
                || english.contains(",")
                || japanese.contains(",")) {

            System.out.println(
                    "エラー: 入力文字またはCSV形式が正しくありません。");

            return;
        }

        // 単語の日本語訳を更新する
        if (wordManager.updateWord(
                english, japanese)) {

            System.out.println(
                    "単語を更新しました。");

        } else {

            System.out.println(
                    "エラー: 指定された英単語 '"
                    + english
                    + "' が見つかりません。");
        }
    }

    // アプリケーションの終了処理
    private void cleanup() {

        // Scannerを閉じる
        scanner.close();

        // データベース接続を閉じる
        dbManager.close();
    }

    // メインメソッド
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