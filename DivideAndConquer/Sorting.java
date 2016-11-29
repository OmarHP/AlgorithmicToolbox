import java.io.*;
import java.util.*;

public class Sorting {
    private static Random random = new Random();

    private static int[] partition3(int[] a, int l, int r) {
      //write your code here
        int x=a[l];
        int j=l;
        int k=l;
        for (int i=l+1; i<=r; i++){
            if(a[i]<x){
                j++;
                int t=a[i];
                a[i]=a[j];
                a[j]=t;
            }else if(a[i]==x){
                k++;
                j++;
                int t=a[i];

                a[i]=a[j];
                a[j]=a[k];
                a[k]=t;
            }
        }

        int aux=Math.min(k+1-l, j-k); //number of changes
        for (int i=0; i<aux; i++){
            int t=a[l+i];
            a[l+i]=a[j-i];
            a[j-i]=t;
        }
        int m1 = j-k+l;
        int m2 = j;
        int[] m = {m1, m2};
        return m;
    }

    private static int partition2(int[] a, int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[l];
        a[l] = a[j];
        a[j] = t;
        return j;
    }

    private static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        //use partition3
        int m[] = partition3(a, l, r);
        randomizedQuickSort(a, l, m[0] - 1);
        randomizedQuickSort(a, m[1]+ 1, r);
    }

//    Using partition 2
    private static void randomizedQuickSort2(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        //use partition3
        int m = partition2(a, l, r);
        randomizedQuickSort2(a, l, m - 1);
        randomizedQuickSort2(a, m+ 1, r);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

//Stress test
//        Random random=new Random(0);
//        while(true){
//            int n= random.nextInt(3)+2;
//            int array[]=new int[n];
//            int array1[]=new int[n];
//            int array2[]=new int[n];
//            for(int i=0; i<n; i++){
//                int r=random.nextInt(10);
//                array[i]=r;
//                array1[i]=r;
//                array2[i]=r;
//
//            }
//
//            randomizedQuickSort(array1, 0, n-1);
//            randomizedQuickSort2(array2,0,n-1);
//            if(!Arrays.equals(array1,array2)){
//                System.out.println("false");
//                for (int i=0; i<n; i++){
//                    System.out.print(array[i]+" ");
//                }
//                System.out.println("\noutput:");
//                for (int i=0; i<n; i++){
//                    System.out.print(array1[i]+" ");
//                }
//                break;
//            }
//            System.out.println("true");
//        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

