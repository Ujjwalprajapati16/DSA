import java.util.ArrayList;

public class Bridge_in_a_Graphs {
    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    private static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 3));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        // graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        // graph[4].add(new Edge(4, 5));

        // graph[5].add(new Edge(5, 3));
        // graph[5].add(new Edge(5, 4));
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, int par, int dt[], int low[], boolean vis[], int timer){
        vis[curr] = true;
        dt[curr] = low[curr] = ++timer;
        for(Edge e : graph[curr]){
            if(e.dest == par){
                continue;
            }
            if(!vis[e.dest]){
                dfs(graph, e.dest, curr, dt, low, vis, timer);
                low[curr] = Math.min(low[curr], low[e.dest]);
                if(low[e.dest] > dt[curr]){
                    System.out.println("Bridge : " + curr + " - " + e.dest);
                }
            }else{
                low[curr] = Math.min(low[curr], dt[e.dest]);
            }
        }
    }

    public static void tarjenBridge(ArrayList<Edge> graph[], int V){
        int dt[] = new int[V];
        int low[] = new int[V];
        boolean vis[] = new boolean[V];
        int timer = 0;
        for(int i=0; i<V; i++){
            if(!vis[i]){
                dfs(graph, i, -1, dt, low, vis, timer);
            }
        }
    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        tarjenBridge(graph, V); // Bridge : 0 - 3, Bridge : 3 - 4
    }
}
