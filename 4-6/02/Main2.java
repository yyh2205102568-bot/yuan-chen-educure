import java.util.ArrayList;

public class Main2 {
    
    public static void main(String[] args) {

        //// 点数を管理するArrayListを作成
        ArrayList<Integer>scores=new ArrayList<>();

        // 点数を追加
        scores.add(85);
        scores.add(92);
        scores.add(78);
        scores.add(55);
        scores.add(43);

         // 点数リストを表示
        System.out.println("点数リスト:"+scores);

        // 合計点を計算
        int total=0;

         // リストの点数を1つずつ取り出して合計する
        for(Integer score:scores){
            total+=score;  //total=total+score;
        }

            // 平均点を計算
            double acerage=(double)total/scores.size();

            // 平均点を表示
            System.out.println("平均点:"+acerage);

            // 最初の点数を最高点として設定
            int max=scores.get(0);

             // 最高点を調べる
            for(Integer score:scores){
                if(score>max){
                    max=score;

                }

        }
        // 最高点を表示
        System.out.println("最高点:" + max);

         // 60点以下の人数を数えるための変数
          int count = 0;

          // 60点以下かどうかを確認
          for (Integer score : scores) {
            if(score<=60){
                count++;
            }
    }
    // 60点以下の人数を表示
    System.out.println("60点以下の人数:" + count);
        }
}
