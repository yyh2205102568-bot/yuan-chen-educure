package task5;

public class Book {
    int id;
    String title;
    String author;
    int pages;

    // コンストラクタ1
    // ID、タイトル、著者を受け取る
    // ページ数は0で初期化する
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = 0;
    }

    // コンストラクタ2
    // ID、タイトル、著者、ページ数を受け取る
    public Book(int id, String title, String author, int pages) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    // 本の情報を表示する
    public void displayInfo() {
        System.out.println(
            "本" + id + ":" +
            title + " - " +
            author + "(" +
            pages + "ページ）"
        );
    }
}
