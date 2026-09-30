package a5;

import java.util.function.Function;
import java.util.function.Predicate;

public class Main5 {

    public static void main(String[] args) {

        // 与えられた数を2倍にする関数
        Function<Integer, Integer> multiplyByTwo = x -> x * 2;

        // 与えられた数から5を引く関数
        Function<Integer, Integer> subtractFive = x -> x - 5;

        // 結果が正の数かどうかを判定する関数
        Predicate<Integer> isPositive = x -> x > 0;

        // 初期値
        int value = 8;

        // 関数を順番に適用する
        int result = multiplyByTwo.apply(value);
        result = subtractFive.apply(result);

        // 最終結果が正の数かどうかを判定する
        if (isPositive.test(result)) {
            System.out.println("正の数です");
        } else {
            System.out.println("負の数またはゼロです");
        }
    }
}