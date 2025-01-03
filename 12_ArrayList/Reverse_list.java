
import java.util.ArrayList;

public class Reverse_list {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        // add elements
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        // reverse list
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
    }
}
