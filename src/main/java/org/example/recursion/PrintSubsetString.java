package org.example.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintSubsetString {
    static List<String> list = new ArrayList<>();

    static void printStringArray(String[] arr){
        String result = "";
        for(String s : arr){
            if("".equals(result))
                result =  result + "{ "+s;
            else
                result = ","+s;

        }
        result = result +" }";
        System.out.println(result);
    }
    private static void findsubsequences(String s,
                                         String ans)
    {
        if (s.length() == 0) {
            list.add(ans);
            return;
        }

        String s1 = s.substring(1);
        String op1 = ans;
        findsubsequences(s1, op1);

        String s2 = s.substring(1);
        String op2 = ans + s.charAt(0) ;
        findsubsequences(s2,op2);


    }

    public static void main(String[] args) {
        String input = "abc";
        findsubsequences(input, "");
        System.out.println(list);
    }
}
