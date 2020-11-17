/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsaseries;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author Shubhojeet Banerjee
 */
public class MinimumNumberOfJumps {
    static int minimumJump(int[] ar, int n){
        int max, temp, i =0, jump =0;
        if(ar[0] == 0)
            return -1;
        while(i <n){
            temp = ar[i];
            max = i;
            if(ar[max] >= n-1){
                jump++;
                break;
            }
            if(ar[max] == 0){
                jump = -1;
                break;
            }
            for(int j =i; j < i+temp && j < n; j++){
                if(ar[max] < ar[j])
                    max = j;
            }
            //when the max is changed please jump to that location increase jump
            if(ar[max] != temp){
                i = max;
                jump++;
                continue;
            }
            i += ar[max];
            jump++;
            if(i >= n-1)
                break;
        }
        return jump-1;
    }
    public static void main(String[] args){
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        try{
            int t = Integer.parseInt(read.readLine());
            while(t-- > 0){
                int n = Integer.parseInt(read.readLine());
                String[] s = read.readLine().split(" ");
                int[] ar = new int[n];
                for(int i =0; i <n; i++)
                    ar[i] = Integer.parseInt(s[i]);
                int result = minimumJump(ar, n);
                out.println(result);
                out.flush();
            }
        }
        catch(Exception e){e.printStackTrace();}
    }
}
