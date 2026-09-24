import java.io.File;
import java.io.IOException;

public class Main3 {

    public static void main(String[] args) {

        // フォルダを指定する
        File folder = new File("exercise_folder");
        // フォルダが存在しない場合は作成する
        if (!folder.exists()) {

            if (folder.mkdir()) {
                System.out.println("フォルダを作成しました。");

            } else {
                System.out.println("フォルダの作成に失敗しました。");

                // フォルダを作成できなかった場合は処理を終了する
                return;
            }

        } else {

            // 同名の通常ファイルが存在する場合は処理を終了する
            if (!folder.isDirectory()) {
                System.out.println("フォルダの作成に失敗しました。");
                return;
            }

            System.out.println("フォルダは既に存在します。");
        }

        // フォルダ内に作成するファイルを指定する
        File file = new File(folder, "exercise_file.txt");

        try {
            // 空のファイルを作成する
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