/*
Catalan Number: 1 1 2 5 14 42
C(n) = C0Cn-1 + C1Cn-2 + C2Cn-3 + ----- + CiCn-i-1 + ------ + Cn-1C0
 */
package dynamicprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 *
 * @author Shubhojeet Banerjee
 */
public class NthCatalanNumber {

    public static BigInteger findCatalan(int n) {
        BigInteger[] ar = new BigInteger[n+1];
        ar[0] = BigInteger.ONE;
        ar[1] = BigInteger.ONE;
        for(int i= 2; i < n+1; i++){
            ar[i] = BigInteger.ZERO;
            for(int j =0; j < i; j++){
                ar[i] = ar[i].add(ar[j].multiply(ar[i-j-1]));
            }
        }
        return ar[n];
    }

    public static void main(String[] args) {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        try {
            int t = Integer.parseInt(read.readLine());
            while (t-- > 0) {
                int n = Integer.parseInt(read.readLine());
                System.out.println(findCatalan(n));
            }
        } catch (Exception e) {
        }
    }
}
