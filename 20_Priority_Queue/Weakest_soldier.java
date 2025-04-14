import java.util.PriorityQueue;

public class Weakest_soldier {
    public static class Row implements Comparable<Row> {
        int soldiers;
        int idx;

        public Row(int soldiers, int idx) {
            this.soldiers = soldiers;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row o) {
            if (this.soldiers == o.soldiers) {
                return this.idx - o.idx;
            }

            return this.soldiers - o.soldiers;
        }
    }

    public static void main(String[] args) {
        int[][] rows = { { 1, 0, 0, 0 },
                { 1, 1, 1, 1 },
                { 1, 0, 0, 0 },
                { 1, 0, 0, 0 } };

        int k = 2;

        PriorityQueue<Row> pq = new PriorityQueue<>();
        for (int i = 0; i < rows.length; i++) {
            int soldiers = 0;
            for (int j = 0; j < rows[i].length; j++) {
                if (rows[i][j] == 1)
                    soldiers++;
            }
            pq.add(new Row(soldiers, i));
        }

        for (int i = 0; i < k; i++) {
            System.out.println("Row" + pq.remove().idx);
        }

        /*
         * Output:
         * Row0
         * Row2
         */
    }
}
