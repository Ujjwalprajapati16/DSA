import java.util.PriorityQueue;

public class Sliding_window_maximum {
    public static class Pair implements Comparable<Pair> {
        int val;
        int idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair o) {
            return o.val - this.val;
        }
    }
    public static void main(String[] args) {
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0; i<k; i++){
            pq.add(new Pair(arr[i], i));
        }
        int i = k;
        while(i<arr.length){
            System.out.print(pq.peek().val + " ");
            while(!pq.isEmpty() && pq.peek().idx < i-k+1){
                pq.remove();
            }
            pq.add(new Pair(arr[i], i));
            i++;
        }
        System.out.println(pq.peek().val);
        /*
         * Output:
         * 3 3 5 5 6 7
         */
    }
}
