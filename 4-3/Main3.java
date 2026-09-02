public class Main3 {

    public static boolean validateUsername(String username) {

        // ユーザー名が4～16文字で、英数字とアンダースコアのみか確認する
        // 数字だけのユーザー名は無効とする
        return username.matches("^(?![0-9]+$)[A-Za-z0-9_]{4,16}$");
    }

    public static boolean validatePassword(String password) {

        // 8文字以上で、大文字と数字を少なくとも1つ含むか確認する
        return password.matches("^(?=.*[A-Z])(?=.*[0-9]).{8,}$");
    }

    public static void main(String[] args) {

        // テストケース
        String[] usernames = {"Player_1", "123456", "P@layer"};
        String[] passwords = {"Password123", "password123", "Pass"};

        // ユーザー名をチェックする
        System.out.println("ユーザー名チェック:");

        for (String username : usernames) {
            if (validateUsername(username)) {
                System.out.println(username + ": 有効");
            } else {
                System.out.println(username + ": 無効");
            }
        }

        // パスワードをチェックする
        System.out.println("パスワードチェック:");

        for (String password : passwords) {
            if (validatePassword(password)) {
                System.out.println(password + ": 有効");
            } else {
                System.out.println(password + ": 無効");
            }
        }
    }
}