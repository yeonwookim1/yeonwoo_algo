package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution43 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = null;

        for(int i=0; i<3; i++){
            int cnt = 0;
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<4; j++){
                int x =Integer.parseInt(st.nextToken());
                if(x==1){
                    cnt++;
                }
            }
            if(cnt==1){
                System.out.println("C");
            }else if(cnt==2){
                System.out.println("B");
            }else if(cnt==3){
                System.out.println("A");
            }else if(cnt==4){
                System.out.println("E");
            }else{
                System.out.println("D");
            }
        }
    }
}
