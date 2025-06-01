import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class Detect_cycle_in_an_undirected_graph_using_BFS {
    static class Node {
        int current;
        int parent;

        Node(int current, int parent) {
            this.current = current;
            this.parent = parent;
        }
    }

    static boolean isCyclicBFS(List<List<Integer>> graph, int V) {
        boolean[] visited = new boolean[V];

        for (int start = 0; start < V; start++) {
            if (!visited[start]) {
                Queue<Node> queue = new LinkedList<>();
                queue.add(new Node(start, -1));
                visited[start] = true;

                while (!queue.isEmpty()) {
                    Node node = queue.poll();
                    int current = node.current;
                    int parent = node.parent;

                    for (int neighbor : graph.get(current)) {
                        if (!visited[neighbor]) {
                            visited[neighbor] = true;
                            queue.add(new Node(neighbor, current));
                        } else if (neighbor != parent) {
                            // Cycle detected
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 10;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Adding edges
        graph.get(9).add(5);
        graph.get(5).add(9);

        graph.get(5).add(2);
        graph.get(2).add(5);

        graph.get(9).add(4);
        graph.get(4).add(9);

        graph.get(4).add(5);
        graph.get(5).add(4);

        graph.get(2).add(1);
        graph.get(1).add(2);

        if (isCyclicBFS(graph, V)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
