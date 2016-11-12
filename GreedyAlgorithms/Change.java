import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        //write your code here
        int numCoins=0;
        numCoins+=m/10;
        m=m%10;
        numCoins+=m/5;
        m=m%5;
        return numCoins+m;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

