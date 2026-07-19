public class Main2 {
    public static void main(String[] args){
        int price=2500;
        double rate=0.2;
        int discount=(int)(price*rate);
        int sale=price-discount;
        System.out.println("割引額:"+discount+"円");
        System.out.println("販売金額:"+sale+"円");


    }
}
