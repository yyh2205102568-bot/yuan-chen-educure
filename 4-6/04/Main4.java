import java.util.ArrayList;
import java.util.HashSet;

public class Main4 {
    public static void main(String[] args) {

        // 全モンスターのリストを作成
        ArrayList<String> allMonsters = new ArrayList<>();

        allMonsters.add("スライム");
        allMonsters.add("ドラゴン");
        allMonsters.add("ゴブリン");
        allMonsters.add("フェニックス");
        allMonsters.add("ユニコーン");


        // 戦闘履歴を管理するArrayListを作成
        ArrayList<String> battleHistory = new ArrayList<>();

        // 戦闘履歴を追加
        battleHistory.add("スライム");
        battleHistory.add("スライム");
        battleHistory.add("スライム");
        battleHistory.add("スライム");
        battleHistory.add("スライム");

        battleHistory.add("ドラゴン");
        battleHistory.add("ドラゴン");

        battleHistory.add("ゴブリン");
        battleHistory.add("ゴブリン");


        // 発見したモンスターを管理するHashSetを作成
        // HashSetは重複したデータを保存しない
        HashSet<String> discoveredMonsters = new HashSet<>();

        // 戦闘したモンスターを発見済みとして記録
        discoveredMonsters.addAll(battleHistory);


        // 表示用の発見済みモンスターリストを作成
        ArrayList<String> discoveredList = new ArrayList<>();

        for (String monster : allMonsters) {
            if (discoveredMonsters.contains(monster)) {
                discoveredList.add(monster);
            }
        }


        // 発見済みモンスターを表示
        System.out.println("発見済みモンスター:" + discoveredList);

        // 発見済みモンスター数を表示
        System.out.println("発見済みモンスター数:" + discoveredMonsters.size());


        // スライムとの戦闘回数を数える
        int slimeCount = 0;

        for (String monster : battleHistory) {
            if (monster.equals("スライム")) {
                slimeCount++;
            }
        }

        // スライムとの戦闘回数を表示
        System.out.println("スライムとの戦闘回数:" + slimeCount);


        // 未発見のモンスターを保存するリストを作成
        ArrayList<String> undiscoveredMonsters = new ArrayList<>();

        for (String monster : allMonsters) {
            if (!discoveredMonsters.contains(monster)) {
                undiscoveredMonsters.add(monster);
            }
        }

        // 未発見のモンスターを表示
        System.out.println("未発見のモンスター:" + undiscoveredMonsters);
    }
}