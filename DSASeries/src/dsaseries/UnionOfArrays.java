/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsaseries;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;

/**
 *
 * @author Shubhojeet Banerjee
 */
public class UnionOfArrays {
    public static void main(String[] args){
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        try{
            int t = Integer.parseInt(read.readLine());
            while(t-- > 0){
                String[] num = read.readLine().split(" ");
                int n1 = Integer.parseInt(num[0]);
                int n2 = Integer.parseInt(num[1]);
                String[] s1 = read.readLine().split(" ");
                String[] s2 = read.readLine().split(" ");
                HashSet<Integer> ar1 = new HashSet<>();
                HashSet<Integer> ar2 = new HashSet<>();
                int temp;
                for(int i =0;i < n1; i++){
                    temp = Integer.parseInt(s1[i]);
                    ar1.add(temp);
                }
                
                for(int i =0;i < n2; i++){
                    temp = Integer.parseInt(s2[i]);
                    ar2.add(temp);
                }
                int j =0, sum =0;
                for(Integer n: ar1){
                    if(ar2.contains(n))
                        sum++;
                }
                out.println(ar1.size()+ar2.size()-sum);
                out.flush();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
