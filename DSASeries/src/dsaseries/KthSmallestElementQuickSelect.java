
package dsaseries;

/**
 *
 * @author Shubhojeet Banerjee
 */
public class KthSmallestElementQuickSelect {
    int kthSmallest(int[] ar, int l, int r, int k){
        if(k >0 && k <= r-l+1){
            int pos = randomPartition(ar, l, r);
            
            if(pos-l == k-1)
                return ar[pos];
            if(pos-l > k-1)
                return kthSmallest(ar, l, pos-1, k);
            return kthSmallest(ar,pos+1, r, k-pos+l-1);
        }
        return Integer.MAX_VALUE;
    }
    int randomPartition(int[] ar, int l, int r){
        int n = r-l+1;
        int pivot = (int)(Math.random() *(n-1));
        swap(ar, l+pivot, r);
        return partition(ar, l, r);
    }
    void swap(int[] ar, int l, int r){
        int temp = ar[r];
        ar[r] = ar[l];
        ar[l] = temp;
    }
    int partition(int[] ar, int l, int r){
        int x = ar[r], i = l;
        for(int j = l; j < r; j++){
            if(ar[j] <= x){
                swap(ar, i, j);
                i++;
            }
        }
        swap(ar, i, r);
        return i;
    }
    public static void main(String[] args){
        int[] ar = {12, 57, 31, 2, 9, 65};
        KthSmallestElementQuickSelect ob = new KthSmallestElementQuickSelect();
        System.out.println("Minimum kth Smallest element from the list is : "+ob.kthSmallest(ar, 0, ar.length-1, 4));
    }
}
