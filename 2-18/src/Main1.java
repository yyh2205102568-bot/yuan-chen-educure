public class Main1 {

    public static void main(String[] args) {
        int price=1000;
        int quantity=3;
        int totalWithTax=calculatePrice(price,quantity);
        System.out.println("商品価格:"+price+"円、数量:"+quantity);
        System.out.println("合計金額（税込）:"+totalWithTax+"円");
}
public static int calculatePrice(int price,int quantity){
    int total=price*quantity;
    int totalWithTax=total*110/100;
    return totalWithTax;

}
        
}