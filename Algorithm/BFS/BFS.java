package DataStucture.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void bfs(int[][] graph, int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        boolean[] visited = new boolean[graph.length];

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            visited[currentNode] = true;
            System.out.print(currentNode + " ");

            for (int i = 0; i < graph[currentNode].length; i++) {
                if (graph[currentNode][i] == 1 && !visited[i]) {
                    queue.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        int [][] graph = {{0, 1, 1, 0}, {1, 0, 1, 1}, {1, 1, 0, 0}, {0, 1, 0, 0}};
        int startNode = 2;
        bfs(graph, startNode);
    }
}
