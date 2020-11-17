/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Shubhojeet Banerjee
 */
public class EqualSumPartitionInteger {
    static int equalPartition(int n, int ar[])
    {
        int sum =0;
        for(int i =0; i < n; i++){
            sum += ar[i];
        }
        if(sum %2 != 0){
         return 0;   
        }
        int[][] dp = new int[n+1][sum+1];
        for(int i =0; i < n+1; i++)
        for(int j =0; j < sum+1; j++){
            if(i == 0)
          dp[i][j] = 0;
         if(j ==0)
         dp[i][j] =1;
        }
         
         
         for(int i =1; i < n+1; i++){
             for(int j =1; j < sum+1; j++){
                 if(ar[i-1] <= j){
                     dp[i][j] = dp[i-1][j-ar[i-1]] + dp[i-1][j];
                 }
                 else
                     dp[i][j] = dp[i-1][j];
             }
         }
         if(dp[n][sum] != 0)
          return 1;
         else
          return 0;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(read.readLine());
        String[] s = read.readLine().split(" ");
        int[] ar = new int[n];
        for(int i =0; i < n; i++)
            ar[i] = Integer.parseInt(s[i]);
        int result = equalPartition(n, ar);
        if(result == 1)
            System.out.println("YES");
        if(result ==0)
            System.out.println("NO");
    }
}
