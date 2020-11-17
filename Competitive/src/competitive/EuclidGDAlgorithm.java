/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package competitive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author Shubhojeet Banerjee
 */
public class EuclidGDAlgorithm {

    static int findGCD(int n, int m) {
        int dividend = (n > m) ? m : n;
        int divisor = (n > m) ? n : m;

        while (divisor != 0) {
            int remainder = dividend % divisor;
            dividend = divisor;
            divisor = remainder;
        }
        return dividend;
    }

    public static void main(String[] args) {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        try {
            int t = Integer.parseInt(read.readLine());
            while (t-- > 0) {
                String[] s = read.readLine().split(" ");
                int n = Integer.parseInt(s[0]);
                int m = Integer.parseInt(s[1]);
                int result = findGCD(n, m);
                out.println(result);
                out.flush();
            }
        } catch (Exception e) {
        }
    }
}
