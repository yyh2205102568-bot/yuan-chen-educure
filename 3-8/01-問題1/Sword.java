public class Sword extends Weapon {//"extends" Weaponクラスを継承する

public Sword(String name, int power){
    
    super(name,power);//SwordクラスはWeaponクラスを継承し、superを使って親クラスのコンストラクタを呼び出します。
}
    
}
