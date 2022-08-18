package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/20055
//컨베이어 벨트 위의 로봇
public class Solution83 {

    static int N,K;
    static int arr[];
    static List<Integer> robot;
    public static void rotate(){
        int preValue = arr[arr.length-1];
        for(int i=0; i<arr.length; i++){
            int value = arr[i];
            arr[i] = preValue;
            preValue = value;
        }
        forword();
    }
    public static void forword(){
        int a = robot.size()-1;
        int idx = 0;
        List<Integer> tempList = new ArrayList<>();
        for(int i=0; i<robot.size(); i++){
            tempList.add(robot.get(i)+1);
        }
        while(!robot.isEmpty()){
            robot.remove(0);
        }
        robot.addAll(tempList);
    }

    public static void down(){
        for(int i=0; i<robot.size(); i++){
            if(robot.get(i) >=N-1){
                robot.remove(i);
//                System.out.println("DOWND");
                break;
            }
        }
    }
    public static void addRobot(){
        if(arr[0] >=1){
            robot.add(0);
            arr[0]--;
        }
    }
    public static void forwardRobot(){
        List<Integer> tempList = new ArrayList<>();
        int visit[] = new int[2*N];
        for (Integer integer : robot) {
            if(arr[integer+1] >= 1 && visit[integer+1] == 0){
                tempList.add(integer + 1);
                visit[integer+1]=1;
                arr[integer+1]--;
            } else{
                tempList.add(integer);
                visit[integer]=1;
            }

        }
        while(!robot.isEmpty()){
            robot.remove(0);
        }

        robot.addAll(tempList);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        //2N
        arr = new int[2*N];
        for(int i=0; i<2*N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        robot = new ArrayList<>();
        int cnt = 0;
        int time =0;
//        addRobot();
        while(true){
            if(cnt>=K){
                break;
            }
            //컨베회전
            rotate();
            // 내릴꺼 체크
            down();
            // 로봇 전진
            forwardRobot();
            //내릴꺼체크
            down();
            // 물건 올림
            addRobot();
            //내구도 0인거 체크 : cnt++
            cnt = 0;
            for(int a : arr){
                if(a==0){
                    cnt++;
                }
            }
            time++;
//            System.out.println("TIME : " + time);

//            for(int a : robot){
//                System.out.print(a + " ");
//            }
//            System.out.println();
//
//            for(int a : arr){
//                System.out.print(a + " ");
//            }
//            System.out.println();
        }

        System.out.println(time);


    }
}
