package a1;

import java.util.function.Function;

public class Main1{
    
    public static void main(String[]args){
        
        Function<Integer,Integer>doubleValue=x->x*2;
        
        int result=doubleValue.apply(10);
        
        System.out.println(result);

    }
}