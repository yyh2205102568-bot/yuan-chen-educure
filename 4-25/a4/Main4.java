package a4;
import java.util.Arrays;
import java.util.List;

public class Main4 {

    public static void main(String[] args) {

        // 数値のリストを作成
        List<Integer> numbers =
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 偶数を抽出し、2倍にして合計する
        int result = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .reduce(0, Integer::sum);

        // 結果を表示
        System.out.println("結果: " + result);
    }
}