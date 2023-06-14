public class DependencyInjection {

    class A1 {

    }

    class B1 {
        // B 객체는 A 객체와 의존성을 맺고있다.
        // 강하게 결합되어 있고 클래스 간 관계가 맺어짐
        // 좋은 코드가 아님
        private A1 a;

        public B1() {
            this.a = new A1();
        }
    }


    // 의존성 주입(DI), 이 스프링 프레임워크가 실행해줌
    // 1. 인터페이스 C 생성
    interface C {

    }
    // 2. A 클래스에 C 구현 (내가 작성하는 코드)
    class A2 implements C {

    }
    // 3. Bean을 등록하는 과정, new로 인스턴스화
    class Container {

        void B2() {
            // bean 생성
            A2 a = new A2();
            // B에 의존성 주입
            B2 b = new B2(a);
        }
    }

    // B 클래스에 C(A)를 넣어서 초기화(내가 작성하는 코드)
    class B2 {
        private C c;

        public B2(C c) {
            this.c = c;
        }
    }


}
