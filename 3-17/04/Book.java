public class Book {

    // 本のタイトルを保存するフィールド
    private String title;

    // 本の貸出状態を保存するフィールド
    // false：未貸出
    // true：貸出中
    private boolean isLent;

    // タイトルを設定し、初期状態を未貸出にするコンストラクタ
    public Book(String title) {
        this.title = title;
        this.isLent = false;
    }

    // 本のタイトルを取得するgetterメソッド
    public String getTitle() {
        return this.title;
    }

    // 本の貸出状態を取得するgetterメソッド
    public boolean isLent() {
        return this.isLent;
    }

    // 本の貸出状態を変更するメソッド
    // Libraryクラスから利用できるようにprotectedで定義する
    protected void setLent(boolean lent) {
        this.isLent = lent;
    }
}