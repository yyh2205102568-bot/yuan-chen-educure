package task2;
public class Main2 {//本のインスタンスを生成して、メソッドを呼び出す
    public static void main(String[] args) {

        Book book = new Book();//Bookクラスのインスタンスを生成します。

        book.setTitle("Java入門");

        System.out.println("「" + book.getTitle() + "」を登録しました");

        book.lend();
        book.lend();

        book.returnBook();

        book.lend();
    }
}
    

