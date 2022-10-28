package com.lz;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class SolutionBfs2 {

    /**
     * 广度优先遍历,为所有node节点增加排序号,同时判断图是否成环
     * 1, 借助容器
     *      邻接数组: 记录每个节点的后续节点的集合
     *      入度数组: 记录每个节点的入度,当入度为0时,将其加入队列
     *      队列: 记录遍历的结果,避免出现相同的节点二次进入队列,节点出队列之后,对其进行标记序号.
     *      结果集: 记录结果
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashSet<Integer>[] adjacencyArr = new HashSet[numCourses];
        int[] inDegreeArr = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int[] rns = new int[numCourses];
        int index = 0;
        //遍历接续关系集合,构建邻接数组和入度数组
        for(int i=0;i<numCourses;i++) {
            adjacencyArr[i] = new HashSet<>();
        }
        for(int[] edge: prerequisites) {
            adjacencyArr[edge[1]].add(edge[0]);
            inDegreeArr[edge[0]]++;
        }
        //遍历邻接表,将入度为0的结果加入队列
        for(int i=0;i<numCourses;i++) {
            if(inDegreeArr[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer head = queue.poll();
            rns[index++] = head;
            HashSet<Integer> nodes = adjacencyArr[head];
            for(int node: nodes) {
                inDegreeArr[node]--;
                if(inDegreeArr[node]==0) { queue.offer(node); }
            }
        }
        if(index != numCourses) return new int[0];
        return rns;
    }
}