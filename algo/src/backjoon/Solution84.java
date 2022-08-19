package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/1911
//흙길 보수하기
public class Solution84 {
    static int N,L;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        int arr[][] = new int[N][2];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] =Integer.parseInt(st.nextToken());
            arr[i][1] =Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1] - o2[1];
                }
                return o1[0] -  o2[0];
            }
        });

        int ans = 0;
        int now = 0;
        for(int i=0; i<N; i++){
//            System.out.println("now = " + now);
            if(arr[i][0] > now){
                now = arr[i][0];
            }
            if(arr[i][1]>=now){
                while(arr[i][1]>now){
                    now+=L;
                    ans++;
                }
            }
        }
        System.out.println(ans);

    }
}
