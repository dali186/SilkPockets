# Spring
__배운 내용을 복습하고 기록하는 목표로 작성되었습니다__    
몇몇 내용은 틀린 ~~개소리~~일 수도 있으나 ~~개소리~~를 올바른 내용으로 수정하는것 또한 목표입니다.

#### Spring FrameWork? Spring Boot?
- `Spring Framework` : 기업용 어플리케이션을 만드는데 사용가능한 오픈소스 프레임워크
- `Spring Boot` : 스프링 기반으로 _자주 사용되는 설정_ 으로 개발할 수 있게 해주는 _상위 프레임워크_

#### Spring Framework Runtime
![SpringFrameworkRuntime](https://github.com/dali186/SilkPockets/assets/51067466/205ba08b-6508-4d37-a35c-3db83d468ec8)
- Core(DI, IoC)
- Validation, Data binding
- Resource
- SpEL
- Null-safety

#### IoC(Inversion of Control) : 제어의 역전
- `객체의 생성`, `설정`, `초기화`, `메소드 호출`, `생명주기` 등을 프로그래머가 직접 관리하지 않고 외부 라이브러리(Spring FrameWork)가 흐름을 제어하도록 위임하는 것.
    - 프로그래머는 프레임워크가 정의한 규칙과 인터페이스를 따라 개발
- `IoC Container(Spring Container)` : 객체에 대한 생성 및 생명주기를 관리
- `ApplicationContext` : `BeanFactory`의 하위 인터페이스, 해당 애플리케이션의 구성정보를 제공하는 인터페이스
    - `ApplcationContext`에서 Bean을 등록하고 관리한다.
#### DI(Dependcy Injection) : 의존성 주입
의존성을 맺다?
- A 클래스에서 B 클래스의 객체를 사용하고 있는 경우, A 객체는 B 객체에 의존성을 맺고 있다고 표현.
- 의존성을 맺는 방법으로는 `생성자 주입`, `필드 주입`, `수정자(setter) 주입`이 있다.     
- [작성한 클래스 내에서 외부 클래스를 직접 결합 시키는게 아니라. 외부에서 객체를 생성해주고 작성한 클래스 생성 시 의존성을 주입해준다.](https://github.com/dali186/SilkPockets/blob/main/Spring/lab/DependencyInjection.java)
#### Bean
- java에서의 `Bean`
    - 데이터를 저장하기 위한 구조체.
    - `private property`와 `getter/setter`으로만 데이터를 접근
- Spring에서의 `Bean`
    - IoC Container(ApplicationContext)에 Bean으로 등록
    - 일반적으로 `서비스 계층 개체`, `리포지토리 또는 데이터 액세스 개체(DAO)와 같은 지속성 계층 개체`, `웹 컨트롤러와 같은 프레젠테이션 개체`, `JPA와 같은 인프라 개체`, `EntityManagerFactoryJMS 대기열` 등을 정의.
    - `Bean` 등록 시 필요 정보
        - `Class 경로`
        - `Bean의 이름` ([명명규칙](https://docs.spring.io/spring-framework/reference/core/beans/definition.html#beans-beanname))
        - `Scope` (Singleton / prototype / request)
            - `singleton` : 컨테이너에 단일로 생성
            - `prototype` : 작업 시 마다 Bean을 새로 생성하고 싶은 경우
            - `request` : http 요청마다 새롭게 Bean을 생성하고 싶은 경우
        - `Lifecycle Callback`
#### AOP(Aspect-Oriented Programming) : 관점 지향 프로그래밍
- `로깅`, `트랜잭션`, `인증` __같은 여러 모듈 또는 객체에서 공통으로 발생하는 기능__ 을 `OOP`로 구현하면 _중복이 발생하거나 코드가 복잡해짐._
- __핵심 로직과 위와같은 부가기능을 분리하여 모듈화하여 재사용할 수 있도록 하는 것이 목표__
- AOP 주요 용어
    - `Join point` : advice(실제 기능)이 적용할 수 있는 모든 위치. _스프링 AOP는 프록시 패턴사용하므로 joinpoint는 메소드 실행 시점_
    - `Pointcut` : joinpoint 중 실제로 advice를 적용할 대상을 선택, _Spring은 어느 메소드에 적용할 것인지 명시_
    - `Target(Obejct)` : advice의 대상
    - `Advice` : AOP에서 실제로 적용하는 기능
    - `Aspect` : 프록시 생성기가 @Aspect를 보고 advisor(advice + pointcut)로 변환해서 저장.
    - `Proxy`
        - `JDK 동적 프록시` (JDK Dynamic Proxy) - 인터페이스 기반
        - `CGLIB 프록시` (Code Generation Library) - 클래스 기반
#### Validation : 유효성 검증
- 주로 사용장 또는 서버의 요청 (http request) 내용에서 잘못된 내용이 있는 지 확인하는 단계
    - `데이터 검증`
    - `비즈니스 검증`
#### Data Binding
- 사용자나 외부 서버의 요청 데이터를 특정 도메인 객체에 저장해서 프로그램 Request에 담아주는 것
- `Converter`
#### Resource
- java.net.URL의 한계 (classpath 내부 접근, 상대경로 등)를 넘어서기 위해 스프링에서 추가 구현
- 해당 path가 파일인지 url인지 접근할 때 사용
- `Spring ResourceLoader`, (`Url`, `ClassPath`, `FileSystem`, `ServletContext`)`Resource`
#### SpEL (Spring Expression Language)
- 필요한 데이터나 설정 값을 얻어올 수 있게 하는 특별한 현태의 표현식에 가까운 간편한 언어
- @Value("#{1+1}")
#### Null Safety

<div align="right">
[#2 Annotation](https://github.com/dali186/SilkPockets/blob/main/Spring/%232_Annotation/%232_Annotation.md)
</div>