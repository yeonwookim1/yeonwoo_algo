package grammar;

public class binary {

    public void test(){
        long a = 3333;
        String binary = Long.toBinaryString(a);
        System.out.println(binary);
        //진법변환
        long temp = Long.parseLong(binary,2);
        System.out.println(temp);
    }

    public static void main(String[] args) {
        new binary().test();
    }
}
