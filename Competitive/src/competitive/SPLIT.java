/*
You are given a string S with length N. Determine if it is possible to find 
two non-empty strings A and B which satisfy the following conditions:

A+B=S, where + denotes string concatenation
B is a substring of A
Note: B is a substring of A if B can be obtained from A by deleting several (possibly zero) 
characters from the beginning and several (possibly zero) characters from the end. For example,
"ab" is a substring of "cabd", but "ad" is not
 */
package competitive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author Shubhojeet Banerjee
 */
public class SPLIT {
    public static void main(String[] args){
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        try{
            int t = Integer.parseInt(read.readLine());
            while(t-- > 0){
                int n = Integer.parseInt(read.readLine());
                String s = read.readLine();
                boolean f = false;
                //This loop will run till the 1 character before the last, so that it can check the last character with the rest
                for(int i =1; i < n-1; i++){
                     if(s.charAt(i) == s.charAt(n-1))
                    {
                        out.println(s.charAt(i)+" "+s.charAt(n-1));
                        f= true;
                        break;
                    }
                }
                if(f)
                    out.println("YES");
                else
                    out.println("NO");
            }
            out.flush();
            out.close();
            read.close();
        }
        catch(Exception e){ }
    }
}
