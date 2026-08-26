public class Student {

    // 学生の名前を保存するフィールド
    private String name;

    // 学生の点数を保存するフィールド
    private int score;

    // コンストラクタ
    // 名前と点数を受け取り、setterを使って設定する
    public Student(String name, int score) {
        setName(name);
        setScore(score);
    }

    // 名前を取得するgetterメソッド
    public String getName() {
        return this.name;
    }

    // 名前を設定するsetterメソッド
    public void setName(String name) {

        // 名前がnullの場合はエラー
        if (name == null) {
            System.out.println("エラー：名前は1-20文字で設定してください");
            return;
        }

        // 名前が1文字未満、または20文字を超える場合はエラー
        if (name.length() < 1 || name.length() > 20) {
            System.out.println("エラー：名前は1-20文字で設定してください");
            return;
        }

        // 正しい名前の場合のみ設定する
        this.name = name;
    }

    // 点数を取得するgetterメソッド
    public int getScore() {
        return this.score;
    }

    // 点数を設定するsetterメソッド
    public void setScore(int score) {

        // 点数が0未満、または100を超える場合はエラー
        if (score < 0 || score > 100) {
            System.out.println("エラー：点数は0-100の範囲で設定してください");
            return;
        }

        // 正しい点数の場合のみ設定する
        this.score = score;
    }
}