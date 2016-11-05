import java.util.Scanner;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        if (to <= 1)
            return to;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < from - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        long sum = current;

        for (long i = 0; i < to - from; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }

    private static long getFibonacciPartialSum(long from, long to) {
        //sum(F(0) + F(1) + ... + F(n-1) + F(n))=F(n+2) - F(1) = F(n+2) - 1
        from+=1; //from inclusive, so we substract from-1
        to+=2;


        int[] pisanoArr=new int[60];
        pisanoArr[0]=0;
        pisanoArr[1]=1;
        for (int i=2; i<60; i++){
            pisanoArr[i]=(pisanoArr[i-1]+pisanoArr[i-2])%10;
        }

        int fromIndex=(int)(from%pisanoArr.length);
        int toIndex=(int)(to%pisanoArr.length);

        int fibFrom=(pisanoArr[fromIndex]+9)%10;
        int fibTo=(pisanoArr[toIndex]+9)%10;

        return (fibTo+(10-fibFrom))%10;

    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSum(from, to));
    }
}

