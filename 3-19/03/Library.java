public class Library {

    // 貸出可能な本の総数
    private static int availableBooks = 100;

    // 本を1冊借りる
    public static void borrowBook() {

        // 貸出可能な本がある場合
        if (availableBooks > 0) {
            availableBooks--;
            System.out.println("1冊借りました");
        } else {
            System.out.println("エラー：貸出可能な本がありません");
        }
    }

    // 本を1冊返却する
    public static void returnBook() {
        availableBooks++;
        System.out.println("本を返却しました");
    }

    // 現在の貸出可能な本の冊数を取得する
    public static int getAvailableBooks() {
        return availableBooks;
    }
}