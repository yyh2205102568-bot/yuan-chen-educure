import java.util.Scanner;
public class Main8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("攻撃力を入力してください：");
        int attack = sc.nextInt();

        System.out.print("防御力を入力してください：");
        int defense = sc.nextInt();

        int damage = attack - defense;
        int critical = (int)(damage * 1.5);

        System.out.println("通常ダメージ：" + damage);
        System.out.println("クリティカルダメージ：" + critical);

        sc.close();
    }
}
    
