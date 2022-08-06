package toss;

public class sol2 {
    public int solution(int[] levels) {
        int answer = 0;
        double len = (levels.length) * 3;
        len = Math.ceil(len/4);

        if(len==levels.length){
            answer = -1;
        }
        System.out.println(levels[(int)len]);


//        if(len==0){
//            answer = levels[(levels.length) - 1];
//            System.out.println(levels[(levels.length) - 1]);
//        }else{
//            answer = levels[(levels.length) - len];
//            System.out.println(levels[(levels.length) - len]);
//        }


        return answer;
    }



    public static void main(String[] args) {
        sol2 sol = new sol2();

        int arr[] = {1,2,3,4};
        sol.solution(arr);

        int arr1[] = {1,2};
        sol.solution(arr1);

        int arr3[] = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        sol.solution(arr3);

    }
}
