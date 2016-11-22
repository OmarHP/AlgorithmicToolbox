import java.lang.reflect.Array;
import java.util.*;

public class PointsAndSegments {

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        //write your code here
        Pair[] pairs=new Pair[starts.length*2+points.length];
        HashMap<Integer,ArrayList<Integer>> pointsMap= new HashMap<>();

        int i=0;
        //We lalbel each point as follows starts:1, ends:3 and points:2
        for(int aux:starts)
            pairs[i++]=new Pair(aux,1);

        for(int aux:ends)
            pairs[i++]=new Pair(aux,3);

        for(int j=0; j<points.length; j++){
            int point=points[j];
            pairs[i++]=new Pair(point,2);
            if(pointsMap.containsKey(point)){
                pointsMap.get(point).add(j);
            }else{
                ArrayList<Integer> list= new ArrayList<>();
                list.add(j);
                pointsMap.put(point,list);
            }
        }

        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.a==o2.a)
                    return Integer.compare(o1.b, o2.b);
                return Integer.compare(o1.a, o2.a);
            }
        });

        int coverage=0;
        for (Pair pair: pairs){
            if(pair.b==1) //If it's a starting point of any segment
                coverage++;
            else if(pair.b==3) //If it's a ending point of any segment
                coverage--;
            else { //if it's a point
                ArrayList<Integer> indexes=pointsMap.get(pair.a);
                for(Integer k:indexes){
                    cnt[k]=coverage;
                }
            }
        }




        return cnt;
    }

    private static class Pair {
        int a, b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }


    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}

