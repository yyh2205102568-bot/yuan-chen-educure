package a2;

public class Monster {

    // モンスター名を保存するフィールド
    private String name;

    // モンスターのレベルを保存するフィールド
    private int level;


    // コンストラクタ
    // Monsterインスタンスを作成するときに
    // モンスター名とレベルを受け取ってフィールドに保存する
    public Monster(String name, int level) {
        this.name = name;
        this.level = level;
    }


    // equals()メソッドをオーバーライドする
    // 2つのMonsterが同じ内容かどうかを判定する
    @Override
    public boolean equals(Object obj) {

        // 自分自身と比較している場合は同じオブジェクトなのでtrue
        if (this == obj) {
            return true;
        }

        // 比較する相手がnullの場合は同じではないのでfalse
        if (obj == null) {
            return false;
        }

        // 自分と相手のクラスが違う場合はfalse
        if (getClass() != obj.getClass()) {
            return false;
        }

        // Object型のobjをMonster型に変換する
        Monster other = (Monster) obj;

        // モンスター名とレベルを比較する
        // 名前とレベルの両方が同じ場合だけtrueを返す
        return name.equals(other.name)
                && level == other.level;
    }
}