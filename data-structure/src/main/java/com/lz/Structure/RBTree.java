package com.lz.Structure;

/**
 * 红黑树结点
 */
@SuppressWarnings("all")
class RBTreeNode {

    private int key;
    private boolean isBlack;
    private RBTreeNode left;
    private RBTreeNode right;
    private RBTreeNode parent;

    public RBTreeNode(int key) {
        this.key = key;
        this.isBlack = false; //新节点默认是红色
    }

    public int getKey() {
        return key;
    }

    public boolean isBlack() {
        return isBlack;
    }

    public RBTreeNode getLeft() {
        return left;
    }

    public RBTreeNode getRight() {
        return right;
    }

    public RBTreeNode getParent() {
        return parent;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setBlack(boolean black) {
        isBlack = black;
    }

    public void setLeft(RBTreeNode left) {
        this.left = left;
    }

    public void setRight(RBTreeNode right) {
        this.right = right;
    }

    public void setParent(RBTreeNode parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "RBTreeNode{" + "key=" + key + ", color=" + (isBlack == true ? "BLACK" : "RED") + '}';
    }
}

/**
 * 红黑树
 **/
@SuppressWarnings("all")
public class RBTree {

    RBTreeNode root; //根节点

    /*** 遍历节点 **/
    public void list(RBTreeNode node) {
        if (node == null) return; //叶子
        if (node.getLeft() == null && node.getRight() == null) {
            System.out.println(node);
            return;
        }
        System.out.println(node);
        // 递归 左孩子
        list(node.getLeft()); //递归 右孩子
        list(node.getRight());
    }

    public void insert(int key) {
        RBTreeNode node = new RBTreeNode(key);
        if (root == null) {
            node.setBlack(true);//根是黑色的
            root = node;
            return;
        }
        RBTreeNode parent = root;
        RBTreeNode son = null;
        if (key <= parent.getKey()) {
            son = parent.getLeft();
        } else {
            son = parent.getRight();
        }//find the position
        while (son != null) {
            parent = son;
            if (key <= parent.getKey()) {
                son = parent.getLeft();
            } else {
                son = parent.getRight();
            }
        }
        if (key <= parent.getKey()) {
            parent.setLeft(node);
        } else {
            parent.setRight(node);
        }
        node.setParent(parent); // 自平衡
        banlanceInsert(node);
    }

    /*** 自平衡 ** @param node */
    private void banlanceInsert(RBTreeNode node) {
        RBTreeNode father, grandFather;
        while ((father = node.getParent()) != null && father.isBlack() == false) {
            grandFather = father.getParent(); //父为祖左孩子
            if (grandFather.getLeft() == father) {
                RBTreeNode uncle = grandFather.getRight();
                if (uncle != null && uncle.isBlack() == false) {
                    setBlack(father);
                    setBlack(uncle);
                    setRed(grandFather);
                    node = grandFather;
                    continue;
                }
                if (node == father.getRight()) { //左旋
                    leftRotate(father);
                    RBTreeNode tmp = node;
                    node = father;
                    father = tmp;
                }

                setBlack(father);

                setRed(grandFather); //右旋
                rightRotate(grandFather);
            }//父为祖右孩子
            else {
                RBTreeNode uncle = grandFather.getLeft();
                if (uncle != null && uncle.isBlack() == false) {
                    setBlack(father);
                    setBlack(uncle);
                    setRed(grandFather);
                    node = grandFather;
                    continue;
                }
                if (node == father.getLeft()) { //右旋
                    rightRotate(father);
                    RBTreeNode tmp = node;
                    node = father;
                    father = tmp;
                }
                setBlack(father);
                setRed(grandFather); //左旋
                leftRotate(grandFather);
            }
        }
        setBlack(root);
    }

    /*** 左旋 ** @param node */
    private void leftRotate(RBTreeNode node) {
        RBTreeNode right = node.getRight();
        RBTreeNode parent = node.getParent();
        if (parent == null) {
            root = right;
            right.setParent(null);
        } else {
            if (parent.getLeft() != null && parent.getLeft() == node) {
                parent.setLeft(right)
                ;
            } else {
                parent.setRight(right);
            }
            right.setParent(parent);
        }
        node.setParent(right);
        node.setRight(right
                .getLeft())
        ;
        if (right.getLeft() != null) {
            right.getLeft().setParent(node);
        }
        right.setLeft(node);
    }

    /*** 右旋 ** @param node */
    private void rightRotate(RBTreeNode node) {
        RBTreeNode left = node.getLeft();
        RBTreeNode parent = node.getParent();
        if (parent == null) {
            root = left;
            left.setParent(null);
        } else {
            if (parent.getLeft() != null && parent.getLeft() == node) {
                parent.setLeft(left);
            } else {
                parent.setRight(left);
            }
            left.setParent(parent);
        }
        node.setParent(left);
        node.setLeft(left.getRight());
        if (left.getRight() != null) {
            left.getRight().setParent(node);
        }
        left.setRight(node);
    }

    private void setBlack(RBTreeNode node) {
        node.setBlack(true);
    }

    private void setRed(RBTreeNode node) {
        node.setBlack(false);
    }

    public static void main(String[] args) {
        RBTree rb = new RBTree();
        rb.insert(10);//根节点
        rb.insert(5);
        rb.insert(9);
        rb.insert(3);
        rb.insert(6);
        rb.insert(7);
        rb.insert(19);
        rb.insert(32);
        rb.insert(24);
        rb.insert(17);
        rb.list(rb.root);
    }
}