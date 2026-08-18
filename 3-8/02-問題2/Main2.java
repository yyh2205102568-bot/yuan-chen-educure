public class Main2 {
    public static void main(String[] args){
        Monster m=new Monster();//MonsterクラスからMonsterオブジェクトを作成します。 根据 Monster 类创建一个怪物对象，变量名叫 m
        m.attack();//Monsterクラスのattack()メソッドを呼び出します。  调用 Monster 的攻击方法

        Slime s=new Slime();
        s.attack();
    }
    
}
