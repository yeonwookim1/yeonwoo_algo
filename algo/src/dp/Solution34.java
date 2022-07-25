package dp;

import java.util.Scanner;
//https://www.acmicpc.net/problem/11726
//2*n 타일링
public class Solution34 {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N= sc.nextInt();
        int arr[] = new int[N+2];
        arr[1] = 1;
        arr[2] = 2;
        for(int i=3; i<=N; i++){
            arr[i] = (arr[i-1] + arr[i-2])% 10007;
        }
        System.out.println(arr[N]);
    }
}
