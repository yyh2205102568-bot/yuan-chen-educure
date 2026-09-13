package a3;

public class Character implements Comparable<Character> {

    // キャラクター名
    private String name;

    // HP
    private int hp;

    // 攻撃力
    private int attack;

    // コンストラクタ
    public Character(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
    }

    // 戦闘力を返す
    public int getBattlePower() {
        return hp + attack;
    }

    // 戦闘力の高い順に並べる
    @Override
    public int compareTo(Character other) {
        return Integer.compare(
            other.getBattlePower(),
            this.getBattlePower()
        );
    }

    // キャラクター情報を文字列で返す
    @Override
    public String toString() {
        return name
                + " (HP:" + hp
                + " 攻撃力:" + attack
                + ") 戦闘力:" + getBattlePower();
    }
}