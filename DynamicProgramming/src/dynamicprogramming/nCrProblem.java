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
public class nCrProblem {
    static int nCr(int n, int r){
        int numerator = 1;
        for(int i =n; i > r; i--){
            numerator *= i;
        }
        int denominator = n-r;
        for(int i = denominator; i >= 1; i--){
            denominator *= i;
        }
        return (int) numerator / denominator;
    }
    public static void main(String[] args){
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        try{
            int t = Integer.parseInt(read.readLine());
            while(t-- > 0){
                int n = Integer.parseInt(read.readLine());
                int r = Integer.parseInt(read.readLine());
                int result = nCr(n, r);
                System.out.println(result);
            }
        }
        catch(Exception e){}
    }
}
