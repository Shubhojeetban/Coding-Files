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
 * @author tcs
 */
public class Competitive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        try{
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            String s = read.readLine();
            boolean flag = false;
            for(int i =1; i < n; i++){
                String a = s.substring(0, i);
                String b = s.substring(i, n);
                if(a.length() >= b.length()){
                    if(a.contains(b)){
                    flag = true;
                    break;
                }
                    
                }
                
            }
            if(flag)
                out.println("YES");
            else
                out.println("NO");
            
        }
        read.close();
        out.flush();
        out.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
