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
public class MovingOfNegativeAndPositiveNo {
    public static void main(String[] args){
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        try{
            int t = Integer.parseInt(read.readLine());
            while(t-- > 0){
                int n = Integer.parseInt(read.readLine());
                String[] s = read.readLine().split(" ");
                int [] ar = new int[n];
                for(int i =0; i < n; i++)
                    ar[i] = Integer.parseInt(s[i]);
                int j =0, temp;
                for(int i =0; i < n; i++){
                    if(ar[i] < 0){
                        if(i != j){
                            temp = ar[i];
                            ar[i] = ar[j];
                            ar[j] = temp;
                        }
                        j++;
                    }
                }
                for(int i =0; i < n; i++){
                    out.print(ar[i]+" ");
                }
                out.println();
                out.flush();
            }
        }
        catch(Exception e){
            
        }
    }
}
