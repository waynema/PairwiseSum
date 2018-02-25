
/*
   Given two arrays, (say [1,3,5] and [2,4]) and a number target (say 7),
   assume we sort by the sum of any pair of elements from each array, return the smallest index.

        In this example, the result is 3.
        Pair, Sum, Index
        (1,2), 3, 0
        (1,4), 5, 1
        (3,2), 5, 2
        (3,4), 7, 3 <- result
        (5,2), 7, 4
        (5,4), 9, 5
*/

import java.util.Arrays;

public class PairwiseSum {

    public static void main(String[] args){
        System.out.println("Hello World");
//        int nums1[] = {1,6,5};
//        int nums2[] = {9,2};
        int nums1[] = {2,4};
        int nums2[] = {3,8,7};
//        int target =  Integer.parseInt(args[0]);
        int target = 11;
        System.out.println(findIndex(nums1, nums2, target));
    }

//    static int findIndex(int[] nums1, int[] nums2, int target){
//        int count = 0;
//        for (int i=0; i<nums1.length; i++)
//            for (int j=0; j<nums2.length; j++)
//                if (nums1[i]+nums2[j] == target)
//                    return count;
//                else
//                    count += 1;
//        throw new IllegalArgumentException("No solution");
//    }

    // find lower bound: the largest index strictly smaller than a given number
    static int lowerBound(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    static int findIndex(int[] nums1, int[] nums2, int target) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int res = 0;
        boolean hasRes = false;
        for(int i = 0; i< nums1.length; i++) {
            int lb = lowerBound(nums2, target - nums1[i]) + 1;
            System.out.println(lb);
            if(lb < nums2.length && nums2[lb] == target - nums1[i])
                hasRes = true;
            res += lb;
        }
        if(hasRes)
            return res;
        return -1;
    }
}
