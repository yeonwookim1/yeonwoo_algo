package grammar;

public class CallByValue {
    public int x;
    public CallByValue(int x){
        this.x = x;
    }

    static void run(CallByValue c, CallByValue c1){
        c.x = 3;
        c1 = c;
        System.out.println("c.x = " + c.x);
        System.out.println("c1.x = " + c1.x);
        c1.x = 49;
        System.out.println("System.identityHashCode(c) = " + System.identityHashCode(c));
        System.out.println("System.identityHashCode(c1) = " + System.identityHashCode(c1));
    }

    public static void main(String[] args) {
        CallByValue c = new CallByValue(1);
        CallByValue b = new CallByValue(2);
        System.out.println("System.identityHashCode(c) = " + System.identityHashCode(c));
        System.out.println("System.identityHashCode(c) = " + System.identityHashCode(b));
        run(c,b);
        System.out.println("c.x = " + c.x);
        System.out.println("b.x = " + b.x);

    }
}

