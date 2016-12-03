import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {

        //array to save operators
        char[] ops = new char[exp.length() / 2];
        //array to save digits
        int[] digits = new int[exp.length() / 2 + 1];

        int i_digits = 0;
        int i_ops = 0;
        for (int i = 0; i < exp.length(); i++) {
            if (i % 2 == 0) { // digit
                digits[i_digits] = exp.charAt(i) - '0';
                i_digits++;
            } else { // operand
                ops[i_ops] = exp.charAt(i);
                i_ops++;
            }
        }

        int n = digits.length;
        long[][] m = new long[n][n];
        long[][] M = new long[n][n];
        for (int i = 0; i < n; i++) {
            m[i][i] = digits[i];
            M[i][i] = digits[i];
        }
        for (int s = 1; s < n; s++) {
            for (int i = 0; i < n - s; i++) {
                int j = i + s;
                long[] temp = MinAndMax(i, j, ops, m, M);
                m[i][j] = temp[0];
                M[i][j] = temp[1];
            }
        }
        return M[0][n - 1];
    }

    private static long[] MinAndMax(int i, int j, char[] op, long[][] m, long[][] M) {
        long mmin = Long.MAX_VALUE;
        long mmax = Long.MIN_VALUE;
        for (int k = i; k < j; k++) {
            long a = eval(M[i][k], M[k + 1][j], op[k]);
            long b = eval(M[i][k], m[k + 1][j], op[k]);
            long c = eval(m[i][k], M[k + 1][j], op[k]);
            long d = eval(m[i][k], m[k + 1][j], op[k]);
            mmin = Math.min(Math.min(Math.min(Math.min(mmin, a), b), c), d);
            mmax = Math.max(Math.max(Math.max(Math.max(mmax, a), b), c), d);
        }
        return new long[]{mmin,mmax};
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

