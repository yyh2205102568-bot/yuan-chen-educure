package task4;//final（固定值 / 定数）、boolean（true/false）、
// isRepaired（是否修理过 / 修理済みかどうか）、repair()（修理 / 修理する）、
// durability（耐久度 / 耐久度）、use()（使用武器 / 武器を使用する）

public class Main4 {
    public static void main(String[] args) {

        // Weaponのインスタンスを生成
        Weapon weapon = new Weapon();

        // 武器名「伝説の剣」、攻撃力100を設定
        weapon.setWeapon("伝説の剣", 100);

        // 10回使用して耐久度を0にする
        for (int i = 0; i < 10; i++) {
            weapon.use();
        }

        // 耐久度0の状態でもう一度使用
        weapon.use();

        // 武器を修理
        weapon.repair();

        // 修理後、再度使用
        weapon.use();
    }
}
