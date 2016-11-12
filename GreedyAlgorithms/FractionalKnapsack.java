import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        //we sort the items by its value per unit
        double items[][]=new double[values.length][3];
        for (int i=0; i<values.length; i++){
            items[i][0]=(double)values[i]/weights[i];
            items[i][1]=(double)values[i];
            items[i][2]=(double)weights[i];
        }

        Arrays.sort(items, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                return Double.compare(o1[0], o2[0]);
            }
        });



        int index=items.length-1;
        while(capacity>0 && index>=0){
            double[] item=items[index];
            if (capacity>=item[2]){
                capacity-=item[2];
                value+=item[1];
            }else{

                value+= capacity*item[0];
                capacity=0;
            }
            index--;
        }

        return (double)Math.round(value * 10000d) / 10000d;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
