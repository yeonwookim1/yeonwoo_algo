package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/14425
//문자열 집합
public class Solution75 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String,Integer> map = new HashMap<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(),i);
        }
        int ans =0;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            if(map.containsKey(st.nextToken())){
                ans++;
            }
        }

        System.out.println(ans);
    }
}
