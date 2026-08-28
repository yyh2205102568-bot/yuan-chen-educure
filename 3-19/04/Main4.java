public class Main4 {

    public static void main(String[] args) {

        // 初期レートで100ドルを日本円に換算
        int usdBefore = ExchangeRate.toJPY("USD", 100);

        System.out.println("100ドル=" + usdBefore + "円");

        // 為替レートを更新
        ExchangeRate.updateRates(150.0, 160.0);

        // 更新後のレートで100ドルを日本円に換算
        int usdAfter = ExchangeRate.toJPY("USD", 100);

        System.out.println("100ドル=" + usdAfter + "円");

        // 80ユーロを日本円に換算
        int eur = ExchangeRate.toJPY("EUR", 80);

        System.out.println("80ユーロ=" + eur + "円");
    }
}