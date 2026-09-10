public class Main1 {

    public static void main(String[] args) {

        // Calculatorクラスのインスタンスを作成する
        Calculator calc = new Calculator();

        // 割り算を実行する
        try {

            // 10 ÷ 0 を計算する
            int result = calc.divide(10, 0);

            // 正常に計算できた場合は結果を表示する
            System.out.println("10 ÷ 0 = " + result);

        } catch (ArithmeticException e) {

            // 0で割った場合のエラーメッセージを表示する
            System.out.println("10 ÷ 0 = エラー：" + e.getMessage());
        }
    }
}