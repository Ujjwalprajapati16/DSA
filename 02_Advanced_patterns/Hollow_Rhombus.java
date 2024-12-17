public class Hollow_Rhombus {
    public static void main(String[] args) {
        int N = 5;

        for(int i=1; i<=N; i++){
            //spaces
            for(int j=1; j<=N-i; j++){
                System.out.print(" ");
            }

            //Hollow rectangle
            for(int j=1; j<=N; j++){
                if(i==1 || i==N || j==1 || j==N){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

/*
    *****
   *   *
  *   *
 *   *
*****
 */