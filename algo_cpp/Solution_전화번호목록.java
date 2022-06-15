package com.java.algo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Solution1 {

    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        // Arrays.sort(phone_book, new Comparator<String>() {
        //     @Override
        //     public int compare(String s1, String s2) {
        //         if(s1.length() > s2.length()){
        //             return 1;
        //         } else if(s1.length() < s2.length()){
        //             return -1;
        //         } else{
        //             return 0;
        //         }
        //     }
        // });

        // Arrays.sort(phone_book);


        // for(int i=0; i<phone_book.length -1; i++){
        //     if(phone_book[i+1].startsWith(phone_book[i])){
        //         answer = false;
        //         break;
        //     }
        // }

        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<phone_book.length -1; i++){
            map.put(phone_book[i],i);
        }

        for(int i=0; i<phone_book.length; i++){
            for(int j=0; j<phone_book[i].length(); i++){
                if(map.containsKey(phone_book[i].substring(0, j))){
                    return false;
                }
            }
        }

        return answer;
    }



    
}
