package com.lz.other;

import org.junit.jupiter.api.Test;

/**
 * 二分查找
 * @author lihao
 * @date 2021-12-02 15:35
 */
@SuppressWarnings("all")
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

    /**
     * 二分查找寻找最左值
     */
    int binarySearch_(int[] arr, int target) {
        if (arr==null || arr.length==0) return -1;
        int left = 0;
        int right = arr.length-1;
        int res = -1;
        while (left<=right) {
            int mid = left + (right - left)/2;
            if (arr[mid]>target) {
                right = mid -1;
            }else if (arr[mid] == target) {
                right = mid -1;
                res = mid;
            }else {
                left = mid +1;
            }
        }
        return res;
    }

    /**
     * 二分法查找最右值
     */
    int binarySearch__(int[] arr, int target) {
        if (arr==null || arr.length==0) return -1;
        int left = 0;
        int right = arr.length-1;
        int res = -1;
        while (left<=right) {
            int mid = left + (right - left)/2;
            if (arr[mid]>target) {
                right = mid -1;
            }else if (arr[mid] == target) {
                left = mid + 1;
                res = mid;
            }else {
                left = mid +1;
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] arr = {1,2,3,3,3,4,6};
//        int[] arr = {2,2,2};
        System.out.println(binarySearch__(arr, 5));
    }
}
