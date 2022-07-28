import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static ArrayList<Integer> sumList = new ArrayList<Integer>();

    
    public static void main(String[] args) throws Exception {

        Solution s1 = new Solution();
        Solution s2 = new Solution();
        Solution s3 = s1;


        int arr[] = {6,10,2};
        int commands[][] = {{2,5,3},{4,4,1},{1,7,3}};

        String tt[] = new String[arr.length];

        for(int i=0; i<arr.length; i++){
            tt[i] = Integer.toString(arr[i]);
        }

        Arrays.sort(tt, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                return (b+a).compareTo(a+b);
            }
        });

        String answer = "";

        if(tt[0].equals("0")){
            answer = "0";
        } else{
            for(String s: tt) answer += s;
        }
        

        

    }
}

// //프로그래머스 땅따먹기 dp
// int lenX;
// int lenY;

// public int findMax(int x,int y, int z){
//     if(x>=y){
//         if(x>=z){
//             return x;
//         }else{
//             return z;
//         }
//     } else{
//         if(y>=z){
//             return y;
//         } else{
//             return z;
//         }
//     }
// }

// public void solution(int land[][]) {
//     lenX = land.length;
//     lenY = 4;

//     for (int i = 0; i < lenX-1; i++) {

//         land[i + 1][0] += findMax(land[i][1], land[i][2], land[i][3]);
//         land[i + 1][1] += findMax(land[i][0], land[i][2], land[i][3]);
//         land[i + 1][2] += findMax(land[i][1], land[i][0], land[i][3]);
//         land[i + 1][3] += findMax(land[i][1], land[i][2], land[i][0]);

//     }
// }

 // //2017 팁스타운 짝지어 제거하기

    // public Stack<Character> stk;

    // Solution(){
    //     stk = new Stack<>();
    // }
    // public boolean checkStack(){
    //     System.out.println("======================");
    //     boolean type = false;
    //     // Queue<Character> q = new LinkedList<Character>();
    //     ArrayList<Character> q = new ArrayList<Character>();
    //     while(!stk.empty()){
    //         Character temp = stk.pop();
    //         System.out.println("temp : " + temp);
    //         if(stk.size()>=1){
    //             System.out.println("stk.peek() : " + stk.peek());
    //             if(temp.equals(stk.peek())){
    //               System.out.println("stk.pop() : ");
    //                 type = true;
    //                 stk.pop();
    //             } else {
    //                 System.out.println("q.add temp  : " + temp);
                    
    //                 if (q.size() > 0 && q.get(q.size()-1) == temp) {
    //                     q.remove(q.size()-1);
    //                 } else {
    //                     q.add(temp);
    //                 }
    //             }
    //         } else {
    //             if(q.size()-1>0 && q.get(q.size()-1) == temp){
    //                 q.remove(q.size()-1);
    //             }else{
    //                 q.add(temp);
    //             }
    //         }


    //     }

    //     // System.out.println(q.size());
        
    //     for(int i=0; i<q.size(); i++){
    //         stk.add(q.get(i));
    //     }
        
    //     return type;
    // }
    // public int solution(String s) {
    //     int answer = 1;
        
    //     for(int i=0; i<s.length(); i++){
    //         stk.push(s.charAt(i));
    //     }
    //     while(true){
    //         if(!checkStack()){
    //             break;
    //         }
    //     }

    //     if(!stk.empty()){
    //         answer = 0;
    //     }
    //     //System.out.println(answer);
    //     // for(int i=1; i<s.length(); i++){
    //     //     String temp = s.substring(i, i+1);
    //     //     if(tempStr.equalsIgnoreCase(temp)){
    //     //         //System.out.println("s : " + s + "  i :" + i);

    //     //         if(i==1){
    //     //             s = s.substring(i+1);
    //     //             //System.out.println("SSS" + s);
    //     //         }else{
    //     //             s = s.substring(0, i-1) + s.substring(i+1);
    //     //         }
                
    //     //         if(s.length()==0){
    //     //             answer =1;
    //     //             break;
    //     //         }

    //     //         if(i-2 <0){
    //     //             tempStr = s.substring(0, 1);
    //     //             i=0;
    //     //         }else{
    //     //             //처음부터가 아닌 뒤에 2개로
    //     //             tempStr = s.substring(i-2,i-1);
    //     //             i = i-2;
    //     //         }
                
    //     //     } else{
    //     //         saveStr += tempStr;
    //     //         tempStr = temp;
    //     //     }
    //     // }
    //     System.out.println(answer);
    //     return answer;
    // }

//깊이/너비 우선 탐색(DFS/BFS) 타겟 넘버
// public ArrayList<Integer> arr = new ArrayList<Integer>();
    // public int ans;
    // public int solTarget;
    // App(){
    //     ans = 0;
    // }
    // public int getAns() {
    //     return ans;
    // }

    // public void setAns() {
    //     this.ans++;
    // }

    // public void dfs(int idx, int[] numbers, int sum, int cnt) {
    //     if(cnt == numbers.length){
    //         if(sum == solTarget){
    //             // for(int i=0; i<arr.size(); i++){
    //             //     System.out.print( " " + arr.get(i));
    //             // }
    //             // System.out.println();
    //             setAns();
    //         }
    //         return;
    //     }
    //     for(int i=idx; i<numbers.length; i++){
    //         sum = sum + numbers[i];
    //         arr.add(numbers[i]);
    //         dfs(i+1,numbers,sum, cnt+1);
    //         arr.remove(arr.size()-1);
    //         sum = sum - numbers[i];

    //         sum = sum - numbers[i];
    //         arr.add(numbers[i]*-1);
    //         dfs(i+1,numbers,sum, cnt+1);
    //         arr.remove(arr.size()-1);
    //         sum = sum + numbers[i];

    //     }
    //     return;
    // }

    // public int solution(int[] numbers, int target) {
    //     int answer = 0;
    //     solTarget = target;
    //     dfs(0,numbers,0, 0);
    //     // System.out.println(getAns());
    //     return answer;
    // }

    //2017 카카오코드 예선 카카오프렌즈 컬러링북
    // public int[][] arr;
    // public int[] dx = {-1,0,1,0};
    // public int[] dy = {0,1,0,-1};
    // public int m,n;
    // public class Point{
    //     public int x;
    //     public int y;
    //     Point(int x, int y){
    //         this.x= x;
    //         this.y = y;
    //     }
    // }
    // public int bfs(int x, int y, int color, int[][] picture){
    //     int cnt = 1;
    //     Queue<Point> q = new LinkedList<Point>();
    //     q.add(new Point(x,y));
    //     System.out.println(x +" " +y);
    //     arr[x][y] = 1;

    //     while(!q.isEmpty()){
    //         Point p = q.poll();
    //         int ox = p.x;
    //         int oy = p.y;
    //         int xx = 0;
    //         int yy = 0;
    //         for(int i=0; i<4; i++){
    //             xx = ox +dx[i];
    //             yy = oy +dy[i];
    //             if(xx <0 || yy <0 || xx>=m || yy>=n){
    //                 continue;
    //             }

    //             if(arr[xx][yy]==0 && picture[xx][yy]==color){
    //                 cnt++;
    //                 arr[xx][yy] =1;
    //                 q.add(new Point(xx,yy));
    //             }
    //         }
    //     }
    //     return cnt;
    // }
    // public int[] solution(int m, int n, int[][] picture) {
    //     this.m = m;
    //     this.n = n;
    //     arr = new int[m][n];
    //     int numberOfArea = 0;
    //     int maxSizeOfOneArea = 0;

    //     for(int i=0; i<m; i++){
    //         for(int j=0; j<n; j++){
    //             if(picture[i][j] != 0 && arr[i][j] == 0){
    //                 int temp = bfs(i,j,picture[i][j],picture);
    //                 if( temp>maxSizeOfOneArea){
    //                     maxSizeOfOneArea = temp;
    //                 }
    //                 numberOfArea++;
    //             }
    //         }
    //     }


    //     int[] answer = new int[2];
    //     answer[0] = numberOfArea;
    //     answer[1] = maxSizeOfOneArea;
    //     return answer;
    // }