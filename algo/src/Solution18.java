import java.util.ArrayList;
import java.util.List;

//https://school.programmers.co.kr/learn/courses/30/lessons/64061
//크레인 인형뽑기
public class Solution18 {

    private int[][] map;

    public int getDoll(int idx){
        for(int i=0; i<map.length; i++){
            if(map[i][idx-1] != 0){
                int temp = map[i][idx-1];
                map[i][idx-1] = 0;
                return temp;
            }
        }
        return 0;
    }
    public int solution(int[][] board, int[] moves) {
        //어피치 - 초록 - 네오 - 네오 - 초록 - 무지 - 0 - 어피치
        List<Integer> list = new ArrayList<>();

        int answer = 0;
        map = board;
        for(int i=0; i<moves.length; i++){

            int num = getDoll(moves[i]);
            if(num == 0){
                continue;
            }
            System.out.println("num = " + num);
            boolean isRemove = false;
            if(list.size()>0){
                if(list.get(list.size()-1).equals(num)){
                    list.remove(list.size()-1);
                    answer+=2;
                    isRemove = true;
                }
            }
            if(!isRemove){
                list.add(num);
            }
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        int arr[][] = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int move[] = {1,5,3,5,1,2,1,4};
        new Solution18().solution(arr,move);
    }

}
