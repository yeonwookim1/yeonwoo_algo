package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2751
//수 정렬하기2
public class Solution116 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(int a : arr){
            sb.append(a).append('\n');
        }
        System.out.print(sb);
    }
}
