package twopoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoPointTest {

    public static void main(String[] args) {
        int arr[] = {5,3,7,2,1,4,22,6,43,27};

        int cnt = 0 ;
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                if(arr[i] + arr[j] == 10){
                    cnt++;
                    System.out.println(arr[i] + arr[j]);
                }
            }
        }
        System.out.println("cnt = " + cnt);
        cnt = 0;

        System.out.println("======================================");
        int start =0;
        int end = arr.length-1;
        Arrays.sort(arr);
        while(start<=end){
            int temp = arr[start] + arr[end];
            if(temp==10){
                System.out.println(temp);
                cnt++;
                start++;
                end--;
            }else if (temp <10){
                start++;
            }else{
                end--;
            }



        }

        System.out.println(cnt);

    }
}
