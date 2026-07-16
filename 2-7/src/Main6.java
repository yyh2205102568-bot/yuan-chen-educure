import java.util.Scanner;
public class Main6 {
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("現在の経験値を入力してください：");
        String input = sc.nextLine();

        int exp = Integer.parseInt(input);
        int result = (int)(exp * 1.25);

        System.out.println("ボーナス後の経験値：" + result);
    }
}
