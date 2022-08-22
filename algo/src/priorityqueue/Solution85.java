package priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/status?user_id=kop4845&problem_id=1927&from_mine=1
//최소힙
public class Solution85 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> q = new PriorityQueue<>();
        while(N>0){
            st = new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());

            if(temp == 0){
                if(!q.isEmpty()){
                    int top = q.peek();
                    System.out.println(top);
                    q.poll();
                }else{
                    System.out.println("0");
                }
            }else{
                q.add(temp);
            }

            N--;
        }
    }
}
