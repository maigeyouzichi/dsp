package com.lz;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

@SuppressWarnings("all")
public class Test001 {

    @Test
    public void test001() {
        int i = 1;
        i = i ++;
        int j = i ++;
        int k = i + ++i*i++;
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
    }

    @Test
    public void test002() {
        String str = 123+"";
        char[] chars = str.toCharArray();
    }

    @Test
    public void test003() {
        int[] arr = {1,2,3,0};
        int[] newArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(newArr);
        System.out.println(Arrays.toString(newArr));
        int a = 1;
        switch (a) {
            case 1 :
                System.out.println();
                break;
        }
        for (int i : arr) {

        }
    }

    public int getKthMagicNumber2(int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.offer(1L);
        long[] arr = {3,5,7};
        Set<Long> set = new HashSet<>();
        int rns = 1;
        for(int i=0;i<k;i++) {
            long curr = pq.poll();
            rns = (int) curr;
            for(long nu: arr) {
                long next = nu * curr;
                if (set.add(next)) pq.offer(next);
            }
        }
        return rns;
    }

    public int getKthMagicNumber(int k) {
        int[] factors = {3, 5, 7};
        Set<Long> seen = new HashSet<Long>();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        seen.add(1L);
        heap.offer(1L);
        int magic = 0;
        for (int i = 0; i < k; i++) {
            long curr = heap.poll();
            magic = (int) curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return magic;
    }
}
