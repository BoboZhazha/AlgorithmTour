public abstract class AbstractList<E> implements List<E>{

    protected int size;

    @Override
    public int size() {
        return 0;
    }

    public void add(E element) {
        add(size, element);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 是否包含某个元素
     * @param element
     * @return
     */
    @Override
    public boolean contains(E element) {
        return indexOf(element) == ELEMENT_NOT_FOUND;
    }


    protected void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
    }

    protected void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    protected void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }

}
