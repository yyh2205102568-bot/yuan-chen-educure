package task1;//class（类 / クラス）、field（数据 / フィールド）、
// method()（方法 / メソッド）、new（创建实例 / インスタンス生成）



public class Main1 {//ペットのメソッドを呼び出して、実際に動作させる。
    public static void main(String[] args) {
        Pet pet=new Pet();
        
        pet.name="ポチ";
        
        pet.energy=100;
        
        System.out.println("ポチを生み出しました！");
        
        System.out.println("初期体力:"+pet.energy);
        
        pet.eat();
        pet.showEnergy();
        
        pet.play();
        pet.showEnergy();

    }

}
