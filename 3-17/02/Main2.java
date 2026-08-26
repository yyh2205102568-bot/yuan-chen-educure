public class Main2 {

    public static void main(String[] args) {

        // 正しい名前と点数で学生を作成する
        Student student = new Student("田中太郎", 85);

        // 学生の名前と点数を表示する
        System.out.println(
            student.getName() + "さんの点数：" + student.getScore() + "点"
        );

        // 不正な点数を設定してエラーを確認する
        student.setScore(150);

        // 不正な名前を設定してエラーを確認する
        student.setName("");
    }
}