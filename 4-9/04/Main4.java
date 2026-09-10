public class Main4 {

    public static void main(String[] args) {

        // StudentManagerクラスのインスタンスを作成する
        StudentManager manager = new StudentManager();

        // 5人の学生を登録する
        manager.addStudent("アリス");
        manager.addStudent("ボブ");
        manager.addStudent("チャーリー");
        manager.addStudent(null);
        manager.addStudent("イヴ");

        // 6人目の学生を追加する
        try {
            manager.addStudent("フランク");

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("エラー：" + e.getMessage());
        }

        // 学生ID 2の学生を表示する
        try {
            String student2 = manager.getStudent(2);
            System.out.println("学生ID 2: " + student2);

        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.out.println("エラー：" + e.getMessage());
        }

        // 学生ID 3の学生を取得する
        String student3 = null;

        try {
            student3 = manager.getStudent(3);

        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.out.println("エラー：" + e.getMessage());
        }

        // 取得結果を表示する
        System.out.println("学生ID 3: " + student3);

        // 存在しない学生ID 10を取得する
        String student10 = null;

        try {
            student10 = manager.getStudent(10);

        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.out.println("エラー：" + e.getMessage());
        }

        // 取得結果を表示する
        System.out.println("学生ID 10: " + student10);

        // 学生ID 0と1のデータを更新する
        try {
            manager.updateStudent(0, "フランク");
            manager.updateStudent(1, "ボビー");

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("エラー：" + e.getMessage());
        }

        // 更新後の学生ID 1を表示する
        try {
            String student1 = manager.getStudent(1);
            System.out.println("更新後の学生ID 1: " + student1);

        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.out.println("エラー：" + e.getMessage());
        }

        // 存在しない学生IDを更新する
        try {
            manager.updateStudent(10, "トム");

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("エラー：" + e.getMessage());
        }
    }
}