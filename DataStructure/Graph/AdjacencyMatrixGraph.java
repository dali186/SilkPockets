package DataStucture.Graph;

import java.util.*;

public class AdjacencyMatrixGraph implements MyGraph {

    //행렬
    private Integer[][] matrix;
    //정점
    private Set<Integer> vertexes;
    //차수, 3번 노드를 가리키고 있는 노드가 5개일 때, inDegrees(3) = 5
    private Map<Integer, Integer> inDegrees;

    public AdjacencyMatrixGraph(int numOfVertex){
        this.vertexes = new HashSet<>();
        this.inDegrees = new HashMap<>();
        this.matrix = new Integer[numOfVertex][];
        for (int i = 0; i < numOfVertex; i++) {
            this.matrix[i] = new Integer[numOfVertex];
        }
    }

    @Override
    public void add(int from, int to) {
        //vertexes Set에 정점들을 추가 from, to
        this.vertexes.add(from);
        this.vertexes.add(to);
        //to로 향하는 정점들이 몇개인지 확인하고 하나 더 추가
        int count = this.inDegrees.getOrDefault(to, 0);
        inDegrees.put(to, count + 1);
        //인접 행렬에 가중치를 추가
        matrix[from][to] = 1;
        //무방향 그래프일 때
        matrix[to][from] = 1;
    }

    @Override
    public void add(int from, int to, Integer distance) {
        //vertexes Set에 정점들을 추가 from, to
        this.vertexes.add(from);
        this.vertexes.add(to);
        //to로 향하는 정점들이 몇개인지 확인하고 하나 더 추가
        int count = this.inDegrees.getOrDefault(to, 0);
        inDegrees.put(to, count + 1);
        //인접 행렬에 가중치를 추가
        matrix[from][to] = distance;
        //무방향 그래프일 때
        matrix[to][from] = distance;
    }

    @Override
    public Integer getDistance(int from, int to) {
        return this.matrix[from][to];
    }

    @Override
    public Map<Integer, Integer> getInDegrees() {
        return this.inDegrees;
    }

    @Override
    public Set<Integer> getVertexes() {
        return this.vertexes;
    }

    @Override
    public List<Integer> getNodes(int vertex) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < this.matrix[vertex].length; i++) {
            if (this.matrix[vertex][i] != null) {
                result.add(i);
            }
        }
        return result;
    }
}
