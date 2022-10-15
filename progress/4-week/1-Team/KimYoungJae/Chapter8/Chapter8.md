# 8장 참조 자료형에 대해서 더 자세히 알아봅시다

### 참조 자료형
- ```Reference Type```
- 기본 자료형을 제외한 나머지 타입
- ```new```를 이용해야만 초기화 가능
- 유일한 예외 참조 자료형은 ```String``` 클래스
- ```String``` 클래스만이 ```new```를 사용하지 않고 초기화 가능
- 역시 ```String```을 제외하고는 ```+```를 사용 불가
- ex)
```java
String a = "123";
a += "456";
==========
결과 : a = "123456"
```

> ### 참고1) 기본 자료형
> 1. byte
> 2. short
> 3. int
> 4. long
> 5. float
> 6. double
> 7. char
> 8. boolean
 
### 기본 생성자가 없이 매개 변수가 있는 생성자를 만들 경우
```java
public class ReferenceDefault {
    public static void main(String[] args) {
        ReferenceDefault reference = new ReferenceDefault();
    }
}
```
- 현재 위의 코드에서는 ```ReferenceDefault()``` 생성자는 존재하지 않는다.
- 하지만 컴파일 시 에러가 나지 않는데, 그 이유는 매개 변수가 없는 기본 생성자의 경우 다른 생성자가 없을 경우 기본으로 컴파일 할 때 만들어지기 때문이다.
- 그런데 다음과 같이 매개 변수가 있는 클래스를 만들 경우
```java
public class ReferenceString {
    public ReferenceString(String arg) {
        //...생략    
    }
    public static void main(String[] args) {
        ReferenceString reference = new ReferenceString();  //매개 변수가 없는 기본 생성자
    }
}
```
- 위의 클래스가 있는 파일을 컴파일 할 경우, ```actual and formal argument lists differ in length```라는 에러가 뜨면서 컴파일이 되지 않는다.
- 이런 오류가 발생하는 이유는, 기본 생성자는 다른 생성자가 있을 경우 만들어지지 않는데, 위의 코드에서는 매개 변수를 이용한 생성자가 존재하기 때문에 매개 변수가 없는 기본 생성자가 자동으로 생성되지 않아 오류가 발생하는 것이다.
- 위의 코드를 에러 없이 컴파일 하려면 다음과 같이 간단하게 해결할 수 있다.
```java
public class ReferenceString {
    public ReferenceString() {} //기본 생성자 만들기
    public ReferenceString(String arg) {}
    public static void main(String[] args) {
        ReferenceString reference = new ReferenceString();
    }
}
```
- 위와 같이 기본 생성자를 직접 만들어주면 해결이 가능하다.
- 또는, 기본 생성자를 사용하지 않고 매개 변수가 있는 생성자만 사용하는 방법도 있다.
```java
public class ReferenceString {
    public ReferenceString(String arg) {}
    public static void main(String[] args) {
        ReferenceString reference = new ReferenceString("매개 변수가 있는 생성자");
    }
}
```
- 위와 같이 코드를 작성하여도 컴파일 시 에러가 발생하지 않는다.

### 생성자
- 메소드와 생성자는 선언 방식이 비슷하다. 다만, 차이점은 선언부에 리턴 타입이 없고 생성자의 이름은 무조건 클래스 이름과 동일하여야 한다.
```java
public class Constructors {
    public Constructors() {}    //생성자 : 클래스와 이름이 같아야 한다, 리턴타입은 없다.
    public void method() {}     //메소드 : 클래스와 이름이 달라도 된다, 리턴타입은 필수
}
```
- 일반적으로, 생성자와 메소드의 작성 순서는 상관 없으나 보통 생성자는 메소드 위에 존재하는 것이 추 후 코드를 분석할 때 보기 좋다.
- 가독성 좋은 코드 작성 순서 : ```인스턴스 변수``` \-> ```생성자``` \-> ```메소드``` 
```java
public class ReferenceString {
    String instanceVariable;        //인스턴스 변수
    public ReferenceString() {}     //생성자
    public String getString() {}    //메소드
}
```

### 생성자의 최대 개수
- 생성자의 개수는 제한이 없다.
- 1개를 만들든, 100여개를 만들든 개수는 상관이 없으며 필요한 만큼 만들면 되고, ```참조 자료형```에서 생성자가 존재하지 않을 수는 없다.(생성자가 해당 클래스에 작성 안 되어 있을 경우 자동으로 기본 생성자가 생성된다.)

### DTO
- ```Data Transfer Object```
- 자바 패턴 중에서는 ```DTO```라는 것이 있다.
- 해당 패턴은 어떤 속성을 갖는 클래스로 그 속성들을 다른 서버에 데이터를 전송하기 위해 사용된다.
- 비슷한 개념으로 ```VO(Value Object)```가 있으며, ```DTO```와 형태는 동일하나, ```VO```는 데이터를 담아두기 위한 목적으로 사용된다.
- ```DTO```와 ```VO```를 구분 안 하는 회사도 많지만, 우리는 차이점을 알고 사용하자.> ### 참고
- ```DTO```
  - 다른 서버로 데이터를 전송하기 위한 클래스
  - 로직을 갖지 않고, ```getter/setter```만 갖는다.
- ```VO``` 
  - 데이터를 저장하기 위해서만 사용하며, 다른 서버로 전송은 삼가한다. 
  - 로직을 포함할 수 있으며, 객체의 불변성을 보장해야 한다. 

> ### 참고2) 불변성이란?
> - ```immutable```
> - 값이 할당되고 변하지 않는 것을 의미
> - ex) ```String immutable = "a";```이라고 값을 할당했을 경우, 변수 ```immutable```의 값은 ```"a"```에서 변하면 안 된다.
> - 불변성을 보장해야 하는 이유는 ```VO``` 객체를 생성한 메소드가 아닌 다른 메소드에서 해당 객체의 값을 변경하는 경우, 나중에 코드를 분석할 때 잘못 된 분석을 할 수 있고, 실제 사용시에도 원인 불명의 에러가 발생할 수 있다.
> - 즉, 불변성을 보장할 경우, 개발자가 흐름을 파악할 때 용이하고, 추 후 코드 변경을 할 때에도 신경써야하는 포인트가 줄어들어 편리하다.
> - ```그런데 로직이 포함되어 있으면, 값은 변할 수 있는 것 아닌가요?```
>   - 보통, ```equals()```와 ```hashCode()```를 오버라이딩하여 두 개의 ```VO```가 같은 것을 비교하는 로직을 많이 넣습니다.
>   - 기본적으로 불변이나, 어쩔 수 없이 변경해야 하는 값이 있을 경우 해당 행위를 메소드에 명시해서 사용합니다.
>   - ex) ```public void changePassword(String password) {this.password = password}```(세터와 동일하나 행위를 명시하여 어떤 동작인지 코드만 보고 바로 알 수 있게 한다.)
 
### DTO 예시
```java
public class MemberDto {
    public Stirng name;
    public String phone;
    public String email;
    public MemeberDto() {
        //name, phone, email 변수에 아무 값도 할당 되지 않음
    }
    public MemberDto(String name) {
        this.name = name;
        //MemberDto의 name 변수에만 매개 변수로 받은 name 값을 할당
    }
    public MemeberDto(String name, String phone) {
        this.name = name;
        this.phone = phone;
        //MembeterDto의 name, phone 변수에 매개 변수로 받은 name, phone 변수 값을 할당 
    }
    public MemeberDto(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        //MemeberDto의 name, phone, email 변수에 매개 변수로 받은 name, phone, email 변수 값을 할당
    }  
}
```
- 위와 같이 생성자는 하나가 아닌 여러개를 만들 수 있다.
- 그러나, 생성자가 너무 많을 경우 관리가 힘들어지므로 꼭 필요한 것만 만드는 것이 좋다.
- 생성자를 만드는 방법에는 정답이 없다. 다만 개발자가 어떤 생성자가 필요한지 꼭 생각해서 만들어야 하고, 구현한 생성자를 사용할 때에는 어떤 것이 해당 클래스에 가장 적합한지를 선택하는 것이 중요하다.

### ```this```
- 자바의 예약어 중 하나
- 해당 예약어가 존재하는 클래스를 의미한다.
- 인스턴스 변수와 매개 변수의 변수명이 같아도 구분할 수 있게 하기 위해 사용된다.
- 위의 DTO 예시처럼 사용하면 된다.

### ```overloading```
- 생성자도 매개변수가 다르면 생성자명은 동일한 것처럼 메소드도, 매개 변수가 다를시 메소드명은 같게 사용할 수 있다.
- 이처럼 메소드명은 같으나 매개 변수가 다르게 하는 것을 ```오버로딩```이라고 한다.
- ex)
```java
public class ReferenceOverloading {
    public static void main(String[] args) {
        ReferenceOverloading reference = new ReferenceOverloading();
    }
    public void print(int data) {}
    public void print(String data) {}
    public void print(int intData, String stringData) {}
    public void print(String stringData, int intData) {}
}
```
- 위의 예시와 같이, 매개 변수의 종류 또는 순서가 다르면 같은 이름을 가졌지만, 서로 다른 메소드로 취급한다.
- ```오버로딩```을 사용하는 이유로는 ```같은 기능을 하지만, 매개 변수의 타입만 다를 경우``` 해당 타입마다 메소드명을 다르게 해도 상관은 없지만, 해당 타입에 맞춰서 메소드명을 다르게 작성할 경우 같은 기능이지만 추가로 분석해야하며, 또 한 번에 파악하기 어렵기 때문에 사용한다고 생각하면 된다.

## 메소드

### 메소드가 종료되는 조건
1. 메소드의 모든 문장이 실행되었을 때
```java
public void method1() {
        //로직1
        //로직2
        //로직3
        //로직 끝 메소드 종료
}
```
2. return 문장에 도달했을 때
```java
public void method2() {
    //로직1
    //로직2
    //로직3
    return; //메소드 종료
    //이 이후 로직들은 실행되지 않음
    //로직4
    //로직5
}
```
3. 예외가 발생했을 때
```java
public void mehtod3() {
    //로직1    
    //로직2    
    //로직3
    throw new Exception(..생략);  //메소드 종료    
    //이 이후 로직들은 실행되지 않음
    //로직4    
    //로직5    
}
```

### 메소드 반환 타입
- 모든 반환 타입은 한가지로만 지정할 수 있다.
- 모든 기본 자료형 또는 참조 자료형 중 하나로 리턴 가능하다.
- 만약 ```void```를 제외한 리턴 타입을 가진 메소드에서 리턴 타입을 적지 않을 경우 컴파일 시 에러가 발생한다.
```java
public String method() {
    //return "";    //해당 코드처럼 리턴을 해주지 않을 경우 컴파일 시 에러 발생!  
}
```

### ```return```
- 자바의 예약어 중 하나
- 해당 예약어가 사용되면 이후 로직은 모두 실행이 되지 않는다.
- 해당 예약어 이후에 로직이 있을 경우 컴파일 시 에러가 발생한다.
- 예외 사항으로는 서로 다른 블럭에 있을 경우는 에러가 발생하지 않는다.
- ex)
```java
public int ifConditionIntReturn() {
    int retrunInt=0;
    if(returnInt==0) {
        return ++returnInt;
    } else {
        return --returnInt;    
    }
}
```
- 위와 같이 ```if``` 블럭과 ```else```블럭은 서로 다른 블럭에 위치해있기 때문에 여러 개의 ```return```이 존재할 수 있다.
- 다만, 같은 블럭내에서는 역시 ```return``` 이후에 코드는 작성 시 ```컴파일 에러```가 발생한다.
- ex)
```java
public int ifConditionIntReturn() {
    int returnInt=0;
    if(returnInt==0) {
        return ++returnInt;
        ++returnInt;    //이렇게 return 예약어 이후에 코드 작성 시 에러 발생
    }
    //... 이하 생략
}
```
- 리턴 타입이 ```void```일 경우, ```return``` 예약어만 사용 가능하며, 해당 예약어 사용 시 해당 메소드 수행은 종료가 된다.
```java
public void wantToStopInTheMiddle() {
    //코드 생략
    if(1 == 1) return;  //해당 라인에서 메소드 종료 즉, 이후 로직 실행 X
    //코드 생략 
}
```

### ```static``` 메소드와 일반 메소드의 차이
- ```static``` 예약어를 붙일 경우 객체를 생성하지 않고도 해당 객체에 존재하는 메소드가 사용 가능하다.
- ex)
```java
public class ReferenceStatic {
    public static void main(String[] args) {
        ReferenceStatic.staticMethod();
        //static을 사용하지 않으면 new ReferenceStatic().staticMethod();
        //위와 같은 방법으로 사용해야한다.
  }
  public static void staticMethod() {
        System.out.println("This is a staticMethod.");
  }
}
```
- 위와 같은 방법이 매우 편리해보여 모든 메소드에 ```static``` 예약어를 붙이면 좋을텐데, 왜 하지 않았을까? 라는 의문을 가질 수 있지만 ```static```메소드는 클래스 변수만 사용할 수 있다는 단점이 있으며, 클래스 변수 및 ```static``` 메소드는 자바 프로그램이 종료 될 때까지 사용하지 않는 경우에도 메모리에 남아 있어서, 메모리 낭비를 일으킬 수 있기 때문에 최소한으로 사용하는 것이 좋다.
- ex) ```static``` 메소드에서 사용하는 클래스 변수
```java
public class ReferenceStatic {
    String name = "Min";    //인스턴스 변수
    static String staticName = "staticMin"; //클래스 변수
    public static void staticMethodCallVariable() {
      /*
       * non-static variable name cannot be referenced from a static context
       * 위와 같은 에러 발생
       * static 메소드에서 외부 변수 사용시 반드시 클래스 변수를 사용해야한다.
       */
      System.out.println(name);         //에러 발생
      System.out.println(staticName);   //정상 작동   
    }
}
```

> ### 참고3) 무분별한 ```static``` 사용 자제
> - ```static```은 위의 예제와 같이 ```new``` 예약어를 사용하지 않고도 해당 객체의 메소드를 사용할 수 있어서 매우 편리하다.
> - 그러나 이런 편리함 속에는 단점들이 있는데, 그것을 알아보자.
>   1. 자바 프로그램이 종료 될 떄까지 메모리 차지
>      - 해당 단점은 자주 사용하지 않는 메소드 및 변수도 계속 자바의 메모리를 차지하고 있어, 서버 컴퓨터가 과부하를 일으킬 수 있는 문제점이 있다. 
>   2. 모든 객체에서 하나의 값만 바라봄
>      - 해당 단점은 데이터의 흐름을 이해하지 못 하면 가장 큰 문제가 생길 수 있으며 아래와 같은 예시를 통해 어떤 문제점인지 알아보자.
>      ```java
>      public class ReferenceStaticVariable {
>           static String name;
>           public ReferenceStaticVariable() {}
>           public ReferenceStaticVariable(String name) {
>               this.name = name;
>           }
>           public void checkName() {
>               ReferenceStaticVariable reference1 = new ReferenceStaticVariable("Sangmin");
>               System.out.println(reference1.name);    //예상 출력 : "Sangmin"
>               ReferenceStaticVariable reference2 = new ReferenceStaticVariable("Sungchoon");
>               System.out.println(reference1.name);    //예상 출력 : "Sangmin"
>           }
>      }
>      ```
>      - 위의 코드를 보면, 새롭게 생성한 ```reference1```의 ```name``` 값을 출력하면 둘 다 "Sangmin"이 나올 것으로 예상 할 수 있다.
>      - 왜냐하면, ```reference1``` 객체를 생성하고 그 후 해당 객체의 ```name```을 건드리지 않았기 때문이다.
>      - 그러나 결과를 보면, 첫 번째는 "Sangmin"이 출력되지만, 두 번째는 "Sungchoon"이 출력된다.
>      - 이러한 결과가 나온 이유는, 클래스 변수로 지정되면, 그 변수는 모든 객체에서 동일하게 참조하게 되고 다른 객체에서 해당 변수를 변경 시 해당 변수를 변경한 객체 외의 모든 객체에서도 해당 변수의 값이 변경되기 때문이다.
> - 위와 같은 이유 때문에, ```static``` 예약어는 꼭 필요한 장소에만 쓰는 것이 좋다.
 
### ```static``` 블록
- ```static``` 예약어를 사용하는 방법은 한 가지 더 있다. 이를 ```static``` 블록이라고 한다.
- 객체는 여러 개를 생성하지만, 첫 번째 생성할 때만 실행하고 싶은 코드가 있을 경우 사용된다.
- 사용법은 아래와 같다.
```java
static {
    //실행할 코드
}
```
- ```static``` 블록의 특성
  1. 객체가 생성 되기 전 한 번만 호출되고, 그 이후에는 호출이 불가
  2. 클래스 내에 선언되어 있어야 하며, 메소드 내에서는 선언 불가

### ```static``` 블록 예제
```java
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
public class StaticBlockCheck {
  public static void main(String[] args) {
    StaticBlockCheck check = new StaticBlockCheck();
    check.makeStaticBlockObject();
  }
  public void makeStaticBlockObject() {
    //1 : Creating block1 출력
    System.out.println("Creating block1");
    //2 : StaticBlock 클래스의 static 블록들 순서대로 실행 후 생성자의 로직 실행
    /**
     * 1. *** Frist static block. ***       출력
     * 2. *** Second static block. ***      출력
     * 3. StaticBlock Constructor.          출력
     */
    StaticBlock block1 = new StaticBlock();
    //3 : Created block1 출력
    System.out.println("Created block1");
    //4 : ------------------------ 출력
    System.out.println("------------------------");
    //5 : Creating block2 출력
    System.out.println("Creating block2");
    //6 : static 블록은 실행되었기 때문에 생성자 로직만 실행("StaticBlock constructor" 출력)
    StaticBlock block2 = new StaticBlock();
    //7 : Created block2 출력
    System.out.println("Created block2");           
  }
}
```

### ```Pass by value```
- 매개 변수로 값을 전달하는 것
- 현재 실행중인 메소드에서 생성한 매개 변수의 값을 다른 메소드로 값을 전달하는 것을 의미한다.
- 우리가 흔히 사용하고 있으며, 아래 예제를 보면 바로 이해가 갈 것이다.
```java
public class PassByValue {
    public void method1() {
        int a = 10;
        String b = "b";
        System.out.println("before PassByValue");
        System.out.println("a = " + a); //10 출력
        System.out.println("b = " + b); //"b" 출력
      
        //PassByValue 실행
        method2(a, b);
      
        System.out.println("after PassByValue");
        System.out.println("a = " + a); //10 출력
        System.out.println("b = " + b); //"b" 출력
    }
    public void method2(int a, String b) {
        a = 20;
        b = "z";
        System.out.println("in PassByValue");
        System.out.println("a = " + a); //20 출력
        System.out.println("b = " + b); //"z" 출력
    }
}
```
- 위와 같이 새로 생성한 인스턴스 변수의 값을 전달하는 것을 ```Pass By Value```라고 하고, 전달 받은 메소드에서 해당 변수를 변경하여도 기존의 값은 변하지 않는 것을 확인 할 수 있다.
- 기본 자료형을 전달할 경우에만 ```Pass By Value```로 작동한다.

### ```Pass by reference```
- 매개 변수로 전달 된 값을 변경 시 기존의 값도 변경 되는 것
- 현재 실행중인 메소드에서 생성한 객체의 참조값을 다른 메소드로 전달하고 해당 메소드에서 해당 객체를 변경 시 값이 변경 되는 것을 의미한다.
- ex) ```Pass By Reference```
```java
public class PassByReference {
    class MemberDto {
        public String name;
        public MemberDto(String name) {
            this.name = name;
        }
    }
    public void method1() {
        MemberDto member = new MemberDto("Sangmin");
        System.out.println("before PassByReference");
        System.out.println("member.name = " + member.name); //"Sangmin" 출력
        
        method2(member);
        
        System.out.println("after PassByReference");
        System.out.println("member.name = " + member.name); //"Sungchoon" 출력
    }
    public void method2(MemberDto member) {
        member.name = "SungChoon";
        System.out.println("in PassByReference");
        System.out.println("member.name = " + member.name); //"Sungchoon" 출력
    }
}
```
- 위와 같이 ```method1```에서 ```member```의 ```name```을 초기에 할당하고 변경하지 않았지만, 해당 참조값이 이동한 ```method2```에서 ```member```의 ```name``` 값을 변경하였기 때문에 같은 주소값을 가진 ```method1```의 ```member```의 값도 변경되어 "Sangmin"이 아닌 "Sungchoon"이 출력되는 것이다.
- 모든 참조 자료형에서는 ```Pass By Reference```로 작동한다.

> ### 참고4) ```String```도 참조 자료형인데 왜 변하지 않나요?
> - ```String``` 클래스는 매우 특이한 클래스로서 
>   ```
>   String a = "1";
>   a = "2";
>   ```
>  - 위와 같은 예시에서 ```a = "2";```같은 경우 ```a```의 주소값은 그대로이고 값만 변하는 것이 아닌 ```new String("2");```와 같이 새로운 객체를 생성하여 할당하고 주소값이 달라지기 때문에 ```Pass By Reference```가 되지 않는 것이다.
> - 다른 참조 자료형들도 동일하다. 이처럼 ```new``` 예약어를 사용하여, 객체를 새로 생성 후 주소값을 새로 할당할 경우 ```Pass By Reference```는 작동하지 않는다. 
 
### 매개변수를 지정하는 특이한 방법
- 만약 매개변수의 개수가 일정하지 않고 가변적이라면 메소드를 어떻게 만들어야 할까?
- ex1) 배열로 매개변수를 받는 방법
```java
public class MethodVarargs {
    public void calculateNumbersWithArray(int[] numbers) {
        //매개변수 예시 : calculateNumbersWithArray(new int[]{1,2,3,4,5})
    }
}
```
- 위의 ex1과 같은 방식으로 매개 변수를 받을 수 있다. 하지만 이렇게 할 경우 매개변수로 전달해야 하는 값들은 모두 배열로 만든 후 넘겨주어야 하는 단점이 있다.
- 이를 보완하기 위해 자바에서는 임의 개수의 매개 변수를 넘겨줄 수 있는 방법을 제공한다.
- ex2) 가변인자
```java
public class MethodVarargs {
    public void calculateNumber(int... numbers) {
        //매개변수 예시 : calculateNumber(1,2,3,4,5);
    }
}
```
- 위의 ex2와 같은 방식으로 작성할 경우 작성한 매개 변수들이 배열을 사용한것처럼 들어간다.
- 사용하는 방식은 타입 뒤에 ```...```을 공백 없이 적어주면 사용 가능하다.
- 주의해야할 점
  1. 하나의 메소드에서는 한 번만 사용 가능
  2. 여러 매개 변수가 있을 경우, 가장 마지막에 선언해야 한다.
    - ex1) 올바른 사용법  
      ```java
      public void arbitrary(String message, int... numbers) {}
      ```
    - ex2) 잘못된 사용법
      ```java
      public void arbitrary(int... numbers, String message) {}
      ```
      - 이와 같이 작성하면 컴파일 시 에러가 발생한다.