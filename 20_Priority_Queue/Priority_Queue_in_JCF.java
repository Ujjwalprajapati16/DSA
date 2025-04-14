import java.util.Comparator;
import java.util.PriorityQueue;

public class Priority_Queue_in_JCF {
    public static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student o) {
            return this.rank - o.rank;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10); // O(log n)
        pq.add(20);
        pq.add(30);
        pq.add(40);
        pq.add(50);
        pq.add(25);
        pq.add(5);

        System.out.println("By default Priority in ascending order.");
        while (!pq.isEmpty()) {
            System.out.print(pq.peek() + " "); // O(1)
            pq.remove(); // O(log n)
        }

        System.out.println("\nWe have to use Comparator.reverseOrder() for change the priority to descending order.");
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());
        pq2.add(10);
        pq2.add(20);
        pq2.add(30);
        pq2.add(40);
        pq2.add(50);
        pq2.add(25);
        pq2.add(5);

        while (!pq2.isEmpty()) {
            System.out.print(pq2.peek() + " "); // O(1)
            pq2.remove(); // O(log n)
        }
        /*
         * By default Priority in ascending order.
         * 5 10 20 25 30 40 50
         * We have to use Comparator.reverseOrder() for change the priority to
         * descending order.
         * 50 40 30 25 20 10 5
         */

        System.out.println("\n Priority Queue in a class");
        PriorityQueue<Student> students = new PriorityQueue<>();
        students.add(new Student("Ujjwal", 1));
        students.add(new Student("Rahul", 2));
        students.add(new Student("Ravi", 3));
        students.add(new Student("Rohit", 4));
        students.add(new Student("Rahul", 5));
        students.add(new Student("Ravi", 6));
        students.add(new Student("Rohit", 7));

        while (!students.isEmpty()) {
            System.out.println(students.peek().name + " -> " + students.peek().rank);
            students.remove();
        }

        /*
         * Priority Queue in a class
         * Ujjwal -> 1
         * Rahul -> 2
         * Ravi -> 3
         * Rohit -> 4
         * Rahul -> 5
         * Ravi -> 6
         * Rohit -> 7
         */
    }
}
