public class Main4 {

    public static void main(String[] args) {

        // StudentManagerのインスタンスを作成する
        StudentManager manager = new StudentManager();

        // 5人分の学生データを登録する
        manager.addStudent("アリス");
        manager.addStudent("ボブ");
        manager.addStudent("チャーリー");
        manager.addStudent(null);
        manager.addStudent("イヴ");

        // 配列がいっぱいの状態で学生を追加する
        manager.addStudent("フランク");

        // 学生ID2を表示する
        System.out.println(
            "学生ID 2: " + manager.getStudent(2)
        );

        // データが登録されていない学生ID3を表示する
        System.out.println(
            "学生ID 3: " + manager.getStudent(3)
        );

        // 存在しない学生ID10を表示する
        System.out.println(
            "学生ID 10: " + manager.getStudent(10)
        );

        // 学生ID0と1を更新する
        manager.updateStudent(0, "フランク");
        manager.updateStudent(1, "ボビー");

        // 更新後の学生ID1を表示する
        System.out.println(
            "更新後の学生ID 1: " + manager.getStudent(1)
        );

        // 存在しない学生ID10を更新する
        manager.updateStudent(10, "トム");
    }
}