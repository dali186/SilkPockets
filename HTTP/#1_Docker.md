# HTTP
#### HTTP 완벽가이드

#### 1부. HTTP: 웹의 기초
1. HTTP
2. URL과 리소스
3. HTTP 메세지
4. 커넥션 관리

1-1.
HTTP의 신뢰성 (전송 중 파괴, 중복, 왜곡 X)

#### 미디어 타입
- MIME (Multipurpose Internet Mail Extensions, 다목적 인터넷 메일 확장)
- 웹 서버는 모든 HTTP 객체 데이터에 MIME 타입을 붙힌다
- 주 타입 / 부 타입 [primary object type / specific subtype]
    - text/html, HTML텍스트 문서
    - text/plain, plain ASCII 텍스트
    - image/jpeg, JPEG 이미지
    - image/gif, GIF 이미지
    - video/quicktime, 애플 퀵타임 동영상
    - application/vnd.ms-powerpoint, 마이크로소프트 파워포인트

__MIME로 웹 브라우저는 다룰 수 있는 객체인지 아닌지 확인함__       

#### URI(uniform resource identifier, 자원식별자)
정보 리소스를 고유하게 식별하고 위치를 지정가능       
URI에는 URL, URN 두가지가 있다       
- URL(uniform resource locator, 통합 자원 지시자)
    - 프로토콜 + 서버 + 리소스
    - http:// + www.board.com/ + /resource/3 요런식으로 구성
    - http:// 이 부분을 스킴(scheme)이라고도 부름
      
URI와 URL은 무슨 차이가 있을까?         
http://www.board.com/index (URI O, URL X)       
http://www.board.com/index.html (URI O, URL O)       
일단, URL이면 URI이다. URI가 더 큰 개념이니까.        
URI는 식별자의 개념, URL은 위치의 개념

HTTP 트랜잭션은
Request + Response로 이루어져 있다.
method (GET, POST, PUT, DELETE, HEAD)
상태코드

HTTP 트랜잭션이랑 DB의 트랜잭션은 다른개념이다        
요청과 응답으로 이루어진 웹 통신의 단위(HTTP 트랜잭션)      
ACID의 트랜잭션(DB 트랜잭션)       
에혀 아직도 갈길이 멀구만     

메세지 구조
메세지는 요청과 응답 딱 두가지 타입밖에 없다
- 시작줄 
    - 요청이라면 뭘 해야하는지
    - 응답이라면 무슨 일이 일어났는지
- 헤더
    - 쌍점 (:) 으로 key, value를 이룬다
- 본문
    - 이진 데이터를 포함할 수 있다 (이미지, 비디오, 응용 소프트웨어)

    ```
        GET /board.html HTTP/1.0
        -
        User-agent: Mozila...
        Host: www.mylocal.com
        Accept: text/html
    ```
    ```
        HTTP/1.0 200 OK
        -
        Date: Sun, o1 Oct 2023 ...
        Server: Apache/1.3.11...
        Content-length: 403
        -
        <HTML>
        <H2> response</H2>
        </HTML>
    ```
TCP       
HTTP - Layer 7, Application       
TCP - Layer 4, Transport
IP - Layer 3, Network
       
__HTTP는 메세지를 전송하기 위해 TCP를 사용하고 TCP는 연결을 유지하기 위해 IP를 사용한다.__       
무튼간에 TCP/IP가 HTTP에게 제공하는 것들은
- 오류 없는 데이터 전송
- 순서에 맞는 전달
- 조각나지 않는 데이터 스트림 (언제든 어떤 크기로든 보낼 수 있다.)
       
쓸모없는 짱구를 굴려보자면,     
IP로 호스트간의 연결 루트를 선정하고, 연결루트가 선정되면 TCP를 이용해 연결을 유지하는데      
이때 TCP는 연결 중에 소켓을 열어놓는다. 열어둔 상태에서 통신하면 요청이 섞일 수가 있다.    
그런데, HTTP는 TCP를 이용하면서도 요청 한번에 소켓을 열고 닫고, 응답 한번에 소켓을 열고 닫는다.     
왜 그러냐면 HTTP프로토콜의 특성인 Stateless, 무상태성과 비 연결성을 유지하기 위해서이다.      
확장성 때문에 무상태성과 비 연결성을 유지한다? 균형잡힌 부하때문에?       

        
버전별 변천사
HTTP/0.9      
- Only GET method
HTTP/1.0      
- 버전 번호, 헤더, 추가 method, 멀티미디어 객체 처리 업데이트
HTTP/1.0+      
- keep-alive 커넥션, 가상 호스팅 지원, 프록시 연결 업데이트
HTTP/1.1      
- 구조 교정, 성능 최적화, 잘못된 기능 제거
- 현재 사용중
HTTP/2.0     
- 구글의 SPDY 프로토콜을 기반으로 설계가 진행 중

웹의 구성요소        
프록시 : 클라이언트와 서버 사이에 위치한 HTTP 중개자        
캐시 : 많이 찾는 웹페이지를 클라이언트 가까이에 보관하는 HTTP 창고        
게이트웨이 : 다른 애플리케이션과 연결된 특별한 웹 서버        
터널 : 단순히 HTTP 통신을 전달하기만 하는 특별한 프록시        
에이전트 : 자동화된 HTTP 요청을 만드는 준지능적(semi-intelligent)클라이언트        
        
프록시?        
- 클라이언트의 모든 HTTP 요청을 받아서 서버에 전달 (대개 요청을 수정한 뒤에)
- 서버의 응답을 필터링해서 돌려준다.
- 주로 보안을 위해 사용된다
유해사이트가 차단되는 것은 프록시를 거쳐갔기 때문인가?          
        
게이트웨이?        
- 주로 HTTP 트래픽을 다른 프로토콜로 변화하기 위해 사용된다
- 스스로가 진짜 리소스를 갖고있는 서버처럼 요청을 다룬다
        
터널?        
- 두 커넥션 사이에서 raw데이터를 열어보지 않고 그대로 전달해주는 HTTP 애플리케이션


URL

`?AA=11&BB=22` 얘를 질의 문자열, 영어로 하면 QueryString
프로토콜 파라미터는 ;이후에 나오는 값임
프래그먼트?
깃 허브에 올려둔 문서를 보다보면 소제목을 클릭하면 URL이 바뀌는 것을 볼 수가 있다.
뒤에 #하고 소제목이 붙는데, 이게 프래그먼트
프래그먼트는 리소스의 특정 부분을 가리킬 수 있도록 리소스 내의 조각을 가리킴
        
절대 URL, 상대 URL - 기저 URL
