public class ArrayAccessor {

    // 整数配列を保持するフィールド
    private int[] array;

    // コンストラクタ
    public ArrayAccessor(int[] array) {

        // 引数で受け取った配列をフィールドに代入する
        this.array = array;
    }

    // 指定された位置の要素を取得するメソッド
    public int getElement(int index)
            throws ArrayIndexOutOfBoundsException {

        // indexが配列の範囲外かどうかを確認する
        if (index < 0 || index >= array.length) {

            // 範囲外の場合は例外をスローする
            throw new ArrayIndexOutOfBoundsException(
                "指定された位置は範囲外です"
            );
        }

        // 正しい位置の場合は、その要素を返す
        return array[index];
    }
}