public class Solution17 {

    //https://school.programmers.co.kr/learn/courses/30/lessons/68645
    //삼각달팽이
    public int[] solution(int n) {

        int len = 0;
        for(int i=1; i<=n; i++){
            len += i;
        }
        int arr[][] = new int[n][n];
        int[] answer = new int[len];
        int a = 3;  //방향체크
        int idx = n;    //같은 방향에 적힐 숫자 갯수
        int cnt = 0;    //같은 방향에 적힌 숫자 갯수

        int listIdx = -1;
        int col = 0;
        for(int i=1; i<=len; i++){
            if(a%3 == 0){ //아래
                listIdx++;
//                list.get(listIdx).add(i);
                arr[listIdx][col] = i;
                cnt++;
            } else if(a%3 == 1){ //오른쪽
//                list.get(listIdx).add(i);
                col++;
                arr[listIdx][col] = i;
                cnt++;
            } else{ //위
                listIdx--;
//                list.get(listIdx).add(i);
                col--;
                arr[listIdx][col] = i;
                cnt++;
            }
            if(idx == cnt){
                idx--;
                cnt = 0;
                a++;
            }
        }

        int count=0;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
//                System.out.print(arr[i][j] + " " );
                if(arr[i][j]==0){
                    continue;
                }
                answer[count] = arr[i][j];
                count++;
            }
//            System.out.println();
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("hello");
        new Solution17().solution(6);
    }
}
