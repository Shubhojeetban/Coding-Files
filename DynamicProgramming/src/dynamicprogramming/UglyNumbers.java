/*
Ugly numbers are numbers whose only prime factors are 2, 3 or 5.
The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers.
By convention, 1 is included. Write a program to find Nth Ugly Number.
 */
package dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Shubhojeet Banerjee
 */
public class UglyNumbers {

    long getNthUglyNo(int n) {
        long[] ugly = new long[n];
        int i2, i3, i5;
        i2 = i3 = i5 = 0;
        long ugly2, ugly3, ugly5;
        long uglyNext = 1;
        ugly[0] = 1;
        //initializing the uglies
        ugly2 = 2;
        ugly3 = 3;
        ugly5 = 5;
        for (int i = 1; i < n; i++) {
            uglyNext = Math.min(ugly2, Math.min(ugly3, ugly5));
            ugly[i] = uglyNext;
            if (uglyNext == ugly2) {
                i2 = i2 + 1;
                ugly2 = ugly[i2] * 2;
            }
            if (uglyNext == ugly3) {
                i3 = i3 + 1;
                ugly3 = ugly[i3] * 3;
            }
            if (uglyNext == ugly5) {
                i5 = i5 + 1;
                ugly5 = ugly[i5] * 5;
            }
        }
        return uglyNext;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(read.readLine().trim());
        System.out.println(new UglyNumbers().getNthUglyNo(n));
    }
}
