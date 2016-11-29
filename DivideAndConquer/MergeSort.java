import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Omar on 28/11/2016.
 */
public class MergeSort {

    public static int[] mergeSort(int a[]){
        if (a.length==1)
            return a;
        int m=a.length/2;
        int b[]=mergeSort(Arrays.copyOfRange(a,0,m));
        int c[]=mergeSort(Arrays.copyOfRange(a,m,a.length));

        return merge(b,c);
    }

    private static int[] merge(int a[], int b[]){
        int d[]=new int[a.length+b.length];
        int i=0, j=0, k=0;
        while(j<a.length || k<b.length){
            if(j>=a.length)
                d[i++]=b[k++];
            else if(k>=b.length)
                d[i++]=a[j++];
            else{
                if (a[j]<b[k])
                    d[i++]=a[j++];
                else
                    d[i++]=b[k++];
            }
        }

        return d;
    }

    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int a[]=new int[n];
        for(int i=0; i<n; i++)
            a[i]=scanner.nextInt();

        a=mergeSort(a);

        for (int i=0; i<n; i++)
            System.out.print(a[i]+" ");

    }
}
