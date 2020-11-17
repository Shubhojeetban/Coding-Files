/*
Given a set of non-negative distinct integers, and a value m, 
determine if there is a subset of the given set with sum divisible by m.
 */
package dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

/**
 *
 * @author Shubhojeet Banerjee
 */
public class SubsetWithSumDivisibleByM {
    static public int DivisibleByM(int [] ar, int m)
    {
        int n = ar.length;
        if(n > m)
            return 1;
        boolean[] dp = new boolean[m];
        Arrays.fill(dp, false);
        for(int i =0; i < n; i++){
            if(dp[0])
                return 1;
            boolean [] temp = new boolean[m];
            Arrays.fill(temp, false);
            
            for(int j =0; j < m; j++){
                if(dp[j]){
                    if(dp[(j + ar[i]) % m] == false){
                        temp[(j + ar[i]) % m] = true;
                    }
                }
            }
            
            for(int j =0; j < m; j++){
                if(temp[j])
                    dp[j] = true;
                dp[ar[i] % m] = true;
            }
        }
        if(dp[0])
            return 1;
        else
            return 0;
    }
    static public int DivisibleByM1(int [] ar, int m){
        int n = ar.length;
        if(n > m)
            return 1;
        int[] cum = new int[n];
        cum[0] = ar[0];
        for(int i =1; i < n; i++)
            cum[i] = cum[i-1] + ar[i];
        HashSet<Integer> set = new HashSet<>();
        for(int i =0; i < n; i++){
            if(set.contains(cum[i] % m))
                return 1;
            if(ar[i] % m == 0 || cum[i] % m == 0)
                return 1;
            set.add(cum[i] % m);
        }
        return 0;
    }
    public static void main(String[] args){
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        try{
            int n = Integer.parseInt(read.readLine());
            int m = Integer.parseInt(read.readLine());
            String[] s = read.readLine().split(" ");
            int[] ar = new int[n];
            for(int i =0; i <n; i++)
                ar[i] = Integer.parseInt(s[i]);
            int result = DivisibleByM1(ar, m);
            System.out.println(result);
            
        }
        catch(Exception e){
            
        }
    }
}
