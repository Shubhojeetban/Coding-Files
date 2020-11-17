/*
Maximum and minimum of an array using minimum number of comparisons
Method - 2
*/
package dsaseries;

/**
 *
 * @author Shubhojeet Banerjee
 */
public class MinmumMaximum {
    static class Pair{
        int min;
        int max;
    }
    static Pair getMinMax(int[] ar, int low, int high){
        Pair result = new Pair();
        Pair mml;
        Pair mmr;
        int mid;
        
        //checking for the size == 1
        if(low == high){
            result.min = result.max = ar[low];
            return result;
        }
        
        //checking for the size == 2
        else if( high == low +1){
            if(ar[0] > ar[1])
            {
                result.max = ar[low];
                result.min = ar[high];
            }
            else{
                result.max = ar[high];
                result.min = ar[low];
            }
            return result;
        }
        
        //checking for the size more than that
        else{
            mid = (low + high) /2;
            mml = getMinMax(ar, low, mid);
            mmr = getMinMax(ar, mid +1, high);
            
            if(mml.max > mmr.max){
                result.max = mml.max;
            }
            else
                result.max = mmr.max;
            
            if(mml.min < mmr.min)
                result.min = mml.min;
            else
                result.min = mmr.min;
            return result;
        }
    }
    public static void main(String[] args){
        int[] arr = {10, 20, 5, 40, 30};
        Pair p;
        p = getMinMax(arr, 0, arr.length -1);
        System.out.println("Minimum of the array "+p.min);
        System.out.println("Maximum of the array "+p.max);
    }
}
