public class Heap<E> {
    int lastPosition;
    int size;

    E[] array = (E[]) new Object[size];

    public Heap(int size) {
        this.size = size;
    }

    public void add(E obj) {
        array[++lastPosition] = obj;
        trickleup(lastPosition);
    }

    public void swap(int from, int to) {
        E temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }

    public void trickleup(int position) {
        if (position == 0) return;
        int parent = (int) Math.floor((position-1)/2);
        if (((Comparable<E>) array[position]).compareTo(array[parent]) > 0) {
            swap(position, parent);
            trickleup(parent);
        }
    }

    /*
    remove root node
     */
    public E remove() {
        E temp = array[0];
        swap(0, lastPosition--);
        trickleDown(0);
        return temp;
    }

    public void trickleDown(int parent) {
        int left = 2*parent + 1;
        int right = 2*parent +2;
        // when the left child is the last node and the parent is less than the child
        if ((left == lastPosition) && (((Comparable<E>) array[parent]).compareTo(array[left])<0)) {
            swap(parent, left);
            return;
        }
        // when the right child is the last node and the parent is less than the child
        if ((right == lastPosition) && (((Comparable<E>) array[parent]).compareTo(array[right])<0)) {
            swap(parent, right);
            return;
        }
        // when either child is not the last node
        if ((left >= lastPosition) || (right >= lastPosition)) return;
        //when left child is greater than right child and the parent is less than left child
        if ((((Comparable<E>) array[left]).compareTo(array[right])>0) && (((Comparable<E>) array[parent]).compareTo(array[left])<0)) {
            swap(parent, left);
            trickleDown(left);
        }
        else if (((Comparable<E>) array[parent]).compareTo(array[right])<0) {
            swap(parent, right);
            trickleDown(right);
        }

    }

}
