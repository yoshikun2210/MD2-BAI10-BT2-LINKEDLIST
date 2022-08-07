
class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>(10);

        list.add(0, 2);
        list.add(1, 2);
        list.add(2, 2);
        list.add(0, 2);
        list.add(0, 2);


        MyLinkedList<Integer> list2 = list.clone();

        list.remove(4);
        System.out.println(list.size());
        System.out.println(list2.size());
    }

}