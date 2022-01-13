import java.util.*;
public class LinkedList_class {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println("list: "+list+" size: "+list.size());
        System.out.println("list to array: "+list.toArray());
        for (int i = 0; i < 10; i += 3) {
            list.remove(i);
        }
        System.out.println("list: "+list+" size: "+list.size());
    }
}
