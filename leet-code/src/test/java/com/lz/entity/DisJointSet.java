package com.lz.entity;

class DisJointSet{
    /**
     * index - 代表元素本身
     * value - 代表其根节点的值
     */
    int[] arr;

    public DisJointSet(int n) {
        arr = new int[n];
        //初始化,根节点等于其自身
        for(int i=0;i<n;i++) {
            arr[i] = i;
        }
    }

    /**
     * 找到某个元素的根节点,并把其父节点指向根节点,方便最后比较的时候快速查询
     * @return root 节点
     */
    public int findRoot(int x) {
        return x == arr[x] ? x : (arr[x] = findRoot(arr[x]));
    }

    /**
     * 合并两个集合 -- 将其中一个根节点设置成另一个的父节点
     * @param x 元素x
     * @param y 元素y
     */
    public void union(int x, int y) {
        int xRoot = findRoot(x);
        int yRoot = findRoot(y);
        if (xRoot == yRoot) {
            return;
        }
        arr[xRoot] = yRoot;
    }
}