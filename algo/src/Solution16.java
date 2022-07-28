public class Solution16 {

    /**
     * 코딩테스트 연습 월간 코드 챌린지 시즌3 n^2 배열 자르기
     * https://programmers.co.kr/learn/courses/30/lessons/87390
     */
    public int[] solution(int n, long left, long right) {
        int len = (int) (right - left +1);
        int[] answer = new int[len];

        int cnt = 0;
        for(long i=left; i<=right; i++){
            long r = i/n; //index가 가리키는 x좌표
            long c = i%n; //index가 가리키는 y좌표
            // list.add(Math.max(r,c)+1);
            answer[cnt]=(int)(Math.max(r,c)+1);
            cnt++;
            
        }

        return answer;
    }

    public static void main(String[] args) {
        int n= 4;
        int left=7;
        int right=14;
        new Solution16().solution(n, left, right);
    }
}
