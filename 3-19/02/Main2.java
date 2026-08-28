public class Main2 {

    public static void main(String[] args) {

        // 学籍番号が同じ学生を作成
        Student student1 = new Student(1001, "田中太郎");
        Student student2 = new Student(1001, "佐藤花子");

        // 学籍番号が違う学生を作成
        Student student3 = new Student(2002, "鈴木一郎");

        // student1とstudent2を比較する
        if (student1.equals(student2)) {
            System.out.println("同一の学生です");
        } else {
            System.out.println("違う学生です");
        }

        // student1とstudent3を比較する
        if (student1.equals(student3)) {
            System.out.println("同一の学生です");
        } else {
            System.out.println("違う学生です");
        }
    }
}