import java.util.Scanner;
//https://www.acmicpc.net/problem/2839
//설탕배달
public class Solution26 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int cnt = 0;
        int b = 0;


        while(true){

            if(N%5 ==0){
                int temp = (N/5) + b;
                System.out.println(temp);
                break;
            }
            if(N<=0){
                System.out.println("-1");
                break;
            }
            N -= 3;
            b++;
        }
    }
}
