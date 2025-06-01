import java.util.ArrayList;

public class Graph {
    static class Edge {
        int src;
        int dest;
        int weight;
        
        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) { // for stroing a empty arraylist on each index
            graph[i] = new ArrayList<>();
        }

        // 0 verties
        graph[0].add(new Edge(0, 1, 5));

        // 1 vertices
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // 2 vertices
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        // 3 vertices
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        // 4 vertices
        graph[4].add(new Edge(4, 2, 2));

        // print graph
        for(int i=0; i<V; i++) {
            for(int j=0; j<graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                System.out.print("{" + e.src + ", " + e.dest + ", " + e.weight + "} ");
            }
            System.out.println();
        }
    }
}