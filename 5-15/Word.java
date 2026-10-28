// 英単語と日本語訳を管理するクラス
public class Word {

    private String english;
    private String japanese;

    // コンストラクタ
    public Word(String english, String japanese) {
        this.english = english;
        this.japanese = japanese;
    }

    // 英単語を取得する
    public String getEnglish() {
        return english;
    }

    // 英単語を設定する
    public void setEnglish(String english) {
        this.english = english;
    }

    // 日本語訳を取得する
    public String getJapanese() {
        return japanese;
    }

    // 日本語訳を設定する
    public void setJapanese(String japanese) {
        this.japanese = japanese;
    }
}