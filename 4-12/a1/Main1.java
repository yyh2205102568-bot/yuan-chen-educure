package a1;


public class Main1 {
    public static void main(String[] args) {
        // 1つ目のGameItemインスタンスを作成
        GameItem item1=new GameItem("回復薬",100);

        // 2つ目のGameItemインスタンスを作成
        GameItem item2=new GameItem("魔法の杖",1500);

        // タイトルを表示
        System.out.println("アイテム情報:");

         // アイテム情報を表示
         System.out.println(item1);
         System.out.println(item2);

    }
}
