import java.util.*;

public class Inversions {

    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;
        if (right <= left + 1) {
            return numberOfInversions;
        }
        int ave = (left + right) / 2;
        numberOfInversions += getNumberOfInversions(a, b, left, ave);
        numberOfInversions += getNumberOfInversions(a, b, ave, right);
        //write your code here
        numberOfInversions+=merge(a, b, left, ave, right);
        return numberOfInversions;
    }

    public static long merge(int a[], int b[], int left, int ave, int right){
        int i=left, k=left;
        int j=ave;
        long counter=0;
        while(i<ave && j<right){
            if(a[i]<=a[j]){
                b[k]=a[i];
                k++;
                i++;
            }else{
                b[k]=a[j];
                j++;
                k++;
                counter+=ave-i;
            }
        }

        while(i<ave){
            b[k]=a[i];
            i++;
            k++;
        }

        while(j<right){
            b[k]=a[j];
            j++;
            k++;
        }

        for(int q=left; q<right; q++){
            a[q]=b[q];
        }

        return counter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, b, 0, a.length));
    }
}

