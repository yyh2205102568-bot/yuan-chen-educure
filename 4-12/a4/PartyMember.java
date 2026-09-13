package a4;

import java.util.ArrayList;
import java.util.List;

public class PartyMember implements Cloneable {

    // キャラクター名
    private String name;

    // スキルリスト
    private List<String> skills;


    // コンストラクタ
    public PartyMember(String name) {
        this.name = name;
        this.skills = new ArrayList<>();
    }


    // スキルを追加する
    public void addSkill(String skill) {
        skills.add(skill);
    }


    // 深いコピーを作成する
    @Override
    public PartyMember clone() {
        try {
            PartyMember copy = (PartyMember) super.clone();

            // スキルリストも別のListとしてコピーする
            copy.skills = new ArrayList<>(this.skills);

            return copy;

        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }


    // キャラクター名とスキルを表示する
    public void showSkills() {
        System.out.println("「" + name + "」のスキル: " + skills);
    }
}