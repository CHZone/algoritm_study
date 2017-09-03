package cai.algorithm.tree.binary_search_tree;

import java.util.LinkedList;
import java.util.Queue;

import cai.algorithm.sort.generate_test_case.SortTestHelper;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;
    private int count;

    public BST() {
        root = null;
        count = 0;
    }

    public void insert(Key key, Value value) {
        root = insert(root, key, value);
    }

    private Node insert(Node node, Key key, Value value) {
        if (node == null) {
            count++;
            return new Node(key, value);
        }
        if (node.getKey().compareTo(key) == 0) {
            node.setValue(value);
        } else if (node.getKey().compareTo(key) > 0) {
            node.setLeft(insert(node.getLeft(), key, value));
        } else if (node.getKey().compareTo(key) < 0) {
            node.setRight(insert(node.getRight(), key, value));
        }
        return node;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getValue() + ",");
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeft());
        System.out.print(node.getValue() + ",");
        inOrder(node.getRight());
    }

    public void postOrder() {
        postOrder(root);
        System.out.println();
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.print(node.getValue() + ",");
    }

    public void levelOrder() {
        LinkedList<Node> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if (node != null) {
                System.out.print(node.getValue() + ",");
                queue.add(node.getLeft());
                queue.add(node.getRight());
            }
        }
        System.out.println();
    }

    public void removeMax() {
        root = removeMax(root);
        count--;
    }

    private Node removeMax(Node node) {
        if (node == null) {
            return null;
        }
        // 当前节点为最大值，返回左子树给父节点，当前节点删除
        if (node.getRight() == null) {
            return node.getLeft();
        } else {
            node.setRight(removeMax(node.getRight()));// 错写成 return
                                                      // removeMax(node.getRight())
        }
        return node;
    }

    public void removeMin() {
        root = removeMin(root);
        count--;
    }

    private Node removeMin(Node node) {
        if (node == null) {
            return node;
        }
        if (node.getLeft() == null) {
            return node.getRight();
        } else {
            node.setLeft(removeMin(node.getLeft()));// 把removeMin(node.getLeft())
                                                    // 写成 node.getLeft()
        }
        return node;
    }

    public void remove(Key key) {
        root = remove(root, key);
    }

    private Node remove(Node node, Key key) {
        if (node == null) {
            return null;
        }
        if (node.getKey().equals(key)) {
            Node delNode = node;
            if (delNode.getLeft() == null) {
                return delNode.getRight();
            } else if (delNode.getRight() == null) {
                return delNode.getLeft();
            } else {
                Node rmid = getMin(delNode.getRight());
                removeMin(delNode.getRight());// 错写成delNode
                rmid.setLeft(delNode.getLeft());
                rmid.setRight(delNode.getRight());
                count--;
                return rmid;
            }

        } else if (node.getKey().compareTo(key) > 0) {
            node.setLeft(remove(node.getLeft(), key));
        } else {
            node.setRight(remove(node.getRight(), key));
        }
        return node;

    }

    private Node getMin(Node node) {
        if (node.getLeft() == null) {
            return node;
        } else {
            return getMin(node.getLeft());
        }
    }

    public Node find(Key key) {
        Node node = root;
        while (node != null) {
            if (node.getKey().equals(key)) {
                return node;
            } else if (node.getKey().compareTo(key) > 0) {
                node = node.getLeft();
            } else if (node.getKey().compareTo(key) < 0) {
                node = node.getRight();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int N = 10;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        arr[0] = 5;
        BST bst = new BST<>();
        for (int i = 0; i < arr.length; i++) {
            bst.insert(arr[i], arr[i]);
        }
        SortTestHelper.printArray(arr);
        bst.inOrder();
        bst.remove(1);
        // System.out.print(" ");
        bst.inOrder();
    }

}
