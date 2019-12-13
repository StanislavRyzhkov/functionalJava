package company.ryzhkov;

import company.ryzhkov.recursivelist.LinkedRecursiveList;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> empty = LinkedRecursiveList.createEmpty();

        System.out.println(empty.isEmpty());
        System.out.println(empty.size());

        List<Integer> integers = LinkedRecursiveList.of(1, 2, 3, 4, 12, 15, 100, 135);

        System.out.println(integers.isEmpty());
        System.out.println(integers.size());
        System.out.println(integers.get(7));

    }
}
