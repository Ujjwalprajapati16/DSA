
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Indian_coins {
    public static void main(String[] args) {
        Integer coins[] = { 2000, 500, 100, 50, 20, 10, 5, 2, 1 };

        int amount = 590;
        int count = 0; // count of coins

        Arrays.sort(coins, Comparator.reverseOrder());

        ArrayList<Integer> coinsList = new ArrayList<>();

        for (Integer coin : coins) {
            if (coin <= amount) {
                while (coin <= amount) {
                    amount -= coin;
                    coinsList.add(coin);
                    count++;
                }
            }
        }

        System.out.println("Total coins required: " + count);

        for (Integer coin : coinsList) {
            System.out.print(coin + " ");
        }
    }
}
