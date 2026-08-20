public class Main2 {
    public static void main(String[] args) {

        Book book = new Book("Java入門", 2500, "山田太郎", 1);

        book.displayInfo();
        book.checkStock();
    }
}