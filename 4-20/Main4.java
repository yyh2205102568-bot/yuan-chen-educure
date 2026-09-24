import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main4 {

    public static void main(String[] args) {

        try {
            // STEP1：コピー元のファイルを指定する
            Path source = Paths.get("source.txt");

            // STEP2：バックアップ用とアーカイブ用のフォルダを作成する
            Path backupFolder = Paths.get("backup");
            Path archiveFolder = Paths.get("archive");

            Files.createDirectories(backupFolder);
            Files.createDirectories(archiveFolder);

            // STEP3：コピー先のファイルを指定する
            Path backupFile = backupFolder.resolve("source.txt");

            // STEP4：source.txtをbackupフォルダにコピーする
            Files.copy(
                source,
                backupFile,
                StandardCopyOption.REPLACE_EXISTING
            );

            System.out.println("ファイルが 'backup/' にコピーされました。");

            // STEP5：コピーが成功したか確認する
            if (Files.exists(backupFile)) {
                System.out.println("コピーの確認：成功");
            } else {
                System.out.println("コピーの確認：失敗");
            }

            // STEP6：移動先のファイルを指定する
            Path archiveFile = archiveFolder.resolve("source.txt");

            // STEP7：バックアップファイルをarchiveフォルダに移動する
            Files.move(
                backupFile,
                archiveFile,
                StandardCopyOption.REPLACE_EXISTING
            );

            System.out.println("ファイルが 'archive/' に移動されました。");

            // STEP8：移動が成功したか確認する
            if (Files.exists(archiveFile) && Files.notExists(backupFile)) {
                System.out.println("移動の確認：成功");
            } else {
                System.out.println("移動の確認：失敗");
            }

        } catch (IOException e) {

            // 例外が発生した場合はエラーの詳細を表示する
            e.printStackTrace();

        }
    }
}