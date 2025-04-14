import java.util.PriorityQueue;

public class Connect_N_ropes {
    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 4, 6};

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i : arr){
            pq.add(i);
        }

        int cost = 0;
        while(pq.size() > 1){
            int firstMin = pq.remove();
            int secondMin = pq.remove();
            cost += firstMin + secondMin;
            pq.add(firstMin + secondMin);
        }

        System.out.println("Minimum cost: " + cost); // 41
    }
}
