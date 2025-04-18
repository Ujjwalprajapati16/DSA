import java.util.TreeMap;

public class TM {
    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("India", 500);
        map.put("China", 100);
        map.put("US", 100);
        map.put("UK", 100);
        map.put("Nepal", 100);
        map.put("China", 200);
        System.out.println(map); // {China=200, India=500, Nepal=100, UK=100, US=100}
    }
}
