public class Main3 {
   public static void main(String[] args) {
    
    String input="Hello";

//メソッドを呼び出し
    String reversed=reverseString(input);

    System.out.println("入力:\""+input+"\"");

    System.out.println("出力:\""+reversed+"\"");

   } 
   
   public static String reverseString(String input){
    
    return new StringBuilder(input).reverse().toString();


   }
}
