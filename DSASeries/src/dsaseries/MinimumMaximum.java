/*
Maximum and minimum of an array using minimum number of comparisons
Method - 3
*/
package dsaseries;

/**
 *
 * @author Shubhojeet Banerjee
 */
public class MinimumMaximum {
    static class Pair {
        int min;
        int max;
    }
    static Pair getMinMax(int[] ar , int low, int high){
        Pair result = new Pair();
        int i;
        int n = ar.length;
        if(n%2 == 0){
            if(ar[0] > ar[1]){
                result.max = ar[0];
                result.min = ar[1];
            }
            else{
                result.max = ar[1];
                result.min = ar[0];
            }
            i =2;
        }
        else{
            result.max = result.min = ar[0];
            i =1;
        }
        while(i < n-1){
            if(ar[i] > ar[i+1]){
                if(ar[i] > result.max){
                    result.max = ar[i];
                }
                if(ar[i+1] < result.min){
                    result.min = ar[i+1];
                }
            }
            else{
                if(ar[i+1] > result.max){
                    result.max = ar[i+1];
                }
                if(ar[i] < result.min){
                    result.min = ar[i];
                }
            }
            i += 2;
        }
        return result;
    }
    public static void main(String [] args){
        int[] ar = {12, 23,65, 98, 45, 73};
        Pair p = getMinMax(ar, 0, ar.length);
        System.out.println("Minimum of the array : "+p.min);
        System.out.println("Maximum of the array : "+p.max);
    }
}
