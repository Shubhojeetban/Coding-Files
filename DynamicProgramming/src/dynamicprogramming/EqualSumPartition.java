package dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author Shubhojeet Banerjee
 */
public class EqualSumPartition {

    static boolean equalSum(int[] ar, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += ar[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) {
                    dp[i][j] = false;
                }
                if (j == 0) {
                    dp[i][j] = true;
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (ar[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - ar[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum/2];
    }

    public static void main(String[] args) {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        try {
            int n = Integer.parseInt(read.readLine());
            String[] s = read.readLine().split(" ");
            int[] ar = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = Integer.parseInt(s[i]);
            }
            boolean result = equalSum(ar, n);
            if (result) {
                out.println("Yes, there could be equal sum partition");
            } else {
                out.println("No, there couldn't be equal sum partition");
            }
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
