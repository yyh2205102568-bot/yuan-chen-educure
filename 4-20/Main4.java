import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main4 {

    public static void main(String[] args) {

        try {
            // コピー元のファイルを指定する
            Path source = Paths.get("source.txt");

            // ソースファイルが存在しない場合はサンプルファイルを作成する
            if (Files.notExists(source)) {
                Files.writeString(source, "Hello, Java!");
                System.out.println("ソースファイルを作成しました。");
            }

            // バックアップ用とアーカイブ用のフォルダを指定する
            Path backupFolder = Paths.get("backup");
            Path archiveFolder = Paths.get("archive");

            // フォルダが存在しない場合は作成する
            Files.createDirectories(backupFolder);
            Files.createDirectories(archiveFolder);

            // コピー先のファイルを指定する
            Path backupFile = backupFolder.resolve("source.txt");

            // source.txtをbackupフォルダにコピーする
            Files.copy(
                source,
                backupFile,
                StandardCopyOption.REPLACE_EXISTING
            );

            System.out.println("ファイルが 'backup/' にコピーされました。");

            // コピーが成功したか確認する
            if (Files.exists(backupFile)) {
                System.out.println("コピーの確認：成功");
            } else {
                System.out.println("コピーの確認：失敗");
                return;
            }

            // 移動先のファイルを指定する
            Path archiveFile = archiveFolder.resolve("source.txt");

            // backup/source.txtをarchiveフォルダに移動する
            Files.move(
                backupFile,
                archiveFile,
                StandardCopyOption.REPLACE_EXISTING
            );

            System.out.println("ファイルが 'archive/' に移動されました。");

            // 移動が成功したか確認する
            if (Files.exists(archiveFile) && Files.notExists(backupFile)) {
                System.out.println("移動の確認：成功");
            } else {
                System.out.println("移動の確認：失敗");
            }

        } catch (IOException e) {
            // 例外の詳細を表示する
            e.printStackTrace();
        }
    }
}