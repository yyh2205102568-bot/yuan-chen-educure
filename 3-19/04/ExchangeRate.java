public class ExchangeRate {

    // ドルレートとユーロレートを管理する静的フィールド
    private static double usdRate = 145.0;
    private static double eurRate = 160.0;

    // 為替レートを更新する静的メソッド
    public static void updateRates(double newUsdRate, double newEurRate) {
        usdRate = newUsdRate;
        eurRate = newEurRate;

        System.out.println("レート更新");
    }

    // 指定した通貨を日本円に換算する静的メソッド
    public static int toJPY(String currency, double amount) {

        // USDの場合
        if (currency.equals("USD")) {
            return (int) (amount * usdRate);
        }

        // EURの場合
        else if (currency.equals("EUR")) {
            return (int) (amount * eurRate);
        }

        // USD、EUR以外の場合
        else {
            return -1;
        }
    }
}