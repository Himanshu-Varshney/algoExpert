package algoexpert.io.search;

public class BinarySearch {

    public static int binarySearch(int[] array, int target) {

        int left = 0;
        int right = array.length-1;
        int mid =-1;
        while (left<=right){
            mid = (left+right)/2;
            if(array[mid]==target)
                return mid;
            else if(array[mid]>target)
                right = mid-1;
            else
                left=mid+1;
        }

        return -1;
    }

}
