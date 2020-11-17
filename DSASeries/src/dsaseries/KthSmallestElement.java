/*
K’th Smallest/Largest Element in Unsorted Array
Through PriorityQueue
*/
package dsaseries;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;

/**
 *
 * @author Shubhojeet Banerjee
 */
public class KthSmallestElement {

    public static void main(String[] args) {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        try {
            int t = Integer.parseInt(read.readLine());
            while (t-- > 0) {
                int n = Integer.parseInt(read.readLine());
                String[] s = read.readLine().split(" ");
                int k = Integer.parseInt(read.readLine());
                PriorityQueue<Integer> q = new PriorityQueue<>();
                int temp;
                for (int i = 0; i < n; i++) {
                     temp = Integer.parseInt(s[i]);
                     q.add(temp);
                }
                int result = 0;
                for(int i =0; i < k; i++){
                    result = q.poll();
                }
                out.println(result);
                out.flush();
            }
        } catch (Exception e) {
            
        }
    }
}
