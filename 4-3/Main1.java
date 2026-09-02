public class Main1{
    public static void main(String[] args) {
        String str1="Hello";
        String str2="World";

    //str1とstr2の2つの文字列を連結し、resultに保存する
        String result=str1+str2;


        System.out.println("元の文字列1:"+str1);
        System.out.println("元の文字列2:"+str2);

        System.out.println("連結後"+result);

        String part = result.substring(2, 7);

        System.out.println("部分文字列(3-7): " + part);
    }
}