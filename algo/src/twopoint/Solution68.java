package twopoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1484
//다이어트
public class Solution68 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int start = 1;
        int end = 2;

        boolean isExist = false;

        while(end<100000){
            long diff = end*end - start*start;
            if(diff < N){
                end++;
            }else if(diff >=N){
                start++;
                if(diff==N){
                    System.out.println(end);
                    isExist = true;
                }
            }
        }

        if(!isExist){
            System.out.println("-1");
        }


    }


}
