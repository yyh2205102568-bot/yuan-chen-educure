package a4;

public class Main4 {

    public static void main(String[] args) {

        // オリジナルのキャラクターを作成
        PartyMember original = new PartyMember("アリス");

        // スキルを追加
        original.addSkill("ファイア");
        original.addSkill("ブリザード");


        // clone()で深いコピーを作成
        PartyMember copy = original.clone();


        // コピーしたキャラクターにスキルを追加
        copy.addSkill("サンダー");


        // 結果を表示
        System.out.println("--- 深いコピー後にスキル追加 ---");

        System.out.print("元のキャラクター ");
        original.showSkills();

        System.out.print("コピーしたキャラクター ");
        copy.showSkills();
    }
}