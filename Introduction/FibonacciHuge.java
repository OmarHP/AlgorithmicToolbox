import java.util.ArrayList;
import java.util.Scanner;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }

    private static long getFibonacciHuge(long n, long m) {
        if (n <= 1)
            return n;


        ArrayList<Long> pisanoArr=new ArrayList<Long>();
            pisanoArr.add(0L); //previous
            pisanoArr.add(1L); //current
        int i=2;
        while(true){
            pisanoArr.add((pisanoArr.get(i-1)+pisanoArr.get(i-2))%m);

            i++;
        
            // check if sequence is found
            if (pisanoArr.get(i-2) == 0 && pisanoArr.get(i-1) == 1) {
                break;
            }
        }


        int index=(int)(n%(pisanoArr.size()-2));
        return pisanoArr.get(index);



    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHuge(n, m));
    }
}

