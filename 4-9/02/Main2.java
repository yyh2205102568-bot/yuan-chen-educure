public class Main2 {

    public static void main(String[] args) {

        // テスト用の整数配列を作成する
        int[] numbers = {10, 20, 30};

        // ArrayAccessorクラスのインスタンスを作成する
        ArrayAccessor accessor = new ArrayAccessor(numbers);

        // 位置1の要素を取得する
        try {

            // 位置1を表示する
            System.out.println("位置1の要素");

            // 配列の位置1の値を取得して表示する
            System.out.println(accessor.getElement(1));

        } catch (ArrayIndexOutOfBoundsException e) {

            // 範囲外の場合はエラーメッセージを表示する
            System.out.println("エラー：" + e.getMessage());
        }

        System.out.println();

        // 位置5の要素を取得する
        try {

            // 位置5を表示する
            System.out.println("位置5の要素");

            // 配列の位置5の値を取得する
            System.out.println(accessor.getElement(5));

        } catch (ArrayIndexOutOfBoundsException e) {

            // 位置5は配列の範囲外なのでエラーを表示する
            System.out.println("エラー：" + e.getMessage());
        }
    }
}