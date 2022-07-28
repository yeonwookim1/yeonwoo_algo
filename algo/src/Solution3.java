public class Solution3 {
    

    //https://programmers.co.kr/learn/courses/30/lessons/42842
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for(int i=1; i<= yellow; i++){
            if(yellow%i != 0){
                continue;
            } 
            
            int row = i;
            int col = yellow/i;
            if(brown*yellow - (row*col) == brown){
                System.out.println(row);
                System.out.println(col);
                int a = brown/yellow;
                answer[0] = row+a;
                answer[1] = col+a;
                break;
            }
        }


        return answer;

    }
    // public int[] solution(int brown, int yellow) {
    //     int[] answer = new int[2];

    //     int ans = brown + yellow;
    //     int x= 2;
    //     //최소 1줄이상 싸기 위해선 8의 배수로 필요함
    //     for(int cnt=8; cnt<=brown; cnt=8*x){
    //         int width = cnt/8;
    //         //col이 최소 3이되어야 감쌀 수 있음
    //         for(int i=3; i<ans; i++){
    //             int col = i;
    //             int row = ans/col;
    
    //             if(row < col){
    //                 continue;
    //             }
    //             if((row-(width*2))*(col-(width*2)) == yellow){
    //                 answer[0] = row;
    //                 answer[1] = col;
    //                 break;
    //             }
    //         }
    //         if(answer[0] != 0 && answer[1] != 0){
    //             break;
    //         }
    //         x++;
    //     }
    //     return answer;
    // }

    // 1줄이 갈색으로 둘러싸져잇음
    // public int[] solution(int brown, int yellow) {
    //     int[] answer = new int[2];

    //     int ans = brown + yellow;
    //     //col이 최소 3이되어야 감쌀 수 있음
    //     for(int i=3; i<ans; i++){
    //         int col = i;
    //         int row = ans/col;

    //         if(row < col){
    //             continue;
    //         }
    //         if((row-2)*(col-2) == yellow){
    //             answer[0] = row;
    //             answer[1] = col;
    //             break;
    //         }
            
    //     }



    //     return answer;
    // }

    public static void main(String[] args) {
        
        Solution3 s3 = new Solution3();
        s3.solution(10, 2);
        
    }
}
