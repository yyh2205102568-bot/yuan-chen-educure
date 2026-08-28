public class Main3 {

    public static void main(String[] args) {

        // 初期の貸出可能な本の冊数を表示
        System.out.println(
            "貸出可能な本：" + Library.getAvailableBooks() + "冊"
        );

        // 本を1冊借りる
        Library.borrowBook();

        // 借りた後の冊数を表示
        System.out.println(
            "貸出可能な本：" + Library.getAvailableBooks() + "冊"
        );

        // 本を1冊返却する
        Library.returnBook();

        // 返却後の冊数を表示
        System.out.println(
            "貸出可能な本：" + Library.getAvailableBooks() + "冊"
        );
    }
}