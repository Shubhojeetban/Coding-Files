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
public class BellNumber {
    static int findNthBellNumber(int n){
        int[][] bell = new int[n+1][n+1];
        bell[0][0] = 1;
        for(int i =1; i < n+1; i++){
            for(int j = 0; j < i+1; j++){
                if(j == 0)
                    bell[i][j] = bell[i-1][i-1];
                else
                    bell[i][j] = bell[i][j-1]+bell[i-1][j-1];
            }
        }
        return bell[n][0];
    }
    public static void main(String[] args){
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        try{
            int n = Integer.parseInt(read.readLine());
            int result = findNthBellNumber(n);
            System.out.println(result);
        }
        catch(Exception e){}
    }
}
