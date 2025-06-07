import java.util.ArrayList;
import java.util.Stack;

public class Kosaraju_algorithm {
    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    private static void createGraph(ArrayList<Edge> graph) {
        graph.clear();
        graph.add(new Edge(1, 0));
        graph.add(new Edge(0, 2));
        graph.add(new Edge(1, 2));
        graph.add(new Edge(0, 3));
        graph.add(new Edge(3, 4));
    }

    private static void topSort(ArrayList<Edge> graph, int curr, boolean[] vis, Stack<Integer> st) {
        vis[curr] = true;
        for (Edge e : graph) {
            if (!vis[e.dest]) {
                topSort(graph, e.dest, vis, st);
            }
        }
        st.push(curr);
    }

    private static ArrayList<Edge> transposeGraph(ArrayList<Edge> graph) {
        ArrayList<Edge> reverse = new ArrayList<>();
        for (int i = 0; i < graph.size(); i++) {
            Edge e = graph.get(i);
            reverse.add(new Edge(e.dest, e.src));
        }
        return reverse;
    }

    private static void dfs(ArrayList<Edge> graph, int curr, boolean[] vis) {
        vis[curr] = true;
        System.out.print(curr + " ");
        for (Edge e : graph) {
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }

    public static void kosaraju(ArrayList<Edge> graph, int V) {
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                topSort(graph, i, vis, st);
            }
        }

        ArrayList<Edge> reverse = transposeGraph(graph);
        vis = new boolean[V];
        int count = 0;
        while (!st.isEmpty()) {
            int curr = st.pop();
            if (!vis[curr]) {
                count++;
                System.out.print("Component " + count + " : ");
                dfs(reverse, curr, vis);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph = new ArrayList<>();
        createGraph(graph);

        kosaraju(graph, V);

        /*
         * 
         * Component 1 : 1 0 3
         * Component 2 : 2
         * Component 3 : 4
         */
    }
}
