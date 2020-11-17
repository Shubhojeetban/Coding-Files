/*
Knapsack Problem : 
Input: Number of test case
Size of array
Array of weight
Array of Value
Knapsack weight
 */
package dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 *
 * @author Shubhojeet Banerjee
 */
public class DynamicProgramming {

    static int[][] dp = new int[102][1002];

    static int maxProfit(int[] wt, int[] val, int W, int n) {
        if (n == 0 || W == 0) {
            return 0;
        }
        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        if (wt[n - 1] <= W) {
            return dp[n][W] = Math.max(val[n - 1] + maxProfit(wt, val, W - wt[n - 1], n - 1), maxProfit(wt, val, W, n - 1));
        } else {
            return dp[n][W] = maxProfit(wt, val, W, n - 1);
        }
    }

    public static void main(String[] args) {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        try {
            out.println("Enter the size of the array : ");
            int n = Integer.parseInt(read.readLine());
            out.println("Enter the array of the weight : ");
            String[] wt = read.readLine().split(" ");
            int[] wtar = new int[n];
            for (int i = 0; i < n; i++) {
                wtar[i] = Integer.parseInt(wt[i]);
            }
            out.println("Enter the array of the value :");
            String[] val = read.readLine().split(" ");
            int[] valar = new int[n];
            for (int i = 0; i < n; i++) {
                valar[i] = Integer.parseInt(val[i]);
            }
            out.println("Enter the weight of the knapsack :");
            int W = Integer.parseInt(read.readLine());
            for (int[] a : dp) {
                Arrays.fill(a, -1);
            }
            int maxProfit = maxProfit(wtar, valar, W, n);
            out.println(maxProfit);

            out.flush();
            out.close();
            read.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
