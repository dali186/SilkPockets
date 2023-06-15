# SpringPre
스프링 동작과정 이해하기 위해 필요한 사전 지식

`HTML` : 정적인 데이터     
`CGI (Common Gateway Interface)` : 동적인 페이지를 보여주기 위한 언어 (웹 서버 - 외부 프로그램 간 통신)     
- HTTP 요청마다 프로세스를 생성 -> 서버 메모리를 많이 차지함
- 언어와 플랫폼에 독립적         
`servlet` : 자바 기반으로 동적인 웹 페이지를 생성, 클라이언트의 요청을 처리
- `CGI`와 다르게 쓰레드 단위로 동작, 멀티 쓰레드
- HTTP 요청을 처리하는 서비스
![tc](https://github.com/dali186/SilkPockets/assets/51067466/37724127-0bf4-4843-af7e-e3005bf6d4fb)
1. 클라이언트의 HTTP 요청이 WAS로 전달, WAS는 클라이언트와의 통신을 담당하는 웹 서버(예: Apache HTTP Server, NGINX)로부터 요청을 받음
2. Servlet Container(서블릿 컨테이너)는 요청과 응답에 대한 정보를 담고있는 HttpServletRequest와 HttpServletResponse 객체를 생성, 그리고 ServletContainer는 요청에 해당하는 Servlet을 탐색
    - Servlet이 이미 로드되어 있고 매핑 정보가 존재한다면 해당 Servlet을 찾음
    - Servlet이 로드되어 있지 않다면 Servlet 인스턴스를 생성하고 초기화
3. Servlet Container는 새로운 쓰레드(Thread)를 생성하여 해당 Servlet을 실행, 이 쓰레드는 클라이언트의 요청을 처리하고, 필요한 비즈니스 로직을 수행
4. 요청 처리 후, Servlet Container는 처리 결과를 WAS의 웹 서버로 전달
5. WAS는 HttpServletRequest와 HttpServletResponse 객체를 삭제

----------
### Reflection
클래스의 정보를 분석하거나, 클래스의 인스턴스를 생성하거나, 메소드를 호출하거나, 필드의 값을 가져오거나, 설정하는 등의 작업      
- 런타임 시에 동적으로 클래스를 로드해야 하는 경우
- 클래스의 구조, 메소드, 필드 등에 대한 정보를 가져와서 분석해야 하는 경우
- 클래스의 인스턴스를 생성하거나 메서드를 호출하거나 필드의 값을 변경해야 하는 경우
- ex) findUri
       
### ComponentScan
__스프링 어플리케이션 실행 시, Bean으로 등록한 클래스들을 스캔하는 것__      
`@Component`로 지정한 대상을 스캔할 수 있다.
        
### DispatcherServlet 
서버에 요청이 들어오면(HTTP protocol) 가장 먼저 받아 적절한 컨트롤러에게 넘겨주는 컨트롤러, __요청을 컨트롤러를 찾아서 위임하고, 처리된 결과를 받아오는 기능 수행__
- `요청 분배` : 클라이언트의 요청을 분석하여 애플리케이션 내의 적절한 핸들러로 요청을 전달
    - Handler Mapping 
    - Handler Adapter
- `뷰 선택 및 랜더링` : 핸들러의 실행 결과로 생성된 데이터를 바탕으로 적절한 뷰를 선택하고 렌더링
    - model and view     
          
`@RequestMapping`
- `distpatcher`가 `controller`에 `@RequestMapping`이 붙어있는 모든 메소드를 찾아서 URI를 비교하고, `동일하면 호출`
`@ResponseBody`
- responsebody가 붙어있으면 return되는 값을 그대로 응답 (`MessageConverter` 호출)
- return 값이 String이면 그대로 응답, Object형이면 json으로 변환
    - 본래는 view를 탐색(`ViewResolver` 호출)

#### MessageConverter
HTTP 요청과 응답의 메시지를 변환하는 역할을 담당하는 컴포넌트
`MappingJackson2HttpMessageConverter` : JSON 형식의 데이터를 객체로 변환하거나, 객체를 JSON으로 변환

#### ViewResolver
- 클라이언트 요청의 결과를 보여줄 View를 찾아주는 역할을 수행하는 컴포넌트 
- HTTP 응답의 결과를 생성하는 뷰를 결정하고, 해당 뷰를 렌더링하여 클라이언트에게 전달
- `View 결정` : 사용할 뷰 결정 (`Thymeleaf`, `mustache`, `freemaker`, `jsp` 등)
- `뷰 랜더링` : 위의 템플릿 엔진을 사용하여 동적으로 데이터를 채움