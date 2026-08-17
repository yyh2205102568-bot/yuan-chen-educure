package task1;

public class GameCharacter {
 String name;
 
 int hp;

 Weapon weapon;//装備している武器（ぶき）

    //コンストラクタ
    public GameCharacter(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }
}
