package company.ryzhkov;

import company.ryzhkov.recursivelist.EmptyList;
import company.ryzhkov.recursivelist.InnerList;
import company.ryzhkov.recursivelist.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> list0 = EmptyList.instance;
        List<Integer> list1 = new InnerList<>(1, list0);
        List<Integer> list2 = new InnerList<>(2, list1);
        List<Integer> list3 = new InnerList<>(3, list2);


//        Iterator<Integer> iterator = list3.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        for (Integer i : list3) {
            System.out.println("Element: " + i);
        }
    }
}
