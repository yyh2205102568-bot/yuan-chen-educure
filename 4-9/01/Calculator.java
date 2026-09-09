public class Calculator {

    // 2つの整数の割り算を行うメソッド
    public int divide(int a, int b) throws ArithmeticException {

        // bが0の場合は、0で割ることができないため例外をスローする
        if (b == 0) {
            throw new ArithmeticException("0で割ることはできません");
        }

        // bが0でない場合は、割り算の結果を返す
        return a / b;
    }
}