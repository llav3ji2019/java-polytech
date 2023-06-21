package lab5;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Functions {
    public static double getAverageFromIntegerList(final List<Integer> list) {
        return list.stream()
                .mapToInt(element -> element)
                .average()
                .orElse(0);
    }

    public static List<String> changeStringList(final List<String> list) {
        return list.stream()
                .map(Functions::changeString)
                .collect(Collectors.toList());
    }

    private static String changeString(final String src) {
        return "_new_" + src.toUpperCase();
    }

    public static List<Integer> getSquaredFromIntegerList(final List<Integer> list) {
        return list.stream()
                .collect(Collectors.groupingBy(
                        number -> number,
                        Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(entry -> (int) Math.pow(entry.getKey(), 2))
                .collect(Collectors.toList());
    }

    public static List<String> sortStringList(final Collection<String> collection, final char letter) {
        return collection.stream()
                .filter(element -> !element.isEmpty() && element.charAt(0) == letter)
                .sorted()
                .collect(Collectors.toList());
    }

    public static <T> T getLastItem(final Collection<T> collection) throws EmptyCollectionException {
        return collection
                .stream()
                .reduce((i, j) -> j)
                .orElseThrow(EmptyCollectionException::new);
    }

    public static int getSumOfEvenNumbers(final int[] list) {
        return Arrays.stream(list)
                .filter(el -> el % 2 == 0)
                .sum();
    }

    public static Map<Character, List<String>> changeCollection1(final List<String> list) {
        return list.stream()
                .filter(str -> !str.isEmpty())
                .collect(Collectors.groupingBy(k -> k.charAt(0),
                        Collectors.mapping(v -> v.substring(1), Collectors.toList())));
    }
}
