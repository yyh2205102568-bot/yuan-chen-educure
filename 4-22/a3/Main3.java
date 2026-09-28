package a3;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class Main3 {

    public static void main(String[] args) {

        try {
            // XMLファイルを指定する
            File xmlFile = new File("a3/exercise.xml");

            // DocumentBuilderFactoryを作成する
            DocumentBuilderFactory factory =
                    DocumentBuilderFactory.newInstance();

            // DocumentBuilderを取得する
            DocumentBuilder builder =
                    factory.newDocumentBuilder();

            // XMLファイルを解析する
            Document document =
                    builder.parse(xmlFile);

            // XMLの構造を正規化する
            document.getDocumentElement().normalize();

            // タグ名から各要素の文字列を取得する
            String title =
                    document.getElementsByTagName("title")
                            .item(0)
                            .getTextContent();

            String author =
                    document.getElementsByTagName("author")
                            .item(0)
                            .getTextContent();

            String priceText =
                    document.getElementsByTagName("price")
                            .item(0)
                            .getTextContent();

            // 価格を文字列から数値に変換する
            int price = Integer.parseInt(priceText);

            // XMLから取得した値をコンストラクタに渡す
            Book book = new Book(
                    title,
                    author,
                    price
            );

            // getメソッドで本の情報を表示する
            System.out.println("タイトル: " + book.getTitle());
            System.out.println("著者: " + book.getAuthor());
            System.out.println("価格: " + book.getPrice());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


// XMLデータに対応するBookクラス
class Book {

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