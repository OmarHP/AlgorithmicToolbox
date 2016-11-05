import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {

    if (n <= 1)
      return n;

    long previous=0;
    long current=1;

    for(int i=2; i<=n; i++){
        long tmp=previous;
        previous=current;
        current=previous+tmp;
    }
    return current;
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}
