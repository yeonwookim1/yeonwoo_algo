package priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1655
//가운데를 말해요
public class Solution88 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        while(N>0){
            int temp = Integer.parseInt(br.readLine());
            if(max.size() == min.size()){
                if(!min.isEmpty()){
                    if(min.peek() < temp){
                        int goMax = min.poll();
                        max.add(goMax);
                        min.add(temp);
                    }else{
                        max.add(temp);
                    }
                }else{
                    max.add(temp);
                }
            }else if(max.size() > min.size()){
                if(temp < max.peek()){
                    int goMin = max.poll();
                    min.add(goMin);
                    max.add(temp);
                }else{
                    min.add(temp);
                }
            }else{
                if(min.peek() < temp){
                    int goMax = min.poll();
                    max.add(goMax);
                    min.add(temp);
                }else{
                    max.add(temp);
                }
            }

            sb.append(max.peek() + "\n");

            N--;
        }
        System.out.println(sb);

    }

//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
//        StringTokenizer st = null;
//        st = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(st.nextToken());
//        StringBuilder sb = new StringBuilder();
//        PriorityQueue<Integer> max = new PriorityQueue<>((o1,o2)->o2-o1);
//        PriorityQueue<Integer> min = new PriorityQueue<>((o1,o2) -> o1-o2);
//        while(N>0){
//            int temp = Integer.parseInt(br.readLine());
//
//
//            if(max.size() == min.size()) {
//                max.offer(temp);
//            }else{
//                min.offer(temp);
//            }
//
//            if(!max.isEmpty() && !min.isEmpty()){
//                if(max.peek() > min.peek()){
//                    int goMin = max.poll();
//                    int goMax = min.poll();
//                    min.offer(goMin);
//                    max.offer(goMax);
//                }
//            }
//            sb.append(max.peek() + "\n");
////            System.out.print(max.peek() + "\n");
//
//            N--;
//        }
//        System.out.println(sb);
//
//    }
}
