# Graph
### Feature
- 인접 리스트 (Adjacency List), 인접 행렬(Adjacency Matrix)로 표현이 가능
- 부모-자식 관계 X
### term
- Vertex(정점) : 데이터, Node로도 저장이 가능함
- Edge(간선) : Vertex(정점)을 연결하는 선으로 가중치가 붙을 수 있다. link라고도 불림
- Degree(차수) : 하나의 Vertex(정점)에 연결되어있는 edge(간선)의 수
- Path(경로) : 한 노드에서 목표 노드까지 이동하는 데에 거쳐간 경로
- Cycle(사이클) : 순환구조, Cycle이 이루어진 graph는 위상정렬과 다익스트라 알고리즘을 적용 시킬 수 없다.
### types
- 무방향 그래프 (Undirected) : 간선에 방향이 없는 그래프, 구현할 때 a -> b , b -> a 둘 다 값을 넣어줘야 함
- 방향 그래프 (Directed) : 간선에 방향이 있는 그래프, 구현할 때 a -> b 와 b -> a가 다름을 유의
- 연결 그래프 (Connected) : Undirected에서 모든 vertex의 쌍에 대해 항상 경로가 존재
- 비연결 그래프 (Disconnected) : Undireced에서 특정 vertex쌍에 경로가 존재하지 않은 경우
- 순환 그래프 (Cyclic) : 사이클이 있는 그래프, (가능한 알고리즘) -> 벨만-포드
- 비순환 그래프 (Acyclic) : 사이클이 없는 그래프, (가능한 알고리즘) -> 다익스트라, 위상정렬
- 완전 그래프 (Complete) : 모든 vertex들이 연결되어 있는 그래프
- 가중치 그래프 (Weighted) : 간선에 가중치가 할당된 그래프
- 신장 트리

### MyGraphInterface에 구현한 메소드
- `void add(int from, int to)`
- `void add(int from, int to, Integer distance)`
- `Integer getDistance(int from, int to)` : from - to 사이의 가중치 값 반환
- `Map<Integer, Integer> getInDegrees()` : <vertex, 진입 차수의 수>
- `Set<Integer> getVertexes()` : vertex들을 반환
- `List<Integer> getNodes(int vertex)` : 인접한 vertex들을 리스트형태로 반환

### Adjacency Matrix vs Adjacency List
#### Adjacency Matrix
- `Integer[][] matrix` (행렬 선언)
- `Set<Integer> vertexes` (정점을 저장할 set 선언) - set은 중복 element 추가 불가
- `Map<Integer, Integer> inDegrees` (<vertex, 진입 차수의 개수>)

#### Adjacency List
- `List<List<Node>>` (Node 내부 클래스를 이용하여 리스트를 선언)
- `Set<Integer> vertexes` (정점을 저장할 set 선언) - set은 중복 element 추가 불가
- `Map<Integer, Integer> inDegrees` (<vertex, 진입 차수의 개수>)

### [Graph Algorithm](https://github.com/dali186/CS-Study/tree/main/Algorithm/Graph "graph algorithm")
