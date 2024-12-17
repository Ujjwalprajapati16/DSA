public class Hollow_rectangle {
    public static void hollow_rectangle(int totRows, int totCols) {
        for (int outLine = 1; outLine <= totRows; outLine++) {
            for (int InLine = 1; InLine <= totCols; InLine++) {
                if (outLine == 1 || outLine == totRows || InLine == 1 || InLine == totCols) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int N = 4;
        int M = 5;
        hollow_rectangle(N, M);
    }
}
