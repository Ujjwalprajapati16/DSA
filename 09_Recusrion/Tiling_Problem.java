public class Tiling_Problem {
    public static int tilingProblem(int n) {
        // base case
        if (n == 0 || n == 1) {
            return 1;
        }

        // recursive call
        int verticalChoice = tilingProblem(n - 1);
        int horizontalChoice = tilingProblem(n - 2);

        return verticalChoice + horizontalChoice;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println("Total ways to tile a 2" + "x" + n + " grid is " + tilingProblem(n));

        n = 3;
        System.out.println("Total ways to tile a 2" + "x" + n + " grid is " + tilingProblem(n));

        n = 6;
        System.out.println("Total ways to tile a 2" + "x" + n + " grid is " + tilingProblem(n));

        n = 2;
        System.out.println("Total ways to tile a 2" + "x" + n + " grid is " + tilingProblem(n));
    }
}
