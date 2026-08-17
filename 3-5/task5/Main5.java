package task5;

public class Main5 {
    public static void main(String[] args) {

        // コンストラクタ1を使用
        Book book1 = new Book(
            1,
            "Java入門",
            "山田太郎"
        );

        // コンストラクタ2を使用
        Book book2 = new Book(
            2,
            "Python実践",
            "鈴木次郎",
            300
        );

        // 本1の情報を表示
        book1.displayInfo();

        // 本2の情報を表示
        book2.displayInfo();
    }
}
