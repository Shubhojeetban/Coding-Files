
package dsaseries;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author Shubhojeet Banerjee
 */
/*
Given a string S as input. You have to reverse the given string.

Input: First line of input contains a single integer T which denotes the number of test cases. T test cases follows, first line of each test case contains a string S.

Output: Corresponding to each test case, print the string S in reverse order.

Constraints:
1 <= T <= 100
3 <= length(S) <= 1000

Example:
Input:
3
Geeks
GeeksforGeeks
GeeksQuiz

Output:
skeeG
skeeGrofskeeG
ziuQskeeG
*/
public class DSASeries {
    static void reverseArray(char[] ch, int start, int end){
        if(start >= end)
            return;
        char temp = ch[start];
        ch[start] = ch[end];
        ch[end] = temp;
        reverseArray(ch, start+1, end-1);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		try{
		    int t = Integer.parseInt(read.readLine());
		    while(t-- > 0){
		        String s = read.readLine();
		        int n = s.length();
		        char[] ch = s.toCharArray();
		        reverseArray(ch, 0, n-1);
		        String result = new String(ch);
		        out.println(result); 
		    }
		    out.flush();
		}
		catch(Exception e){
		    e.printStackTrace();
		}
    }
    
}
