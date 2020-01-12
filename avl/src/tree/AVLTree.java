package tree;

import java.util.Comparator;

public class AVLTree<E> extends BST<E> {
	public AVLTree() {
		this(null);
	}

	public AVLTree(Comparator<E> comparator) {
		super(comparator);
	}


    @Override
    protected void afterAdd(Node<E> node) {


    }

    @Override
    protected void afterRemove(Node<E> node) {
    }

    @Override
    protected Node<E> createNode(E element, Node<E> parent) {
        return super.createNode(element, parent);
    }


}
