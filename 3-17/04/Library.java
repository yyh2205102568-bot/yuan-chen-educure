public class Library {

    // 本を貸し出すメソッド
    public void lendBook(Book book) {

        // すでに貸し出されているか確認する
        if (book.isLent()) {
            System.out.println("エラー：この本は既に貸し出し中です");
            return;
        }

        // 貸出状態をtrueに変更する
        book.setLent(true);

        // 貸し出し完了メッセージを表示する
        System.out.println("「" + book.getTitle() + "」を貸し出しました");
    }

    // 本を返却するメソッド
    public void returnBook(Book book) {

        // 貸し出されていない本か確認する
        if (!book.isLent()) {
            System.out.println("エラー：この本は貸し出されていません");
            return;
        }

        // 貸出状態をfalseに変更する
        book.setLent(false);

        // 返却完了メッセージを表示する
        System.out.println("「" + book.getTitle() + "」が返却されました");
    }
}