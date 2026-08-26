public class Main4 {

    public static void main(String[] args) {

        // 「Java入門」という本を作成する
        Book book = new Book("Java入門");

        // 図書館を作成する
        Library library = new Library();

        // 本を貸し出す
        library.lendBook(book);

        // すでに貸し出されている本をもう一度貸し出してエラーを確認する
        library.lendBook(book);

        // 本を返却する
        library.returnBook(book);

        // 返却後、もう一度本を貸し出す
        library.lendBook(book);
    }
}