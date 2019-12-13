package company.ryzhkov;

import company.ryzhkov.recursivelist.List;

public class Main {

    public static void main(String[] args) {


        List<String> empty = List.createEmpty();
        List<String> list1 = List.of("a");
        List<String> list2 = List.of("a", "b");
        List<String> list3 = List.of("a", "b", "c");

        System.out.println(0);
        for (String s : empty) {
            System.out.println(s);
        }
        System.out.println("---");

        System.out.println(1);
        for (String s : list1) {
            System.out.println(s);
        }
        System.out.println("---");

        System.out.println(2);
        for (String s : list2) {
            System.out.println(s);
        }
        System.out.println("---");

        System.out.println(3);
        for (String s : list3) {
            System.out.println(s);
        }
        System.out.println("---");
    }
}
