package a2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class Main2 {

    public static void main(String[] args) {

        // 元の文字列リストを作成
        List<String> words =
                Arrays.asList("apple", "banana", "cherry");

        // Stream APIを使ってすべて大文字に変換し、新しいリストを作成
        List<String> upperWords = words.stream()
                .map(word -> word.toUpperCase())
                .collect(Collectors.toList());

        // 結果を表示
        System.out.println(upperWords);
    }
}