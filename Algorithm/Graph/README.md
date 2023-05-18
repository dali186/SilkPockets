# Graph Algorithm
### BFS
- 목표 : vertex의 탐색 순서
1. 변수 선언
    + List<E> result : 결과를 저장할 리스트 선언
    + Set<E> visited : 방문 여부를 저장할 Set 선언 (set은 중복이 안되기 때문) , boolean으로도 가능
    + Queue<E> queue : 다음 방문 vertex를 찾기 위한 queue 선언
2. queue와 visited에 현재 vertex를 삽입
3. (queue가 빌 때까지 반복) 
    1. queue에서 vertex를 뽑아서 결과에 추가
    2. (반복) 현재 vertex와 인접해있는 vertex를 찾아서 방문한 적이 없으면 queue와 visited에 추가
### DFS
- 목표 : vertex의 탐색 순서
1. 변수 선언
    + List<E> result : 결과를 저장할 리스트 선언
    + Set<E> visited : 방문 여부를 저장할 Set 선언 (set은 중복이 안되기 때문) , boolean으로도 가능
    + Stack<E> stack : 다음 방문 vertex를 찾기 위한 stack 선언
2. stack와 visited에 현재 vertex를 삽입
3. (stack이 빌 때까지 반복) 
    1. stack에서 vertex를 뽑아서 결과에 추가
    2. (반복) 현재 vertex와 인접해있는 vertex를 찾아서 방문한 적이 없으면 stack와 visited에 추가
### 위상정렬 (Topological Sort)
#### Queue를 이용한 위상정렬 구현
- idea (비순환 방향 그래프에서 사용, 진입 차수)
    1. 그래프의 있는 vertex의 간선 개수를 카운트 (inDegrees)
    2. queue에 간선 개수가 0인(진입 차수가 0인) vertex를 삽입 (시작점이 될 수 있음)
    3. queue에서 vertex를 꺼내 연결된 간선을 제거
    4. 제거된 vertex 중 indegree가 0인 vertex를 queue에 삽입
    5. 큐가 빌 때까지 반복
- 목표 : 순서가 있는 vertex의 순서 찾기
1. 변수 선언
    + 진입 차수를 카운팅 하는 Map<E, Integer> inDegrees
    + 결과를 저장할 리스트 List<E> result
    + 순서를 찾을 Queue<E> queue
2. 그래프에 있는 vertex들 중 진입차수가 0인 vertex를 찾아서 queue에 삽입
    ```
    int count = inDegrees.getOrDefault(vertex, 0);
    if(count == 0) queue.offer(vertex);
    ```
3. queue에서 정점을 꺼내서 진입차수를 하나 뺀다. (인접했던 간선을 제거하는 과정)
    ```
    while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            //연결된 간선을 제거할 떄 원래 데이터를 건들지 않고 구현
            for (int ns : myGraph.getNodes(node)) {
                if (inDegreeCounter.containsKey(ns)) {
                    int count = inDegreeCounter.get(ns);
                    if (count - 1 == 0) {
                        queue.offer(ns);
                    }
                    inDegreeCounter.put(ns, count - 1);
                }
            }
        }
    ```
4. 3번 과정에서 진입차수가 0이된 vertex를 queue에 삽입
5. queue가 빌 때까지 3,4번을 반복
#### Stack을 이용한 위상정렬 구현
- idea 
    - dfs를 이용
    - root를 stack에 넣지 않고, vertex들을 역순으로 삽입, 마지막에 root를 삽입
### 다익스트라 (Dijkstra)
- 목표 : 시작 노드부터 목표 노드까지 연결되어 있는 노드들을 탐색하여 최단 거리를 찾음
    - 시작 노드를 기준으로 모든 노드까지의 최단거리를 표로 만든다고 생각하면 됨
1. vertex의 개수를 길이로 가진 distance 배열을 생성 -> 시작 노드로 부터 해당 vertex의 값을 저장하기 위한 배열
    - `int distance[] = new int[graph.length + 1];`
2. distance 배열을 infinite로 초기화
3. 시작 노드의 distance를 0 으로 초기화
4. distance를 기준으로 하는 minHeap선언
    - `PriorityQueue<int[]> queue = new PriorityQueue((a,b) -> {return a[1] - b[1];});
    - <vertex, distance>
5. queue에 시작점을 추가
6. (큐가 빌 때 까지 반복)
    1. 큐에 있는 노드의 vertex와 distance를 뽑아서
    2. distance가 가지고 있는 값보다 distance가 크면 continue (원래 가지고 있는 값보다 크면 최소가 아니기 때문에 업데이트를 해주지 않음)
    3. 인접 노드들을 찾아서 (반복)
        1. 인접 노드의 값 > 현재 노드 값 + (인접 - 현재)의 가중치 이면, 최소값을 업데이트 해주고
        2. queue에 삽입