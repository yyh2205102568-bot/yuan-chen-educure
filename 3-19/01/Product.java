public class Product {
    String name;
    int price;

 // 商品名と価格を初期化するコンストラクタ
    public Product(String name,int price){
        this.name=name;
        this.price=price;
    }
    // 商品情報を文字列として返す
    @Override
    public String toString(){
        return"商品名:"+name+"("+price+"円)";
    }


}
