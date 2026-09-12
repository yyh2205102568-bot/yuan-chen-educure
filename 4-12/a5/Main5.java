package a5;

public class Main5 {

    public static void main(String[] args) {

        // キャラクターを作成
        GameCharacter character = new GameCharacter("勇者A");


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


        // 装備品を強さ順に並べ替える
        character.sortEquipments();


        // ソート結果を確認する
        // 伝説の剣 → 光の盾 → 魔法の靴
        if (sword.compareTo(shield) < 0
                && shield.compareTo(shoes) < 0) {

            System.out.println("装備の強さソート: OK");

        } else {

            System.out.println("装備の強さソート: NG");
        }
    }
}