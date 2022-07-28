import java.util.ArrayList;

public class Naver3 {
    private int[] card;
    ArrayList<Integer> list = new ArrayList<>();

    ArrayList<Integer> testList = new ArrayList<>();
    int ans = -1;
    int num;
    int cardCnt;
    private boolean isUse;

    private void dfs(int idx, int cnt, int cardCnt){
        if(cnt >= cardCnt){
            int temp = 0;
            for(int t : list){
                temp += t;
            }
            if(temp == num){
                //System.out.println(cardCnt);
                ans = cardCnt;
            }
            return;
        }

        for(int i =idx; i<card.length; i++){
            list.add(card[i]);
            dfs(i,cnt+1, cardCnt);
            list.remove(list.size()-1);
        }
    }

    public void check(int nn, int idx, int cnt){
        
        if(nn==0){
            System.out.println(cnt);
            if(cardCnt < cnt){
                cardCnt = cnt;
            }
            isUse = true;
            return;
        }
        if(idx <0 || nn <0){
            return;
        }
        for(int i=idx; i>=0; i--){
            int temp = nn/card[i];
            
            for(int j=temp; j>0; j--){
                check(nn-j*card[i], i-1, cnt+j*card[i]);
                // check(nn-j, i-1, cnt+1);
            }
        }
    }

    public int solution(int num, int[] cards) {
        int answer = 0;
        this.num = num;
        card = cards;
        cardCnt = 0;
        isUse = false;

        check(num, cards.length-1, 0);

        if(!isUse){
            return -1;
        }

        System.out.println("cardCnt : " + cardCnt);
        for(int i=0; i<=cardCnt; i++){
            dfs(0, 0, i);
            if(ans != -1){
                break;
            }
        }
        
        answer = ans;
        System.out.println("answer : " + answer);
        return answer;
    }


    public static void main(String[] args) {
        int[] cards = {1,2};
        new Naver3().solution(10000 , cards);
        
    }
}
