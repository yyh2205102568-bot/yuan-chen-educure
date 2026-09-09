public class StudentManager {

    // 5人分の学生名を保存する配列
    private String[] students = new String[5];

    // 現在登録されている学生数
    private int count = 0;

    // 学生を追加するメソッド
    public void addStudent(String name) {

        // 配列がいっぱいの場合
        if (count >= students.length) {
            System.out.println(
                "エラー：これ以上学生を追加できません。リストがいっぱいです。"
            );
            return;
        }

        // 学生名を配列に登録する
        students[count] = name;

        // 登録人数を1増やす
        count++;
    }

    // 指定したIDの学生を取得するメソッド
    public String getStudent(int id) {

        // IDが配列の範囲外の場合
        if (id < 0 || id >= students.length) {
            System.out.println(
                "エラー：無効な学生IDです：" + id
            );
            return null;
        }

        // 学生データが登録されていない場合
        if (students[id] == null) {
            System.out.println(
                "エラー：学生ID " + id + " にデータがありません。"
            );
            return null;
        }

        // 正常な場合は学生名を返す
        return students[id];
    }

    // 学生情報を更新するメソッド
    public void updateStudent(int id, String name) {

        // IDが配列の範囲外の場合
        if (id < 0 || id >= students.length) {
            System.out.println(
                "エラー：無効な学生IDです：" + id
            );
            return;
        }

        // 学生名を更新する
        students[id] = name;
    }
}