package a5;

import java.util.List;

public class Main5 {

    public static void main(String[] args) {

        // キャラクターを作成
        GameCharacter character =
                new GameCharacter("勇者A");

        // 装備品を作成
        Equipment sword =
                new Equipment("伝説の剣", 100, 0);

        Equipment shield =
                new Equipment("光の盾", 0, 80);

        Equipment shoes =
                new Equipment("魔法の靴", 10, 20);

        // キャラクターに装備品を追加
        character.addEquipment(sword);
        character.addEquipment(shield);
        character.addEquipment(shoes);

        // キャラクター装備情報を表示
        System.out.println("--- キャラクター装備情報 ---");
        character.showEquipments();

        // 装備品の複製テスト
        Equipment copiedSword = sword.clone();

        if (sword.equals(copiedSword)) {
            System.out.println("\n装備の複製テスト: OK");
        } else {
            System.out.println("\n装備の複製テスト: NG");
        }

        // 装備品の比較テスト
        if (sword.compareTo(shield) < 0) {
            System.out.println("装備の比較テスト: OK");
        } else {
            System.out.println("装備の比較テスト: NG");
        }

        // ソート確認用のキャラクターを作成
        GameCharacter sortTestCharacter =
                new GameCharacter("ソートテスト");

        // あえて総合力がバラバラの順番で追加する
        sortTestCharacter.addEquipment(shoes);
        sortTestCharacter.addEquipment(sword);
        sortTestCharacter.addEquipment(shield);

        // 装備品を総合力の高い順に並べ替える
        sortTestCharacter.sortEquipments();

        // 並べ替え後の装備リストを取得する
        List<Equipment> equipments =
                sortTestCharacter.getEquipments();

        // ソートされていると仮定する
        boolean isSorted = true;

        // 隣り合う装備品の総合力を順番に確認する
        for (int i = 0; i < equipments.size() - 1; i++) {

            // 前の装備品の総合力が次の装備品より小さい場合はNG
            if (equipments.get(i).getPower()
                    < equipments.get(i + 1).getPower()) {

                isSorted = false;
                break;
            }
        }

        // ソート結果を表示する
        if (isSorted) {
            System.out.println("装備の強さソート: OK");
        } else {
            System.out.println("装備の強さソート: NG");
        }
    }
}