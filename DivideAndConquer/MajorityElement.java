import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }
        ;

        //write your code here
        int mid=left+(right-left)/2;
        int m1=getMajorityElement(a, left, mid);
        int m2=getMajorityElement(a,mid, right);

        int lCount=getFrequency(a, left, right, m1);
        if (lCount>(right-left)/2)
            return m1;

        int rCount=getFrequency(a, left, right, m2);
        if (rCount>(right-left)/2)
            return m2;

        return -1;
    }

    private static int getFrequency(int[]a, int left, int right, int key){
        int counter=0;
        for (int i=left; i<right; i++){
            if (a[i]==key)
                counter++;
        }
        return counter;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
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

