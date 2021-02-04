package com.hao.dataStructure.tree.binarysorttree;

/**
 * 二叉树排序树
 *
 * @author zrh
 * @version 1.0
 * @date 2021-02-03 09:05
 * 题目
 * 给你一个数列 (7, 3, 10, 12, 5, 1, 9)，要求能够高效的完成对数据的查询和添加
 **/
public class BinarySortTreeDemo {

}

//创建二叉排序树
class BinarySortTree {
    private Node root;


    public Node getRoot() {
        return root;
    }

    //查找要删除的结点
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    //查找父结点
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    //添加结点的方法
    public void add(Node node) {
        if (root == null) {
            root = node;//如果root为空则直接让root指向node
        } else {
            root.add(node);
        }
    }

    //删除结点
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            //找到需要删除的节点
            Node targetNode = search(value);
            //判断是否找到
            if (targetNode == null) {
                return;
            }
            //如果这个二叉树只有一个节点，且这个节点有是我们要删的
            if (root.left == null && root.right == null) {
                root = null;
            }
            //去找到父节点
            Node parent = searchParent(value);
            //如果要删除的节点是叶子节点就直接设置为空
            if (targetNode.left == null && targetNode.right == null) {
                //判断需要删除的节点是左节点还是右节点
                if (parent.left != null && parent.left.value == value) {
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == value) {
                    parent.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {
                //删除有两颗子树的节点
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;
            }else {
                //删除只有一个节点的节点
                if (targetNode.left !=null){
                    if (parent != null){
                        //targetNode是否是父节点的左子节点  parent.left = targetNode
                        if (parent.left.value == value){
                            parent.left = targetNode.left;
                            //targetNode是否是父节点的右子节点  parent.left = targetNode
                        }else {
                            parent.right = targetNode.left;
                        }
                    }else {
                        root = targetNode.left;
                    }
                } else { //如果要删除的结点有右子结点
                    if (parent != null) {
                        //如果 targetNode 是 parent 的左子结点
                        if (parent.left.value == value) {
                            parent.left = targetNode.right;
                        } else { //如果 targetNode 是 parent 的右子结点
                            parent.right = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;
                    }
                }
            }
        }
    }

    //编写方法:
    //1. 返回的 以node 为根结点的二叉排序树的最小结点的值
    //2. 删除node 为根结点的二叉排序树的最小结点

    /**
     * @param node 传入的结点(当做二叉排序树的根结点)
     * @return 返回的 以node 为根结点的二叉排序树的最小结点的值
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        //循环的查找左子节点，就会找到最小值
        while (target.left !=null){
            target = target.left;
        }
        //找到最小值删掉
        delNode(target.value);
        return target.value;
    }

    //中序遍历
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉排序树为空，不能遍历");
        }
    }

}

/**
 * 创建树得节点
 */
class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * 查找方法
     */
    public Node search(int value) {
        if (this.value == value) {
            return this;
        } else {
            if (this.value > value) {
                if (this.left == null) {
                    return null;
                }
                return this.left.search(value);
            } else {
                if (this.right == null) {
                    return null;
                }
                return this.right.search(value);
            }
        }
    }

    /**
     * 删除节点方法
     * */


    /**
     * 节点的父节点
     * 刚开始需要从父节点开始找
     */
    public Node searchParent(int value) {

        //如果当前节点就是父节点，返回当前节点
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (this.left != null && this.value > value) {
                return this.left.searchParent(value);
            } else if (this.right != null && this.value < value) {
                return this.right.searchParent(value);
            } else {
                return null;
            }

        }

    }


    /**
     * 添加方法
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                //向左递归，直到找到左子节点为空得
                this.left.add(node);
            }
        } else {
            if (node.right == null) {
                this.right = node;

            } else {
                this.right.add(node);
            }
        }
    }

    @Override
    public String toString() {
        return "Node [value=" + value + "]";
    }

}
