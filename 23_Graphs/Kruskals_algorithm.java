import java.util.ArrayList;
import java.util.Collections;

public class Kruskals_algorithm {
    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.weight - e2.weight;
        }
    }

    public static void createGraph(ArrayList<Edge> graph){
        graph.add(new Edge(0, 1, 10));
        graph.add(new Edge(0, 2, 15));
        graph.add(new Edge(0, 3, 30));
        graph.add(new Edge(1, 3, 40));
        graph.add(new Edge(2, 3, 50));
    }

    static int par[] = new int[4];
    static int rank[] = new int[4];

    public static void init() {
        for(int i=0; i<par.length; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {
        if(par[x] == x) {
            return x;
        }
        return par[x] = find(par[x]);
    }

    public static void union(int x, int y) {
        int parX = find(x);
        int parY = find(y);

        if(parX != parY) {
            if(rank[parX] > rank[parY]) {
                par[parY] = parX;
            } else if(rank[parX] < rank[parY]) {
                par[parX] = parY;
            } else {
                par[parY] = parX;
                rank[parX]++;
            }
        }
    }

    public static void kruskalsMst(ArrayList<Edge> graph, int V){
        init();
        Collections.sort(graph);
        int mstcost = 0;
        int count = 0;

        for(int i=0; count < V-1; i++){
            Edge e = graph.get(i);
            int parX = find(e.src);
            int parY = find(e.dest);

            if(parX != parY){
                union(e.src, e.dest);
                mstcost += e.weight;
                count++;
            }
        }

        System.out.println("MST Cost: " + mstcost);
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph = new ArrayList<>();
        createGraph(graph);

        kruskalsMst(graph, V);
    }
}
