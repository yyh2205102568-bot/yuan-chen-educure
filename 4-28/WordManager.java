import java.util.ArrayList;
import java.util.List;
public class WordManager {

    // 単語リスト
    private List<Word>words;

    // コンストラクタ
    public WordManager(){
        words=new ArrayList<>();

    }
     // 単語を追加する
    public void addWord(Word word) {
        words.add(word);
    }

    // 単語リストを取得する
    public List<Word> getWords() {
        return words;
    }

    // 登録されている単語数を取得する
    public int getWordCount() {
        return words.size();
    }
}
