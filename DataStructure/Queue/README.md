# Queue
### Feature
- FIFO (First In First Out)
- 선형 자료구조
- 한 쪽에서는 삽입이 다른 한 쪽에서는 삭제가 이루어짐
### term
- Linked List, (Double) Linked List, Array, Circular, Deque로 Queue를 구현 가능
> array는 탐색시간이 오래 걸림, circular는 배열의 크기가 한정적
- `rear` / `tail` : 데이터가 마지막으로 삽입 된 위치 
- `front` / `head` : 데이터가 삭제될 위치
- `rear`위치에 데이터를 **삽입** = enqueue / `front`위치에 데이터를 **삭제** = dequeue

### MyQueueInterface에 구현한 메소드
- `void offer(T data)`, `void enqueue(T data)` [데이터를 rear에 삽입, enqueue]
- `T poll()`, `T dequeue` [front의 있는 데이터를 삭제, dequeue]
- `T peek()` [front의 있는 데이터를 조회]
- `int size()`
- `void clear()`
- `boolean isEmpty()`


### java.util.Queue
- extends Collection<E>
- `boolean add(E e)`
- `boolean offer(E e)`
- `E remove()`
- `E poll()`
- `E element()`
- `E peek()`

> _stack과는 다르게 삽입 시 제너릭 타입인 E로 반환이 아니라 boolean으로 참 거짓을 반환해줌_ 
>> Queue<Integer> queue = new LinkedList<>(); 일 때,
>> queue.add(null) -> null을 반환, queue.offer(null) -> NullPointerException을 반환

### 시간 복잡도
- 데이터 삽입/삭제 O(1)
- 데이터 조회 O(n), 찾는 데이터가 front라면 O(1)

### Where to use?
- 줄 세우기
- 운영체제의 스케쥴링
- 입/출력의 버퍼
- 캐시 구현
- [BFS 구현 시](https://github.com/dali186/CS-Study/blob/main/Algorithm/BFS/BFS_Queue.java "BFS_Queue")