import java.util.LinkedList;

public class Homework1 {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList();
        list.add(9);
        list.add(7);
        list.add(2);
        list.add(4);
        list.add(1);
        list.add(3);
        list.get(4);
        list.remove(1);
        System.out.println(list);
        LinkedList<Integer> list2 = new LinkedList();

        for(int i = 1; i < 4; ++i) {
            list2.add(i);
        }

        list.addAll(list2);
        System.out.println(list);
        sorts(list);
    }

    public static void sorts(LinkedList<Integer> list) {
        boolean sort = false;

        for(int n = list.size(); !sort; --n) {
            sort = true;

            for(int i = 0; i < n - 1; ++i) {
                if (((Integer)list.get(i)).compareTo((Integer)list.get(i + 1)) > 0) {
                    Integer swap = (Integer)list.get(i);
                    list.set(i, (Integer)list.get(i + 1));
                    list.set(i + 1, swap);
                    sort = false;
                }
            }
        }

        System.out.println(list);
    }
}
