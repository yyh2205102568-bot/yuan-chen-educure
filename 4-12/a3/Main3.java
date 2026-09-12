package a3;

import java.util.ArrayList;
import java.util.Collections;

public class Main3 {

    public static void main(String[] args) {

        // キャラクターリストを作成
        ArrayList<Character> characters = new ArrayList<>();

        // キャラクターを追加
        characters.add(new Character("勇者A", 100, 50));
        characters.add(new Character("魔法使いB", 70, 70));
        characters.add(new Character("戦士C", 80, 40));

        // 戦闘力の高い順に並べ替える
        Collections.sort(characters);

        // 結果を表示
        System.out.println("--- 戦闘力順 ---");

        for (Character character : characters) {
            System.out.println(character);
        }
    }
}