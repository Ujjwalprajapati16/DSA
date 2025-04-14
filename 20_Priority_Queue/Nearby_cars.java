import java.util.PriorityQueue;

public class Nearby_cars {
    public static class Point implements Comparable<Point> {
        int x;
        int y;
        int distSq;
        int idx;

        public Point(int x, int y, int idx){
            this.x = x;
            this.y = y;
            this.distSq = x * x + y * y;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point o) {
            return this.distSq - o.distSq;
        }
    }

    public static void main(String[] args) {
        // Given
        int[][] pts = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        
        for(int i=0; i<pts.length; i++){
            pq.add(new Point(pts[i][0], pts[i][1], i));
        }

        for(int i=0; i<k; i++){
            System.out.println("C"+pq.remove().idx);
        }

        /*
         * Output:
         * C0
         * C2
         */
    }
}
