package a1;
import java.io.*;
import java.net.*;

public class Main1 {
    
    public static void main(String[] args) throws IOException{
        
        String keyword="Java";
        
        String searchURL=
        
        "https://www.google.com/search?q="
       
        +URLEncoder.encode(keyword,"UTF-8");
       
        URL url = new URL(searchURL);
       
        InputStream is = url.openStream();
        
        //  バイトデータを文字として読み込めるようにする
        InputStreamReader isr = new InputStreamReader(is);
        
        int i = isr.read();
        
        while (i != -1) {
            System.out.print((char) i);
            i = isr.read();
        }
       
        // ストリームを閉じる
        isr.close();


    }
}

