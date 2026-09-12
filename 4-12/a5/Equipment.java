package a5;

public class Equipment implements Cloneable, Comparable<Equipment> {

    // 装備品名
    private String name;

    // 攻撃力
    private int attack;

    // 防御力
    private int defense;


    // コンストラクタ
    public Equipment(String name, int attack, int defense) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
    }


    // 総合力を返す
    public int getPower() {
        return attack + defense;
    }


    // 装備品を複製する
    @Override
    public Equipment clone() {
        try {
            return (Equipment) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }


    // 名前、攻撃力、防御力がすべて同じか判定する
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        Equipment other = (Equipment) obj;

        return name.equals(other.name)
                && attack == other.attack
                && defense == other.defense;
    }


    // 総合力の高い順に並べる
    @Override
    public int compareTo(Equipment other) {
        return Integer.compare(
                other.getPower(),
                this.getPower()
        );
    }


    // 装備品情報を文字列で返す
    @Override
    public String toString() {
        return name
                + " (攻撃力:" + attack
                + " 防御力:" + defense
                + ")";
    }
}