package DataStucture.Graph;

import java.util.*;

public class AdjacencyListGraph implements MyGraph{

    private List<List<Node>> graph;
    private Set<Integer> vertexes;
    private Map<Integer, Integer> inDegrees;

    public AdjacencyListGraph(int numOfVertex) {
        this.vertexes = new HashSet<>();
        this.inDegrees = new HashMap<>();
        this.graph = new ArrayList<>(numOfVertex);
        for (int i = 0; i < numOfVertex; i++) {
            this.graph.add(new ArrayList<>());
        }
    }

    @Override
    public void add(int from, int to) {
        vertexes.add(from);
        vertexes.add(to);

        int count = inDegrees.getOrDefault(to, 0);
        inDegrees.put(to, count + 1);

        List<Node> neighbors = this.graph.get(from);
        neighbors.add(new Node(from, to));
        //양방향이면 to와 from을 바꿔서 추가
    }

    @Override
    public void add(int from, int to, Integer distance) {
        vertexes.add(from);
        vertexes.add(to);

        int count = inDegrees.getOrDefault(to, 0);
        inDegrees.put(to, count + 1);

        List<Node> neighbors = this.graph.get(from);
        neighbors.add(new Node(from, to, distance));
        //양방향이면 to와 from을 바꿔서 추가
    }

    @Override
    public Integer getDistance(int from, int to) {
        for (Node node : this.graph.get(from)) {
            if (node.to.equals(to)) {
                return node.weight;
            }
        }
        return null;
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
        List<Integer> nodes = new ArrayList<>();
        for (Node node : this.graph.get(vertex)) {
            nodes.add(node.to);
        }
        return nodes;
    }

    private class Node{
        Integer from;
        Integer to;
        int weight;

        Node(int from, int to) {
            this.from = from;
            this.to = to;
            this.weight = 1;
        }

        Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
