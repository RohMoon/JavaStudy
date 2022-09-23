class Calculator {
    //아직 int 외의 자료타입은 배우지 않았기 때문에, int로만 작성한다.
    //실행 방법
    //1. 터미널에서 java 파일명.java 입력, 해당 파일명으로 실행 시, 명령어는 : java Book-Example.java
    //2. 클래스 파일로 변환 후 실행
    //2-1. javac Book-Example.java
    //  - 해당 명령어를 치면 해당 파일 안의 class 명으로 클래스 파일이 생성 된다.
    //  - 해당 파일의 클래스 명은 Calculator이므로 생성되는 파일 명은 Calculator.class
    //2-2. java Calculator
    //  - 클래스 파일은 확장자를 빼고 파일 이름만 입력한다.
    public static void main(String[] args) {
        System.out.println(new Calculator().add(5, 2));
        System.out.println(new Calculator().subtract(5, 2));
        System.out.println(new Calculator().multiply(5, 2));
        System.out.println(new Calculator().divide(5, 2));
    }
    public int add(int num1, int num2) {
        int result;
        result = num1 + num2;
        return result;
    }
    public int subtract(int num1, int num2) {
        int result;
        result = num1 - num2;
        return result;
    }
    public int multiply(int num1, int num2) {
        int result;
        result = num1 * num2;
        return result;
    }
    public int divide(int num1, int num2) {
        int result;
        result = num1 / num2;
        return result;
    }
}