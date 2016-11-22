import java.util.Scanner;

/**
 * Created by Omar on 22/11/2016.
 */
public class DPChange {

    //Dynamic program change
    public static int dpChange(int  money, int[] coins){
       int  minNumCoins[]=new int[money+1];
        minNumCoins[0]=0;

        for (int m=1; m<=money; m++){
            minNumCoins[m]=Integer.MAX_VALUE;
            for(int i=0; i<coins.length; i++){
                if(m>=coins[i]){
                    int numCoins=minNumCoins[m-coins[i]]+1;
                    if (numCoins<minNumCoins[m]){
                        minNumCoins[m]=numCoins;
                    }
                }
            }
        }
        return minNumCoins[money];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();  //money
        int n = scanner.nextInt(); //number of coins
        int denominations[]=new int[n];
        for (int i=0; i<denominations.length; i++) {
            denominations[i]=scanner.nextInt(); //coins
        }
        System.out.println(dpChange(m,denominations));

    }
}
