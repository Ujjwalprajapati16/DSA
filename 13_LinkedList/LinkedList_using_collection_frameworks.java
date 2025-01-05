import java.util.LinkedList;
public class LinkedList_using_collection_frameworks {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.addFirst(40);

        list.addLast(50);
        list.addLast(60);  
        System.out.println(list);

        list.removeLast();
        list.removeFirst();

        System.out.println(list);
    }
}
