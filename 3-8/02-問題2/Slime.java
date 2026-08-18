public class Slime extends Monster {//SlimeクラスはMonsterクラスを継承します。
    @Override//親クラスのメソッドを子クラスで上書きします。
    public void attack(){
        System.out.println("スライムが体当たりをした!");
    }
    
}
