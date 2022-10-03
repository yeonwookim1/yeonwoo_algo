package kakaobank;

public class Sol2 {

    public int cal(String src, String dst, int[] dates){
        System.out.println("src = " + src + " dst = " + dst);
        int days = 0;
        int srcM = Integer.parseInt(src.split("/")[0]);
        int srcD = Integer.parseInt(src.split("/")[1]);

        int dstM = Integer.parseInt(dst.split("/")[0]);
        int dstD = Integer.parseInt(dst.split("/")[1]);

        //월이 같으면 날짜만 계산하도록
        if(srcM==dstM){
            days = dstD-srcD;
            return days;
        }
        //월이 다르면 월의 날짜를 계산
        for(int i=srcM+1; i<dstM; i++){
            days += dates[i-1];
        }
        days += dates[srcM-1]-srcD; //입금 된 월의 day
        days += dstD;               //출금 된 월의 day
        System.out.println("days = " + days);
        return days;
    }

    public int solution(String[] ledgers) {
        int answer = 0;
        String date[] = new String[ledgers.length];
        int rol[] = new int[ledgers.length];
        int money[] = new int[ledgers.length];

        for(int i=0; i< ledgers.length; i++){
            String str[] = ledgers[i].split(" ");
            date[i] = str[0];
            rol[i] = Integer.parseInt(str[1]);
            money[i] = Integer.parseInt(str[2]);
        }

        int dates[] = {31,28,31,30,31,30,31,31,30,31,30,31};
        for(int a : money){
            System.out.print(a + " ");
        }
        System.out.println();
        for(int i=0; i< money.length; i++){
            if(money[i] <0){
                for(int j=i-1; j>=0; j--){
                    if(money[j] == 0){
                        continue;
                    }
                    if(money[i] + money[j] <= 0) {  //더 빼야되는 경우
                        int tempDays = cal(date[j], date[i], dates);
//                        System.out.println("tempDays = " + tempDays);
                        double d = (double)tempDays / (double)365;
                        answer += money[j] * (rol[j] * 0.01) * d;
                        System.out.println("answer = " + money[j] * (rol[j] * 0.01) * d);
                        money[i] += money[j];
                        money[j] = 0;
                    } else {                        //마지막으로 빼는 경우
                        money[j] += money[i];
                        money[i] *= -1;
                        int tempDays = cal(date[j], date[i], dates);
                        double d = (double)tempDays / (double)365;
                        answer += money[i] * (rol[j] * 0.01) * d;
                        System.out.println("answer = " + money[i] * (rol[j] * 0.01) * d);
                        money[i]=0;
                    }
                }
            }
        }
        for(int i=0; i<money.length; i++){
            String dstDate = "12/31";
            if(money[i]!=0){
                int tempDays = cal(date[i],dstDate, dates);

                double d = (double)tempDays / (double)365;
                answer+=(money[i]*(rol[i]*0.01)*d);
            }
        }
        System.out.println("total answer = " + answer);
        return answer;
    }

    public static void main(String[] args) {
        String[] a = {"04/01 1 40000","05/01 5 20000","08/31 4 10000","11/11 0 -45000"};
        Sol2 sol2 = new Sol2();
        sol2.solution(a);
    }
}

/**
 *
 * def calcdays(src,dst,dates):
 *     days=0
 *     src_m=int(src.split('/')[0])
 *     src_d=int(src.split('/')[1])
 *
 *     dst_m=int(dst.split('/')[0])
 *     dst_d=int(dst.split('/')[1])
 *
 *     if src_m==dst_m:
 *         days=dst_d-src_d
 *         return days
 *
 *     for d in range(src_m+1,dst_m):
 *         days+=dates[d-1]
 *     days+=dates[src_m-1]-src_d
 *     days+=dst_d
 *     return days
 *
 * if __name__=='__main__':
 *     dates=[31,28,31,30,31,30,31,31,30,31,30,31]
 *     # ledgers=['01/01 4 50000','01/11 6 3555','02/01 0 -23555','02/25 5 5000','03/25 0 -15000','06/09 8 43951','12/30 9 99999']
 *     ledgers=['04/01 1 40000','05/01 5 20000','08/31 4 10000','11/11 0 -45000']
 *     answer=0
 *     date=[]
 *     RoI=[]
 *     money=[]
 *     for ld in ledgers:
 *         date.append(ld.split(' ')[0])
 *         RoI.append(int(ld.split(' ')[1]))
 *         money.append(int(ld.split(' ')[2]))
 *     for i in range(len(돈)):
 *         if money[i] < 0:
 *             for j in range(i-1,-1,-1):
 *                 if money[j] == 0:
 *                     continue
 *                 if money[i]+money[j] <= 0:
 *                     days=calcdays(date[j], date[i], dates)
 *                     answer+=int(money[j]*(RoI[j]*0.01)*(days/365))
 *                     money[i]+=money[j]
 *                     money[j]=0
 *                 else:
 *                     money[j]+=money[i]
 *                     money[i]*=-1
 *                     days=calcdays(date[j], date[i], dates)
 *                     answer+=int(money[i]*(RoI[j]*0.01)*(days/365))
 *                     money[i]=0
 *     for i in range(len(돈)):
 *         dstdate='12/31'
 *         if money[i]!=0:
 *             days=calcdays(date[i], dstdate, dates)
 *             answer+=int(money[i]*(RoI[i]*0.01)*(days/365))
 *     print(answer)
 */