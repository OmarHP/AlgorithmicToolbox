import java.util.Scanner;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }


    private static long getFibonacciSum(long n) {
        //sum(F0 + F1 + ... + Fn-1 + Fn)=Fn+2 - 1
        n+=2;

        int[] pisanoArr=new int[60]; 
        pisanoArr[0]=0;
        pisanoArr[1]=1;
        for (int i=2; i<60; i++){
            pisanoArr[i]=(pisanoArr[i-1]+pisanoArr[i-2])%10;
        }

        int index=(int)(n%pisanoArr.length);
        return (pisanoArr[index]+9)%10; //Equals to substract 1

        
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSum(n);
        System.out.println(s);
    }
}

