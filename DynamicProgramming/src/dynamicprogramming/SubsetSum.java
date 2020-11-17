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
public class SubsetSum {
    static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    static private boolean subsetSum(int[] ar, int sum,int n){
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i =0; i < n+1; i++)
            for(int j =0; j < sum+1; j++)
            {
                if(i == 0)
                    dp[i][j] = false;
                if(j ==0)
                    dp[i][j] = true;
            }
        for(int i =1; i < n+1; i++)
            for(int j =1; j < sum+1; j++){
                if(ar[i-1] <= j)
                    dp[i][j] = dp[i-1][j-ar[i-1]] || dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        for(int i =0; i < n+1; i++) 
        {
            for(int j =0; j < sum+1; j++)
            {
                out.print(dp[i][j]+" ");
            }
            out.println();
        }
        return dp[n][sum];
    }
    public static void main(String[] args){
        
        try{
            int n = Integer.parseInt(read.readLine());
            int sum = Integer.parseInt(read.readLine());
            String[] s = read.readLine().split(" ");
            int[] ar = new int[n];
            for(int i =0;i < n; i++)
                ar[i] = Integer.parseInt(s[i]);
            boolean result = subsetSum(ar, sum, n);
            if(result)
                out.println("Yes, the subset is present");
            else
                out.println("No, the subset is not present");
            out.flush();
        }
        catch(Exception e){e.printStackTrace();}
    }
}
