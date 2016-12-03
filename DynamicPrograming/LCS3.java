import java.util.*;

public class LCS3 {

    private static int lcs3(int[] a, int[] b, int[] c) {
        //Write your code here
        int distance[][][]=new int[a.length+1][b.length+1][c.length+1];

        for(int i=0; i<a.length+1; i++)
            distance[i][0][0]=0;

        for(int j=0; j<b.length+1; j++)
            distance[0][j][0]=0;

        for(int k=0; k<c.length+1; k++)
            distance[0][0][k]=0;

        for (int i=1; i<a.length+1; i++){
            for(int j=1; j<b.length+1; j++){
                distance[i][j][0]=0;
            }
        }


        for (int i=1; i<a.length+1; i++){
            for(int j=1; j<b.length+1; j++){
                for (int k=1; k<c.length+1; k++){

                    int dii=distance[i-1][j][k]+0;
                    int idi=distance[i][j-1][k]+0;
                    int iid=distance[i][j][k-1]+0;

                    int ddi=distance[i-1][j-1][k]+0;
                    int did=distance[i-1][j][k-1]+0;
                    int idd=distance[i][j-1][k-1]+0;

                    //only matches increments the subsequence size
                    int match=distance[i-1][j-1][k-1]+1;
                    int mismatch=distance[i-1][j-1][k-1]+0;


                    int max1=Math.max(Math.max(dii, idi),iid);
                    int max2=Math.max(Math.max(ddi, did),idd);

                    // substract 1 in order to point to the current element
                    //this because the matrix added the empty element at 0 index
                    if (a[i-1]==b[j-1] && b[j-1]==c[k-1]){
                        distance[i][j][k]=Math.max(Math.max(max1, max2),match);
                    }else{
                        distance[i][j][k]=Math.max(Math.max(max1, max2),mismatch);
                    }
                }
            }
        }

        return distance[a.length][b.length][c.length];

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}

