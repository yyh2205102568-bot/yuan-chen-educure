public class Warrior extends Character{
    public String job="戦士";

    public Warrior(String name,int hp){
        super(name,hp);//親クラスCharacterのコンストラクタを呼び出します  调用父类 Character 的构造方法。
    }
    @Override
    public void showStatus(){
        super.showStatus();//親クラスCharacterのshowStatus()メソッドを呼び出します。
        //调用父类 Character 里面的 showStatus() 方法。
        System.out.println("職業:"+job);
    }
}
