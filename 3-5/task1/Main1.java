package task1;

public class Main1 {
    public static void main(String[] args) {

        // 武器のインスタンスを生成する
        Weapon weapon = new Weapon("魔法の剣", 50);

        // キャラクターのインスタンスを生成する
        GameCharacter character =
                new GameCharacter("剣士アレックス", 100);

        // 武器を装備させる
        character.weapon = weapon;

        System.out.println(
                character.name + "は" +
                character.weapon.name +
                "を装備しています"
        );
    }
}
