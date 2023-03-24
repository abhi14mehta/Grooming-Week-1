import java.util.Arrays;

// 1.6 Find the Kth largest and Kth smallest number in an array.



public class FindElement {

    public static int kthLargest(int[] arr,int k){
        return arr[arr.length-k];
    }
    
    public static int kthSmallest(int[] arr,int k){
        return arr[k-1];
    }
    public static void main(String[] args) {
        int[] arr = {4,8,5,9,2,6,1};
        int k = 3;
        Arrays.sort(arr);
        int kthLargest = kthLargest(arr,k);
        int kthSmallest = kthSmallest(arr,k);
        System.out.println(kthLargest);
        System.out.println(kthSmallest);
    }
}
