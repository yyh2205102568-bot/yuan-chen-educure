package task2;//boolean（true/false）、getter（获取 / 取得）、setter（设置 / 設定）、
// return（返回 / 値を返す）、this（自己的 / 自分自身の）



public class Book {//本が何を持っているか、どのように動作するかを定義する
    
    String title;
    
    boolean isLent; //（ブーリアン） true or false
    
    public void setTitle(String title){//set 設置本の名前
        
        this.title=title;
    }

        public String getTitle(){//このメソッドはString型の値を返します
        
            return title;//戻り値を返す
}
    public void lend(){
        if(isLent==false){
            isLent=true;
            System.out.println("本を貸し出しました");
       }else{
        System.out.println("申し訳ありません。この本は貸出中です。");
       }
    }   
   public void returnBook(){// 本を返却する（へんきゃくする）メソッド
    if(isLent==true){ // 貸出中の場合だけ返却する
       
        isLent=false;// 貸出状態をfalseに変更する
       
        System.out.println("本が返却されました");
  
    }else{// 貸出中ではない場合
   
        System.out.println("この本は貸出中ではありません");
    }

    
   }


}
