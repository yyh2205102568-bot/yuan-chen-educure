public class Character {
    public String name;
    public int hp;

    public Character(String name,int hp){//名前とHPを受け取り、このCharacterオブジェクトのフィールドに設定します。
        //接收名字和HP，然后保存到这个 Character 对象自己的字段里
        this.name=name;
        this.hp=hp;


    }    
public void showStatus(){//"showStatus"キャラクターの名前とHPを表示するメソッド 显示状态
    System.out.println("名前:"+name);
    System.out.println("HP:"+hp);
}
}

