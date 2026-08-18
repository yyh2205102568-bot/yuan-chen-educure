public class Wizard  extends GameCharacter{
    int mp;

    public Wizard(String name,int hp,int mp){
        super(name,hp);//親クラスのコンストラクタを呼び出して、名前とHPを設定します。
        this.mp=mp;

    }
    public void showStatus(){
        System.out.println("名前:"+name);
        System.out.println("HP:"+hp);
        System.out.println("MP:"+mp); 
       }
}
