package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2096
//내려가기
public class Solution61 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int m = 3;
//        int arr[][] = new int[N][N];

        int maxDp[][] = new int[2][3];
        int mmax = -1;
        int minDp[][] = new int[2][3];
        int mmin = 9999999;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<m; j++){
                int temp = Integer.parseInt(st.nextToken());
                if(i>0){
                    boolean isLeft = false;
                    boolean isRight = false;
                    if(j-1 >=0){
                        isLeft = true;
                    }
                    if(j+1 <m){
                        isRight = true;
                    }

                    if(isLeft && !isRight){ // x o o
                        maxDp[1][j] = Math.max(maxDp[0][j-1], maxDp[0][j]) + temp;//arr[i][j];
                        minDp[1][j] = Math.min(minDp[0][j-1], minDp[0][j]) + temp;//arr[i][j];
                    }
                    if(!isLeft && isRight){ // o o x
                        maxDp[1][j] = Math.max(maxDp[0][j+1], maxDp[0][j]) + temp;//arr[i][j];
                        minDp[1][j] = Math.min(minDp[0][j+1], minDp[0][j]) + temp;//arr[i][j];
                    }
                    if(isLeft && isRight){  // o o o
                        maxDp[1][j] = Math.max(maxDp[0][j-1], Math.max(maxDp[0][j], maxDp[0][j+1])) + temp;//arr[i][j];
                        minDp[1][j] = Math.min(minDp[0][j-1], Math.min(minDp[0][j], minDp[0][j+1])) + temp;//arr[i][j];
                    }
                }else{
                    maxDp[1][j] = temp;//arr[0][j];
                    minDp[1][j] = temp;//arr[0][j];
                }
            }

            for(int k=0; k<3; k++){
                maxDp[0][k] = maxDp[1][k];
                minDp[0][k] = minDp[1][k];

                if(i == N-1) {
                    if (mmax < maxDp[0][k]) {
                        mmax = maxDp[0][k];
                    }
                    if (mmin > minDp[0][k]) {
                        mmin = minDp[0][k];
                    }
                }
            }

        }


//        for(int iq=0; iq<2; iq++){
//            for(int jq=0; jq<3; jq++) {
//                System.out.print(minDp[iq][jq] + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println();
        System.out.println(mmax + " " + mmin);
    }
}
