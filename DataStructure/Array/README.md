# Array
### Feature
- 선형 자료구조
- 데이터의 조회가 용이 (인덱스를 사용 - Random Access)
- 데이터의 삽입/삭제 시 데이터의 이동이 많다.

### MyListInterface에 구현한 메소드
- `void add(T t)` 
- `void insert(int index, T t)`
- `void clear()`
- `boolean delete(T t)`
- `boolean deleteByIndex(int index)`
- `T get(int index)`
- `int indexOf(T t)`
- `boolean isEmpty()`
- `boolean contains(T t)`
- `int size()`

> 확실히 인덱스를 이용한 메소드들이 많다...

### java.util.ArrayList
- extends AbstractList<E>, Implements List<E>, RandomAccess, Cloneable, java.io.Serializable
> 왜 ArrayList는 AbstractList를 상속하면서 List<E>를 구현할까?
>> List<E>를 구현하는 자료구조들의 일반화 + AbstractList를 상속하여 인덱스로 접근하는 메소드의 재정의를 이유로 생각한다.

> The add operation runs in amortized constant time, that is, adding n elements requires O(n) time.
> no such object exists, the list should be "wrapped" using the Collections.synchronizedList method.

- `void trimToSize()` [배열의 크기를 size로 자르기]
- `void ensureCapacity(int minCapacity)` [배열의 크기를 제한]
- `private Object[] grow(int minCapacity)` [배열의 크기를 늘리는 내부 함수]
- `int size()`
- `boolean isEmpty()`
- `boolean contains(Object o)` -> `int indexOf(Object o)` -> `int indexOfRange(Object o, int start, int end)`
- `int lastIndexOf(Object o)` -> `int lastIndexOfRange(Object o, int start, int end)`
- `Object clone()`
- `add` , `get` , `set`, `remove` ...
> ~~필요할 때 찾아보자~~

### java.util.LinkedList<E>
- extends AbstractSequentialList<E> implements List<E>, Deque<E>, Clonable, java.io.Serializable
> Deque, List를 구현하는 게 특징인 것 같다.
> Deque를 구현해서 그런지 first, last를 이용한 메소드들이 많다
> ~~이것도 필요할 떄 찾아보기...~~

### 시간 복잡도
- 데이터 삽입/삭제 O(n) - 해당되는 인덱스까지 찾아가야 함
- 데이터 조회 O(1)

### Where to use?
- list, stack, queue 자료구조 구현 시 사용
- sort 알고리즘에 사용
- 2차원 배열