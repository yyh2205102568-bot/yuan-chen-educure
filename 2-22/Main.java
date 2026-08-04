import java.util.Scanner;//

public class Main {
    static String[]englishWords=new String[20];//英単語を保存する配列
    static String[]japaneseWords=new String[20];
    static int wordCount=0;
    static int correctCount=0;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);//Scannerを作成する

        while(true){//メニュー繰り返し　選択終わるまで

            System.out.println("1:単語を登録する");
            System.out.println("2:クイズを受ける");
            System.out.println("3:終了する");

            String input=scanner.nextLine();//入力内容を文字列で保存する

            if(input.equals("1")){//equals :入力内容をチェックする

                registerWord(scanner);//単語登録メソッドを呼び出す

            }else if (input.equals("2")){
                startQuiz(scanner);//クイズメソッドを呼び出す
            
            }else if(input.equals("3")){
                System.out.println("プログラムが終了します");
                break;//繰り返しを終了する

            }else{//1-3以外入力されたとき
                System.out.println("1-3の数字を入力してください");
            }
                
            }
            scanner.close();//Scannerを閉じる

            }
            public static void registerWord(Scanner scanner){//単語を登録するメソッド
           
            if(wordCount>=20){//wordCount＝登録済みの単語数。20個以上なら配列が満杯なので登録を止める
                System.out.println("登録可能な単語数は20個までです");
                return;//このメソッドを終了する

            }
            System.out.println("英単語を入力してください:");
            String english= scanner.nextLine();//英単語を保存する

            System.out.println("日本語訳を入力してください:");
            String japanese= scanner.nextLine();
            
                        englishWords[wordCount]=english;//英単語を配列に保存する
                        japaneseWords[wordCount]=japanese;
            
                        wordCount++;//
            
                        System.out.println("単語を登録しました"); }// registerWordメソッドはここまで


public static void startQuiz(Scanner scanner){//クイズを実行するメソッド
    if(wordCount == 0){//登録単語がないかを確認する
        System.out.println("単語が登録されていません");
        return;//クイズを行わずメニューに戻る

    }
    correctCount=0;//正解数を0に戻す
    for(int i=0;i<wordCount;i++){//登録された単語を順番に出題する
    
        System.out.println(englishWords[i]+"の意味は?");
    
        String answer=scanner.nextLine();//answer=解答

       if(answer.equals(japaneseWords[i])){//登録した日本語訳と比較する

        System.out.println("正解です！");
        correctCount++;


       }else{
        System.out.println("不正解です");
       }
    }

    System.out.println(wordCount+"問中"+correctCount+"問正解でした！");

}

}
    

