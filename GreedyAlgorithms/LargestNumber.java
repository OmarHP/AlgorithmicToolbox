import java.util.*;

public class LargestNumber{

    private static final int MAX_LENGTH=4;
    private static String largestNumber(String[] a) {
        //write your code here

        Arrays.sort(a, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                int maxLength=Math.max(o1.length(),o2.length());
                int minLength=Math.min(o1.length(),o2.length());

                int v1=0;
                int v2=0;

                for (int i=0; i<maxLength; i++){
                    v1=o1.charAt(i%o1.length());
                    v2=o2.charAt(i%o2.length());

                    if (v1!=v2){
                        break;
                    }
                }


                return v1==v2?
                        //if one is a cycle of other, for example 202 and 20 (we compare 02 and 20) or 585 and 58 (we compare 85 and 58) and we set up first the lowest
                        Integer.compare(Integer.valueOf(o2.substring(o2.length()-minLength,o2.length())),Integer.valueOf(o1.substring(o1.length()-minLength,o1.length())))
                        :Integer.compare(v1,v2);
            }
        });

        String result = "";

        for(int i=a.length-1; i>=0; i--){
            result+=a[i];
        }



        return result;
    }


    public static String largestNumberNaive(String[] a){
        Arrays.sort(a, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                return Long.compare(Long.valueOf(o1+o2),Long.valueOf(o2+o1));
            }
        });

        String result = "";

        for(int i=a.length-1; i>=0; i--){
            result+=a[i];
        }



        return result;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }

//        Stress test
//        Random random=new Random();
//        while(true){
//
//            String[] a=new String[2];
//            a[0]=String.valueOf(random.nextInt(1000)+1);
//            a[1]=String.valueOf(random.nextInt(1000)+1);
//
//            String r1=largestNumber(a);
//            String r2=largestNumberNaive(a);
//            System.out.println(r1+"=="+r2);
//
//            if(!r1.equals(r2)){
//                System.out.println("Input = "+a[0]+", "+a[1]);
//                break;
//            }
//
//        }
        System.out.println(largestNumber(a));
    }
}

