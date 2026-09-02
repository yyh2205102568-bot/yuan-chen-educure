import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;

public class Main4 {

    private String eventName;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;

    public Main4(String name, ZonedDateTime start, ZonedDateTime end) {
        this.eventName = name;
        this.startTime = start;
        this.endTime = end;
    }

    // イベントの開催期間を取得する
    public String getEventDuration() {
        Duration duration = Duration.between(startTime, endTime);
        long days = duration.toDays();
        long hours = duration.toHours() % 24;

        return days + "日と" + hours + "時間";
    }

    // 東京時間を指定された形式で取得する
    public String getLocalTime() {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy年M月d日 HH:mm z");

        return startTime.format(formatter);
    }

    // 開始日時をUTC時間に変換して取得する
    public String getUtcTime() {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy年M月d日 HH:mm z");

        return startTime
                .withZoneSameInstant(ZoneId.of("UTC"))
                .format(formatter);
    }

    public static void main(String[] args) {

        // 東京のタイムゾーンを設定する
        ZoneId tokyoZone = ZoneId.of("Asia/Tokyo");

        // イベントの開始日時を設定する
        ZonedDateTime start = ZonedDateTime.of(
                2024, 7, 1, 10, 0, 0, 0, tokyoZone);

        // イベントの終了日時を設定する
        ZonedDateTime end = ZonedDateTime.of(
                2024, 7, 15, 22, 0, 0, 0, tokyoZone);

        // イベント情報を作成する
        Main4 event = new Main4(
                "サマーフェスティバル",
                start,
                end
        );

        // 日時の表示形式を設定する
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy年M月d日 HH:mm z");

        // イベント情報を表示する
        System.out.println("イベント: " + event.eventName);
        System.out.println("開始: " + event.startTime.format(formatter));
        System.out.println("終了: " + event.endTime.format(formatter));
        System.out.println("期間: " + event.getEventDuration());
        System.out.println("現地時間: " + event.getLocalTime());
        System.out.println("UTC時間: " + event.getUtcTime());
    }
}