
package dsaseries;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author Shubhojeet Banerjee
 */
public class MinimumJumptoEndDP {
    int function(int[] ar, int high, int low){
        if(high == low)
            return 0;
        if(ar[low] == 0)
            return -1;
        
        
        
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
