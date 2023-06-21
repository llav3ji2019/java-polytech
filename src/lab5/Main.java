package lab5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static lab5.Functions.changeCollection1;
import static lab5.Functions.changeStringList;
import static lab5.Functions.getAverageFromIntegerList;
import static lab5.Functions.getLastItem;
import static lab5.Functions.getSquaredFromIntegerList;
import static lab5.Functions.getSumOfEvenNumbers;
import static lab5.Functions.sortStringList;

public class Main {
    public static void main(String[] args) {
        // 1
        final List<Integer> listWithIntegers = new ArrayList<>();
        listWithIntegers.add(5);
        listWithIntegers.add(55);
        listWithIntegers.add(100);
        listWithIntegers.add(6);
        System.out.println("Part 1: " + getAverageFromIntegerList(listWithIntegers));

        //2
        final List<String> listWithStrings = new ArrayList<>();
        listWithStrings.add("AAAA");
        listWithStrings.add("bbbb");
        listWithStrings.add("aBc");
        listWithStrings.add("CdC");
        System.out.println("Part 2: " + changeStringList(listWithStrings));

        // 3
        final List<Integer> listWithIntegers2 = new ArrayList<>();
        listWithIntegers2.add(1);
        listWithIntegers2.add(1);
        listWithIntegers2.add(2);
        listWithIntegers2.add(3);
        listWithIntegers2.add(4);
        listWithIntegers2.add(4);
        listWithIntegers2.add(4);
        System.out.println("Part 3: " + getSquaredFromIntegerList(listWithIntegers2));
        // 4
        final Collection<String> listWithStrings2 = new ArrayList<>();
        listWithStrings2.add("aaa");
        listWithStrings2.add("acc");
        listWithStrings2.add("abc");
        listWithStrings2.add("dssa");
        listWithStrings2.add("berb");
        System.out.println("Part 4: " + sortStringList(listWithStrings2, 'a'));
        // 5
        final Collection<String> listWithStrings3 = new ArrayList<>();
        listWithStrings3.add("aaa");
        listWithStrings3.add("acc");
        listWithStrings3.add("abc");
        listWithStrings3.add("dssa");
        listWithStrings3.add("berb");
        try {
            System.out.println("Part 5: " + getLastItem(listWithStrings3));
        } catch (EmptyCollectionException e) {
            System.err.println("Part 5: Collection is empty");
        }
        // 6
        final int[] listWithIntegers3 = {5, 55, 100, 6};
        System.out.println("Part 6: " + getSumOfEvenNumbers(listWithIntegers3));

        //7
        final List<String> listWithStrings5 = new ArrayList<>();
        listWithStrings5.add("aaa");
        listWithStrings5.add("acc");
        listWithStrings5.add("abc");
        listWithStrings5.add("dssa");
        listWithStrings5.add("berffffb");
        Map<Character, List<String>> b = changeCollection1(listWithStrings5);
        System.out.println("Part 7:");
        for (Map.Entry<Character, List<String>> el : b.entrySet()) {
            System.out.println(el.getKey() + " " + el.getValue());
        }
    }
}
