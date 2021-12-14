package com.lz.Structure;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 树节点
 */
class TreeNode {
    /**
     * 数据
     */
    int data;
    /**
     * 左孩子
     */
    TreeNode leftChild;
    /**
     * 右孩子
     */
    TreeNode rightChild;

    TreeNode(int data) {
        this.data = data;
    }
}

/**
 * 二叉树遍历
 */
@SuppressWarnings("all")
public class BinaryTree {
    TreeNode root;

    public void insertNode(int data) {
        root = insert(root, data);
    }

    private TreeNode insert(TreeNode node, int data) {
        //如果是空则插入第一个节点
        if (node == null) return new TreeNode(data);
        if (data < node.data) {
            node.leftChild = insert(node.leftChild, data);
        } else if (data > node.data) {
            node.rightChild = insert(node.rightChild, data);
        } else {
            node.data = data;
        }
        return node;
    }


    /**
     * 前序遍历
     */
    public void preOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }

    /**
     * 中序遍历
     */
    public void inOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraveral(node.leftChild);
        System.out.println(node.data);
        inOrderTraveral(node.rightChild);
    }

    /**
     * 后序遍历
     */
    public void postOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraveral(node.leftChild);
        postOrderTraveral(node.rightChild);
        System.out.println(node.data);
    }

    /**
     * 广度优先遍历
     * @param root
     */
    public void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.data);
            if (node.leftChild != null) {
                queue.offer(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.offer(node.rightChild);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree btt = new BinaryTree();
        btt.insertNode(10);
        btt.insertNode(8);
        btt.insertNode(11);
        btt.insertNode(7);
        btt.insertNode(9);
        btt.insertNode(12);
        btt.preOrderTraveral(btt.root);
        System.out.println("========================");
        btt.inOrderTraveral(btt.root);
        System.out.println("========================");
        btt.postOrderTraveral(btt.root);
    }
}