import javax.swing.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;

public class BinarySearchTree<E> {

    private int size;

    private Node<E> root;

    private Comparator<E> comparator;

    public BinarySearchTree() {
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
    }


    /**
     * 前序遍历
     */
    public void preorderTraversal(Visitor<E> visitor) {
        preorderTraversal(root,visitor);
    }

    private void preorderTraversal(Node<E> node,Visitor<E> visitor) {
        if (node == null) return;
        visitor.visit(node.element);
        preorderTraversal(node.left,visitor);
        preorderTraversal(node.right,visitor);
    }

    /**
     * 中序遍历
     */
    public void inorderTraversal(Visitor<E> visitor) {
        postorderTraversal(root,visitor);
    }

    private void inorderTraversal(Node<E> node,Visitor<E> visitor) {
        if (node == null) return;
        inorderTraversal(node.left,visitor);
        visitor.visit(node.element);
        inorderTraversal(node.right,visitor);
    }

    public static interface Visitor<E> {
        void visit(E element);
    }


    /**
     * 后序遍历
     */
    public void postorderTraversal(Visitor<E> visitor) {
        postorderTraversal(root,visitor);
    }

    private void postorderTraversal(Node<E> node,Visitor<E> visitor) {
        if (node == null) return;
        postorderTraversal(node.left,visitor);
        postorderTraversal(node.right,visitor);
        visitor.visit(node.element);
    }


    /**
     * 层序遍历
     *
     */
    public void levelTraveral(Visitor<E> visitor) {
        if (root == null) return;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            visitor.visit(node.element);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    /**
     * 获得二叉树的高度
     * @return
     */
    public int height() {
        return height(root);
    }

    /**
     * 递归方式
     * @param node
     * @return
     */
    private int height(Node<E> node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    /**
     * 非递归方式获得高度, 通过层级遍历
     * @return
     */
    public int height2() {
        if (root == null) return 0;


        int levelSize = 1;
        int height = 0;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            levelSize--;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (levelSize == 0) {
                levelSize = queue.size();
                height++;
            }
        }
        return height;
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        return;
    }

    public void add(E element) {
        // 添加的是第一个节点
        if (root == null) {
            root = new Node<>(element, null);
            size++;
            return;
        }
        // 添加的不是第一个节点

        // 找到父节点
        Node<E> node = root;

        Node<E> parent = root;

        int cmp = 0;

        while (node != null) {
            cmp = compare(element, node.element);
            // 这里找到的是父节点
            parent = node;
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else { //相等,覆盖一下
                node.element = element;
                return;
            }
        }
        // 看看插入父节点位置
        Node<E> newNode = new Node<>(element, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;

        return;
    }

    /**
     * 外面传了比较实现了比较方法的接口就使用,不传就用默认的
     *
     * @param e1
     * @param e2
     * @return
     */
    private int compare(E e1, E e2) {
        // 如果你有comparator那么就用你的
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }

        // 二叉树必须是可以比较的, 不能比就是调用者的错误
        return ((Comparable<E>) e1).compareTo(e2);
    }

    public void remove(E element) {
        return;
    }

    public boolean contains(E element) {
        return false;
    }


}