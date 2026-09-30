package a3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main3 {

    public static void main(String[] args) {

        // 元の文字列リストを作成
        List<String> words =
                Arrays.asList("banana", "apple", "date", "cherry", "elderberry");

        // 5文字以上の文字列を抽出し、アルファベット順に並べる
        List<String> result = words.stream()
                .filter(word -> word.length() >= 5)
                .sorted()
                .collect(Collectors.toList());

        // 結果を表示
        System.out.println(result);
    }
}