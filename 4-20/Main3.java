import java.io.File;
import java.io.IOException;

public class Main3 {

    public static void main(String[] args) {

        // STEP1：フォルダを作成する
        File folder = new File("exercise_folder");

        if (!folder.exists()) {

            if (folder.mkdir()) {
                System.out.println("フォルダを作成しました。");
            } else {
                System.out.println("フォルダの作成に失敗しました。");
            }

        } else {
            System.out.println("フォルダは既に存在します。");
        }

        // STEP2：作成したフォルダ内に空のファイルを作成する
        File file = new File(folder, "exercise_file.txt");

        try {

            if (file.createNewFile()) {
                System.out.println("ファイルを作成しました。");
            } else {
                System.out.println("ファイルは既に存在します。");
            }

        } catch (IOException e) {
            System.out.println("ファイルの作成中にエラーが発生しました。");
        }
    }
}