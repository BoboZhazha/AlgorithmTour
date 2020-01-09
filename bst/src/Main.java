import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(11);
        bst.add(2);
        bst.add(33);
        bst.add(1);
        bst.add(10);
        bst.add(21);
        bst.add(13);

        // BinarySearchTree<Person> bst2 = new BinarySearchTree<>((o1, o2) -> o1.getAge() - o2.getAge());

        // bst2.add(new Person(22,11.11));

        // bst.preorderTraversal();
        // bst.inorderTraversal();
        // bst.levelTraveral();
        System.out.println(bst.height2());
    }


}
