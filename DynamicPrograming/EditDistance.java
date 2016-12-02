import java.util.*;

class EditDistance {


    public static int EditDistance(String s, String t) {
        int distance[][]=new int[s.length()+1][t.length()+1];

        for(int i=0; i<s.length()+1; i++)
            distance[i][0]=i;

        for(int j=0; j<t.length()+1; j++)
            distance[0][j]=j;

        for (int i=1; i<s.length()+1; i++){
            for(int j=1; j<t.length()+1; j++){
                int insertion=distance[i][j-1]+1;
                int deletion=distance[i-1][j]+1;
                int match=distance[i-1][j-1];
                int mismatch=distance[i-1][j-1]+1;
                if (s.charAt(i-1)==t.charAt(j-1)){
                    distance[i][j]=Math.min(Math.min(insertion, deletion),match);
                }else{
                    distance[i][j]=Math.min(Math.min(insertion, deletion),mismatch);
                }
            }
        }
        return distance[s.length()][t.length()];
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        String t = scan.next();

        System.out.println(EditDistance(s, t));
    }
}
