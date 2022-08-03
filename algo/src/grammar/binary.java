package grammar;

public class binary {

    public void test(){
        long a = 3333;
        String binary = Long.toBinaryString(a);
        
        //진법변환
        long temp = Long.parseLong(binary,2);
    }
}
