
import java.util.ArrayList;

public class Maximum_in_list {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        // add elements
        list.add(10);
        list.add(40);
        list.add(50);
        list.add(20);
        list.add(30);

        // find maximum
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        System.out.println(max);
    }
}
