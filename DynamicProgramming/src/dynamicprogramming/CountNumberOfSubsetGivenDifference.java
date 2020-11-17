
package dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author Shubhojeet Banerjee
 */
public class CountNumberOfSubsetGivenDifference {
    static int countSubset(int[] ar, int n, int diff){
        int sum =0;
        for(int i =0; i < n; i++)
            sum += ar[i];
        int val = (diff + sum) / 2;
        int [][] dp = new int[n+1][val+1];
        for(int i =0; i < n+1; i++)
            for(int j =0; j < val+1; j++){
                if(i == 0)
                    dp[i][j] = 0;
                if(j == 0)
                    dp[i][j] = 1;
            }
        for(int i =1; i  < n+1; i++)
        {
            for(int j =0; j < val+1; j++){
                if(ar[i-1] <= j)
                    dp[i][j] = dp[i-1][j-ar[i-1]] + dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][val];
    }
    public static void main(String[] args){
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        try{
            int n = Integer.parseInt(read.readLine());
            int diff = Integer.parseInt(read.readLine());
            String[] s = read.readLine().split(" ");
            int [] ar = new int[n];
            for(int i =0; i < n; i++)
                ar[i] = Integer.parseInt(s[i]);
            int count = countSubset(ar, n, diff);
            out.println(count);
            out.flush();
        }
        catch(Exception e){ e.printStackTrace();}
    }
}
