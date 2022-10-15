public class StaticBlock {
    static int data = 1;
    public StaticBlock() {
        System.out.println("StaticBlock Constructor.");
    }
    static {
        System.out.println("*** First static block. ***");
        data = 3; //static 블록에는 클래스 변수만 넣을 수 있다.
    }
    static {
        System.out.println("*** Second static block. ***");
        data = 5;
    }
    public static int getData() {
        return data;
    }
}