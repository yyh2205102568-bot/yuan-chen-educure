public abstract class Product {
    String name;
    int price;
    public abstract void displayInfo();//商品の情報を表示する抽象メソッドdisplayInfo()を定義
    public abstract void checkStock();//在庫チェックを行う抽象メソッドcheckStock()を定義
    
}
