/*
Given an array arr of N integers. Find the contiguous sub-array with maximum sum.
 */
package dsaseries;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author Shubhojeet Banerjee
 */
public class KadanesAlgorithm {

    //Time Complexity O(n3)
    static int bruteforceApproach(int[] ar, int n) {
        int sum, max = Integer.MIN_VALUE;
        /*
        Explanation :
        so we are taking the sub array from i to j
        now by iterating by third loop we are to find the sum each time,
        and last we check for maximum
         */
        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < n; j++) {
                sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += ar[k];
                }
                max = Math.max(sum, max);
            }
        }
        return max;
    }

    //Time Complexity O(n2)
    static int quadraticSolution(int[] ar, int n) {
        int sum, max = Integer.MIN_VALUE;
        if (n != 1) {
            for (int i = 0; i < n - 1; i++) {
                sum = 0;
                for (int j = i; j < n; j++) {
                    sum += ar[j];
                    max = Math.max(sum, max);
                }
            }
            return max;
        }
        return ar[0];
    }
    
    // Most optimized solution i.e. Kadane's Algorithm
    static int kadaneAlgo(int[] ar, int n) {
        int max_current, max_global;
        max_current = max_global = ar[0];
        for(int i =1; i < n; i++){
            max_current = Math.max(max_current+ar[i], ar[i]);
            if(max_current > max_global)
                max_global = max_current;
        }
        return max_global;
    }

    public static void main(String[] args) {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        try {
            int t = Integer.parseInt(read.readLine());
            while (t-- > 0) {
                int n = Integer.parseInt(read.readLine());
                String[] s = read.readLine().split(" ");
                int[] ar = new int[n];
                for (int i = 0; i < n; i++) {
                    ar[i] = Integer.parseInt(s[i]);
                }
                int sum = kadaneAlgo(ar, ar.length);
                out.println(sum);
                out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
