package a3;
public class Main3 {

    public static void main(String[] args) {

        // コンストラクタでタイトル、著者、価格を設定
        Book book = new Book(
            "Javaプログラミング",
            "山田 太郎",
            2800
        );

        // getメソッドで本の情報を取得して表示
        System.out.println("タイトル: " + book.getTitle());
        System.out.println("著者: " + book.getAuthor());
        System.out.println("価格: " + book.getPrice());
    }
}

// XMLデータに対応するBookクラス
class Book {

    // フィールド
    private String title;
    private String author;
    private int price;

    // コンストラクタ
    public Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // ゲッターメソッド
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPrice() {
        return price;
    }
}