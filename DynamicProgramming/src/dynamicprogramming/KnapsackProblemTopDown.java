/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class KnapsackProblemTopDown {
    static int knapsack(int[] wt, int[] val, int W, int n){
        int[][] dp = new int[n+1][W+1];
        for(int i =0; i < n+1; i++)
            for(int j =0; j < W+1; j++)
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
        for(int i =1; i < n+1; i++)
            for(int j = 1; j < W+1; j++){
                if(wt[i-1] <= j)
                    dp[i][j] = Math.max(val[i-1]+dp[i-1][j-wt[i-1]], dp[i-1][j]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        return dp[n][W];
    }
     public static void main(String[] args) {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        try {
            int n = Integer.parseInt(read.readLine());
            String[] Swt = read.readLine().split(" ");
            int[] wt = new int[n];
            for (int i = 0; i < n; i++) {
                wt[i] = Integer.parseInt(Swt[i]);
            }
            String[] Sval = read.readLine().split(" ");
            int[] val = new int[n];
            for (int i = 0; i < n; i++) {
                val[i] = Integer.parseInt(Sval[i]);
            }
            int W = Integer.parseInt(read.readLine());
            int maxProfit = knapsack(wt, val, W, n);
            out.println(maxProfit);

            out.flush();
            out.close();
            read.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
