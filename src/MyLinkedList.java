
public class MyLinkedList<E> {


    public MyLinkedList() {

    }

    class Node {
        Node next;
        Object data;

        Node(Object data) {
            this.data = data;
            this.next = null;
        }

        Object getData() {
            return data;
        }
    }

    Node head;
    private int numNodes = 0;

    public MyLinkedList(E i) {

        head = new Node(i);
        numNodes++;

    }

    public void add(int index, E element) {
        if (index >= numNodes) throw new ArrayIndexOutOfBoundsException("Index out of bound");
        Node temp = head;
        Node holder;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        holder = temp.next;
        temp.next = new Node(element);
        temp.next.next = holder;

        numNodes++;
    }

    public void addFirst(E element) {
        Node temp = new Node(element);
        temp.next = head;
        head = temp;
        numNodes++;
    }

    public void addLast(E element) {
        Node temp = head;
        for (int i = 0; i < numNodes - 1; i++) {
            temp = temp.next;
        }
        temp.next = new Node(element);
        numNodes++;
    }

    public void remove(int index) {
        if (index >= numNodes) throw new ArrayIndexOutOfBoundsException("Index out of bound");
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;

        }
        temp.next = temp.next.next;
        numNodes++;
    }

    public void remove(E o) {
        remove(indexOf(o));
    }


    public int size() {
        return numNodes;
    }

    public MyLinkedList<E> clone() {
        MyLinkedList<E> l = new MyLinkedList<E>();
        Node temp = head;

        for (int i = 0; i < numNodes - 1; i++) {
            temp = temp.next;
            l.addLast((E) temp.data);

        }
        return l;
    }

    public boolean contain(E o) {
        boolean found = false;
        Node temp = head;
        while (temp != null) {
            if (temp.data.equals(o)) {
                found = true;
                break;
            }
            temp = temp.next;
        }
        return found;
    }

    private int indexOf(E element) {
        int i = 0;
        Node temp = head;
        while (temp != null) {
            if (temp.data.equals(element)) {
                return i;
            }
            i++;
            temp = temp.next;
        }
        return -1;
    }

    public Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;

        }
        return temp;
    }


    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }


}