## IOC

`ApplicationContext` extends `ListalbeBeanFactory`, `HierarchicalBeanFactory`

StaticApplicationContext ac = new StaticApplicationContext;
-> 빈 컨테이너
+ POJO클래스
+ 설정 메타 정보


IOC (Inversion of Control : 제어의 역전)
IOC 컨테이너는 일반적으로 ApplicationContext를 말한다.
ApplicationContext는 ListableBeanFactory와 HirearchicalBeanFactory를 상속한다.
즉, ApplicationContext는 BeanFactory 인터페이스를 상속하고 있는 셈이다.
ApplicationContext를 인스턴스화 하면 빈 컨테이너가 생성이 된다.
IoC 컨테이너로 동작하려면 POJO클래스와 설정 메타 정보가 필요하다.
POJO (Plain Old Java Object) 클래스는 순수 자바로 된 클래스
    - 환경과 기술에 종속되지 않고 객체지향적으로 설계된 오브젝트 (테스트와 재사용 용이, 유지보수 간편)
설정 메타 정보
    - BeanDefition 인터페이스로 표현되는 순수한 추상 정보
    - 형식에 구애 받지 않고 BeanDefinitionReader가 있으면 BeanDefinition 오브젝트로 변환해준다
        - 빈 아이디 / 이름 / 별칭
        - 클래스 또는 클래스 이름
        - 스코프
        - 프로퍼티 값 또는 참조
        - 생성자 파라미터 값 또는 참조

ApplicationContext에 개발자가 정의한 POJO 클래스를 등록하고
BeanDefinition에 POJO 클래스의 메타 데이터를 정의한다.
그리고 ApplicationContext가 BeanDefinition의 정보를 참조하여 빈 객체를 생성한다.

StaticApplicationContext
GenericApplicationContext + XmlBeanDefinitionReader
= GenericApplicationContext
