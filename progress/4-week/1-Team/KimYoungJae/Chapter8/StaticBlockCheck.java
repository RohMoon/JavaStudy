public class StaticBlockCheck {
    public static void main(String[] args) {
        StaticBlockCheck check = new StaticBlockCheck();
        check.makeStaticBlockObject();
    }
    public void makeStaticBlockObject() {
        System.out.println("Creating block1");          //1 : Creating block1 출력
        StaticBlock block1 = new StaticBlock();         //2 : StaticBlock 클래스의 static 블록들 순서대로 실행 후 생성자의 로직 실행
        /**
         * 1. *** Frist static block. ***       출력
         * 2. *** Second static block. ***      출력
         * 3. StaticBlock Constructor.          출력
         */
        System.out.println("Created block1");           //3 : Created block1 출력
        System.out.println("------------------------"); //4 : ------------------------ 출력
        System.out.println("Creating block2");          //5 : Creating block2 출력
        StaticBlock block2 = new StaticBlock();         //6 : static 블록은 실행되었기 때문에 생성자 로직만 실행("StaticBlock constructor" 출력)
        System.out.println("Created block2");           //7 : Created block2 출력
    }
}
class StaticBlock {
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

