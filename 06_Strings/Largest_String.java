public class Largest_String {
    public static String largestString(String[] fruits){
        String largest = fruits[0];
        for(String fruit: fruits){
            if(largest.compareTo(fruit) < 0){
                largest = fruit;
            }
        }
        return largest;
    }
    public static void main(String[] args) {
        String[] fruits = {"apple", "banana", "mango", "kiwi", "orange"};
        System.out.println(largestString(fruits));
    }
}
