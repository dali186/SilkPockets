# Stack
### Feature
- LIFO(Last In First Out)
- 선형 자료구조
- 삽입/삭제가 한 쪽에서만 이루어진다.
- 배열이나 LinkedList로 구현 가능 (Node 클래스를 생성해서도 구현 가능)

### MyStackInterface에 구현한 메소드
- `void push(T data)`; [데이터를 top에 삽입]
- `T pop()`; [top위치에 있는 데이터를 삭제]
- `T peek()`; [top위치에 있는 데이터를 조회]
- `int size()`;

### java.util.Stack
- extends Vector<E>
- `E push(E item)`
- `synchronized E pop()`
- `synchronized E peek()`
- `boolean empty()`
- `synchronized int search`

**Vector를 상속해서 그런지 삭제/조회에 synchronized, 동기화를 해줌**

### 시간 복잡도
- 데이터 삽입/삭제 O(1)
- 데이터 조회 O(n), 찾는 데이터가 top이라면 O(1)

### Where to use?
- 함수 호출의 임시 데이터 저장 (JVM)
- 뒤로가기, 실행취소
- 괄호 검사 [Boj9012](https://github.com/dali186/Algorithm-Study/blob/main/BaekJoon/Boj1912.java "Boj9012")
- DFS 구현 시