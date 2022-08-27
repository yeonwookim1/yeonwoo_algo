package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2776
//암기왕
public class Solution100 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int t =0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int arr[] = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            StringBuffer sb = new StringBuffer();

            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<M; i++){
                int target = Integer.parseInt(st.nextToken());
                int min = 0;
                int max = N-1;
                boolean isFind = false;
                while(min<=max){
                    int mid = (min+max)/2;
                    if(arr[mid]==target){
                        isFind = true;
                        break;
                    }else if(target<arr[mid]){
                        max = mid-1;
                    }else if(target > arr[mid]){
                        min = mid+1;
                    }
                }
                if(isFind){
                    sb.append("1\n");
                }else{
                    sb.append("0\n");
                }
            }
            String temp = sb.toString();
            System.out.println(temp.substring(0,temp.length()-1));
        }
    }
}
