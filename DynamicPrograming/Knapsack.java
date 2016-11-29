import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) { //the value of each item is equal to its weight
        //write you code here
        int values[][] = new int[w.length+1][W+1];

        for(int i=1; i<=w.length; i++){ //for each item in w
            for(int j=1; j<=W; j++ ){ // for each wi from 1 to W
                values[i][j]=values[i-1][j];
                if(w[i-1]<=j){
                    int val=values[i-1][j-w[i-1]]+w[i-1]; // we uses w[i-1] since w starts in zero index
                    if (val>values[i][j]){
                        values[i][j]=val;
                    }
                }
            }
        }

        return values[w.length][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

