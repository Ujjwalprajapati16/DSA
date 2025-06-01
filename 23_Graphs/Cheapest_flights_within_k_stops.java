import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Cheapest_flights_within_k_stops {
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

    public static void createGraph(ArrayList<Edge>[] graph, int[][] flights) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int weight = flights[i][2];
            graph[src].add(new Edge(src, dest, weight));
        }
    }

    static class Info {
        int v;
        int cost;
        int stops;

        public Info(int v, int cost, int stops) {
            this.v = v;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public static int cheapestFlights(int n, int[][] flights, int src, int dest, int k) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph(graph, flights);

        int dist[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr.stops > k) {
                continue;
            }
            for (Edge e : graph[curr.v]) {
                int u = e.src;
                int v = e.dest;
                int w = e.weight;
                if (dist[u] != Integer.MAX_VALUE && curr.cost + w < dist[v] && curr.stops <= k) {
                    dist[v] = dist[u] + w;
                    q.add(new Info(v, curr.cost + w, curr.stops + 1));
                }
            }
        }

        return dist[dest] != Integer.MAX_VALUE ? dist[dest] : -1;
    }

    public static void main(String[] args) {
        int n = 4;
        int flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        int src = 0;
        int dest = 3;
        int k = 1;
        int ans = cheapestFlights(n, flights, src, dest, k);
        System.out.println(ans);
    }
}
