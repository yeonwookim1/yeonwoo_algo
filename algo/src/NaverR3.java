import java.util.ArrayList;

public class NaverR3 {
    private int[] card;
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<ArrayList> dpList = new ArrayList<>();

    ArrayList<Integer> testList = new ArrayList<>();
    static int ans = 999999;
    int num;
    private boolean isUse;


    public void check(int nn, int idx, int cnt){
        if(nn==0){
            //System.out.println("cnt : " + cnt);
            if(ans > cnt){
                ans = cnt;
            }
            isUse = true;
            return;
        }
        if(idx <0 || nn <0){
            return;
        }
        for(int i=idx; i>=0; i--){
            int useCardNum = nn/card[i];
            for(int j=useCardNum; j>0; j--){
                int minusNum = j*card[i];
                //System.out.println(minusNum);
                check(nn - minusNum, i-1, cnt + j);
            }
        }
    }

    public int solution(int num, int[] cards) {
        int answer = 0;
        this.num = num;
        card = cards;

        isUse = false;

        
        makeList(dpList, 1);

        check(num, cards.length-1, 0);

        if(!isUse){
            return -1;
        }

        answer = ans;
        System.out.println("answer : " + answer);
        return answer;
    }

    public void makeList(ArrayList e, int n){
        if(n==card.length){
            return;
        }
        ArrayList<ArrayList> tt = new ArrayList<>();
        e.add(tt);
        makeList(e, n+1);
    }

    public static void main(String[] args) {

        long preTime = System.currentTimeMillis();
        int[] cards = {5,7,9};
        new NaverR3().solution(42 , cards);
        System.out.println(System.currentTimeMillis() - preTime);
        
    }
}
