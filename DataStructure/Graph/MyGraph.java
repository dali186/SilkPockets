package DataStucture.Graph;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface MyGraph {
    void add(int from, int to);
    //distance는 가중치
    void add(int from, int to, Integer distance);
    Integer getDistance(int from, int to);
    //<Node, InDegree의 개수
    Map<Integer, Integer> getInDegrees();
    Set<Integer> getVertexes();
    List<Integer> getNodes(int vertex);

}
