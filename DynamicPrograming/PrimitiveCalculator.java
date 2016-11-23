import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        ArrayList<Pair<Integer, Integer>> minimumOperations = new ArrayList<>(); //First integer for minimum number of operations, second integer for operation id
        minimumOperations.add(new Pair<Integer, Integer>(Integer.MAX_VALUE, null)); //we canot reach zero from 1 with these operations x*2 x*3 x+1
        minimumOperations.add(new Pair<Integer, Integer>(0, null)); //we start at index zero, so we have to substract 1 when accessing

        for (int i=2; i<=n; i++) {
            int operations[]=new int[3];
            operations[0]= i%2==0?i/2:0; //operation 0
            operations[1]= i%3==0?i/3:0; //operation 1
            operations[2]= i-1;          //operation 2

            Pair<Integer, Integer> minimum=null;
            for(int j=0; j<operations.length; j++){
                if(operations[j]>0){
                    //Since the problem says no matter which correct solution we return , we only save one, other case integer b should be a list
                    if (minimum==null || minimumOperations.get(operations[j]).a+1<minimum.a){
                        minimum=new Pair<Integer, Integer>(minimumOperations.get(operations[j]).a+1,j);
                    }
                }
            }
            minimumOperations.add(minimum);
        }

        // bactrak in order to retrieve the sequence
        while(n>1){
            Pair<Integer, Integer> current=minimumOperations.get(n);
            sequence.add(n);
            switch(current.b){
                case 0:
                    n=n/2;
                    break;
                case 1:
                    n=n/3;
                    break;
                case 2:
                    n=n-1;
                    break;
            }

        }

        sequence.add(n);

        Collections.reverse(sequence);
        return sequence;
    }

    private static class Pair<T,U>{

        T a;
        U b;

        public Pair(T a, U b){
            this.a=a;
            this.b=b;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

