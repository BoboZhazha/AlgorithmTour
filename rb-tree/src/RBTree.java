import java.util.ArrayList;

/**
 * 之后再来实现
 */
public class RBTree<K extends Comparable<K>, V> {

    private class Node{
        public static final boolean RED = true;
        public static final boolean BLACK = false;

        public K key;
        public V value;
        public Node left, right;
        public boolean color;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            color = RED;
        }
    }

    private Node root;
    private int size;

    public RBTree(){
        root = null;
        size = 0;
    }

    public static void main(String[] args){

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("/Users/zhang/IdeaProjects/AlgorithmTour/avl-easy/src/pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());
        }

        System.out.println();
    }
}