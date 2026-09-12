package a2;


public class Main2 {

    public static void main(String[] args) {

        // 1体目のMonsterインスタンスを作成
        // 名前：スライム、レベル：5
        Monster monster1 = new Monster("スライム", 5);

        // 2体目のMonsterインスタンスを作成
        // monster1と同じ名前、同じレベル
        Monster monster2 = new Monster("スライム", 5);

        // 3体目のMonsterインスタンスを作成
        // 名前は同じだが、レベルが違う
        Monster monster3 = new Monster("スライム", 10);


        // monster1とmonster2をequals()で比較する
        if (monster1.equals(monster2)) {

            // 名前とレベルが両方同じ場合
            System.out.println(
                "スライムLv.5 と スライムLv.5 は同じモンスターです"
            );

        } else {

            // 名前またはレベルが違う場合
            System.out.println(
                "スライムLv.5 と スライムLv.5 は違うモンスターです"
            );
        }


        // monster1とmonster3をequals()で比較する
        if (monster1.equals(monster3)) {

            // 名前とレベルが両方同じ場合
            System.out.println(
                "スライムLv.5 と スライムLv.10 は同じモンスターです"
            );

        } else {

            // 今回はレベルが違うため、こちらが実行される
            System.out.println(
                "スライムLv.5 と スライムLv.10 は違うモンスターです" );
        }
    }
}