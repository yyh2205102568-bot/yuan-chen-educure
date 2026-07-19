public class Main5 {
    public static void main(String[] args){
        int note=280*3;
        int pen=120*5;
        int eraser=100*2;
        int subtotal=note+pen+eraser;
        int tax=(int)(subtotal*0.1);
        int total=subtotal+tax;
        int change=2000-total;
        System.out.println("小計：" + subtotal + "円");
        System.out.println("消費税：" + tax + "円");
        System.out.println("合計金額：" + total + "円");
        System.out.println("おつり：" + change + "円");

    }
}
