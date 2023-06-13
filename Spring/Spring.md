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
    - 일반적으로 `서비스 계층 개체`, `리포지토리 또는 데이터 액세스 개체(DAO)와 같은 지속성 계층 개체`, `웹 컨트롤러와 같은 프레젠테이션 개체`, `JPA와 같은 인프라 개체`, `EntityManagerFactoryJMS 대기열` 등을 정의합니다.
    - `@Component`어노테이션으로 빈을 등록할 수 있다.(상속 받은 어노테이션도 가능)
    - `Bean` 등록 시 필요 정보
        - Class 경로
        - Bean의 이름 ([명명규칙](https://docs.spring.io/spring-framework/reference/core/beans/definition.html#beans-beanname))
        - Scope (Singleton / prototype / request)
        - Lifecycle Callback
#### AOP
