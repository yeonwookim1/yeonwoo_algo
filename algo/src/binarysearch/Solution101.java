package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/status?user_id=kop4845&problem_id=3079&from_mine=1
//입국심사
public class Solution101 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        long M =Long.parseLong(st.nextToken());

        int arr[] = new int[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        long ans= 0;
        long min = 0;
        long max = M*arr[N-1];
        while(min<=max){
            long sum = 0;
            long mid = (min+max)/2;
            for(int i=0; i<N; i++){
                sum += mid/arr[i];
            }
            if(sum<M){
                min = mid+1;
            }else{
                max = mid-1;
                ans = mid;
            }
        }

        System.out.println(ans);
    }
}
