public class StudentManager {

    // 5人分の学生名を保存する配列
    private String[] students = new String[5];

    // 現在登録されている学生数
    private int count = 0;

    // 学生を追加するメソッド
    public void addStudent(String name) {

        // 配列がいっぱいの場合は例外をスローする
        if (count >= students.length) {
            throw new ArrayIndexOutOfBoundsException(
                "これ以上学生を追加できません。リストがいっぱいです。"
            );
        }

        // 学生名を配列に登録する
        students[count] = name;
        count++;
    }

    // 指定したIDの学生を取得するメソッド
    public String getStudent(int id) {

        // IDが配列の範囲外の場合は例外をスローする
        if (id < 0 || id >= students.length) {
            throw new ArrayIndexOutOfBoundsException(
                "無効な学生IDです：" + id
            );
        }

        // IDは有効だが、データが登録されていない場合
        if (students[id] == null) {
            throw new NullPointerException(
                "学生ID " + id + " にデータがありません。"
            );
        }

        // 正常な場合は学生名を返す
        return students[id];
    }

    // 学生情報を更新するメソッド
    public void updateStudent(int id, String name) {

        // IDが配列の範囲外の場合は例外をスローする
        if (id < 0 || id >= students.length) {
            throw new ArrayIndexOutOfBoundsException(
                "無効な学生IDです：" + id
            );
        }

        // 学生名を更新する
        students[id] = name;
    }
}