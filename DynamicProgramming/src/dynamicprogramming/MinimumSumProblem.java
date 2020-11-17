/*

 */
package dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Shubhojeet Banerjee
 */
public class MinimumSumProblem {

    static int minimumSubsetSum(int[] ar, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += ar[i];
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
        ArrayList<Integer> t = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (ar[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - ar[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int i = 0; i < (sum + 1) / 2; i++) {
            if (dp[n][i]) {
                t.add(i);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < t.size(); i++) {
            min = Math.min(min, (sum - (2 * t.get(i))));
        }
        return min;
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
            int count = minimumSubsetSum(ar, n);
            out.println(count);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
