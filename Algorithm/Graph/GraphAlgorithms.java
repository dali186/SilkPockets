package DataStucture.Graph;

import java.util.*;

public class GraphAlgorithms {

    public static List<Integer> bfs(MyGraph myGraph, int from) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(from);
        visited.add(from);

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            result.add(current);

            for (Integer n : myGraph.getNodes(current)) {
                if (!visited.contains(n)) {
                    queue.add((n));
                    visited.add(n);
                }
            }
        }
        return result;
    }

    public static List<Integer> dfs(MyGraph myGraph, int from) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        stack.add(from);
        visited.add(from);

        while (!stack.isEmpty()) {
            Integer current = stack.pop();
            result.add(current);

            for (Integer n : myGraph.getNodes(current)) {
                if (!visited.contains(n)) {
                    stack.add(n);
                    visited.add(n);
                }
            }
        }
        return result;
    }

    public static List<Integer> topologicalSortInDegree(MyGraph myGraph) {
        //간선을 카운팅하는 Map, inDegreeCounter 생성
        Map<Integer, Integer> inDegreeCounter = myGraph.getInDegrees();
        //결과를 넣는 list생성, queue 생성
        List<Integer> result = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        //그래프에 있는 모든 정점들의 간선 개수를 카운팅해서 0인 놈들을 큐에 집어넣음
        for (int v : myGraph.getVertexes()) {
            int count = inDegreeCounter.getOrDefault(v, 0);
            if (count == 0) {
                queue.offer(v);
            }
        }
        //정점을 꺼내서 연결된 간선을 제거
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
        return result;
    }

    public static List<Integer> topologicalSort(MyGraph myGraph) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        Set<Integer> vertexes = myGraph.getVertexes();
        for (Integer vertex : vertexes) {
            if (!visited.contains(vertex)) {
                //재귀 호출
                topologicalSort(myGraph, vertex, visited, stack);
            }
        }

        while (stack.size() > 0) {
            result.add(stack.pop());
        }
        return result;
    }

    private static void topologicalSort(MyGraph myGraph, int vertex, Set<Integer> visited, Stack<Integer> stack) {
        visited.add(vertex);
        List<Integer> nodes = myGraph.getNodes(vertex);
        for (Integer n : nodes) {
            if (!visited.contains(n)) {
                topologicalSort(myGraph, n, visited, stack);
            }
        }
        stack.push(vertex);
    }

    public static int dijkstraShortestPath(MyGraph myGraph, int src, int dst) {
        int size = 0;
        //vertex 중 가장 큰 번호를 size에 저장 후 배열 생성
        for (int n : myGraph.getVertexes()) {
            if (size < n) {
                size = n + 1;
            }
        }

        //distance 배열 초기화
        int[] distance = new int[size];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        //시작 노드의 distance  = 0
        distance[src] = 0;

        //<vertex, distance>
        //distance를 기준으로 하는 min heap (작은 것 부터 꺼내옴)
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });

        queue.add(new int[]{src, 0});

        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            int vertex = top[0];
            int dist = top[1];

            if (distance[vertex] < dist) continue;

            for (int node : myGraph.getNodes(vertex)) {
                if (distance[node] > distance[vertex] + myGraph.getDistance(vertex, node)) {
                    distance[node] = distance[vertex] + myGraph.getDistance(vertex, node);
                    queue.add(new int[] {node, distance[node]});
                }
            }
        }
        return distance[dst];
    }
}
