package a3;

// 商品カテゴリの列挙型
public enum ProductCategory {

    FRUITS("果物"),
    VEGETABLES("野菜"),
    DAIRY("乳製品");

    // 表示名
    private final String displayName;

    // コンストラクタ
    ProductCategory(String displayName) {
        this.displayName = displayName;
    }

    // 表示名を取得する
    public String getDisplayName() {
        return displayName;
    }
}