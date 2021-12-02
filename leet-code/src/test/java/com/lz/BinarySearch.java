package com.lz;

/**
 * 二分查找
 * @author lihao
 * @date 2021-12-02 15:35
 */
public class BinarySearch {

    /**
     * 二分法查找
     * @param nums 有序数组
     * @param t 目标值
     * @return 目标值下标 或者 -1
     */
    int binarySearch(int[] nums, int t) {
        int low = 0;
        int hign = nums.length -1;
        int mid = 0;
        while (low <= hign) {
            mid = (low+hign)/2;
            if (nums[mid] == t) {
                return mid;
            }else if (nums[mid] > t) {
                hign = mid -1;
            }else {
                low = mid+1;
            }
        }
        return -1;
    }
}
