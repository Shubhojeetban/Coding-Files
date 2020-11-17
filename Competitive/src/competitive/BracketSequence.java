/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package competitive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;

/**
 *
 * @author Shubhojeet Banerjee
 */
public class BracketSequence {
    public static void main(String[] args){
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        try{
            
            int n = Integer.parseInt(read.readLine());
            String[] s = read.readLine().split(" ");
            if(s.length > n){
                out.print("Wrong Output");
            }
            else{
                int[] ar = new int[n];
                for(int i =0; i<n; i++){
                    ar[i] = Integer.parseInt(s[i]);
                }
                HashSet<Integer> set = new HashSet<>();
                boolean f;
                while(true){
                    f = true;
                    for(int i =0; i < n; i++){
                        if(set.contains(ar[i])){
                            f = false;
                            ar[i]++;
                            set.add(ar[i]);
                        }
                        else{
                            set.add(ar[i]);
                        }
                    }
                    if(f)
                        break;
                }
                for(Integer a : ar){
                    out.print(a+" ");
                }
                out.println();
            }
            
            
        }
        catch(Exception e){
          out.print("Wrong Output from catch");
        }
        out.flush();
        out.close();
    }
}
