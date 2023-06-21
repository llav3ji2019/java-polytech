package lab3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Mammals> srcList1 = new ArrayList<>();
        srcList1.add(new Lynx("a", 1));
        srcList1.add(new Lynx("b", 2));
        srcList1.add(new Lynx("c", 3));
        srcList1.add(new Manul("d", 4));
        srcList1.add(new Manul("e", 5));
        srcList1.add(new CommonHedgehog("f", 6));
        srcList1.add(new CommonHedgehog("g", 7));
        srcList1.add(new CommonHedgehog("h", 8));
        srcList1.add(new CommonHedgehog("i", 9));

        List<Hedgehogs> collection11 = new ArrayList<>();
        List<Feline> collection21 = new ArrayList<>();
        List<Predatory> collection31 = new ArrayList<>();
        segregate(srcList1, collection11, collection21, collection31);
        System.out.println("1 part: ");
        printAllAges(collection11);
        printAllAges(collection21);
        printAllAges(collection31);
        System.out.println();


        List<Predatory> srcList2 = new ArrayList<>();
        srcList2.add(new Lynx("a", 1));
        srcList2.add(new Lynx("b", 2));
        srcList2.add(new Lynx("c", 3));
        srcList2.add(new Manul("d", 4));
        srcList2.add(new Manul("e", 5));
        List<Chordal> collection12 = new ArrayList<>();
        List<Manul> collection22 = new ArrayList<>();
        List<Feline> collection32 = new ArrayList<>();
        segregate(srcList2, collection12, collection22, collection32);
        System.out.println("2 part: ");
        printAllAges(collection22);
        printAllAges(collection32);
        System.out.println();


        List<Hedgehogs> srcList3 = new ArrayList<>();
        srcList3.add(new CommonHedgehog("f", 6));
        srcList3.add(new CommonHedgehog("g", 7));
        srcList3.add(new CommonHedgehog("e", 8));
        srcList3.add(new CommonHedgehog("i", 9));
        List<Insectivorous> collection13 = new ArrayList<>();
        List<Predatory> collection23 = new ArrayList<>();
        List<Predatory> collection33 = new ArrayList<>();
        segregate(srcList3, collection13, collection23, collection33);
        System.out.println("3 part: ");
        printAllAges(collection13);
        System.out.println();
        System.out.format("%8s%8s%8s\n", "Size1", "Size2", "Size3");
        System.out.format("%8d%8d%8d\n", collection11.size(), collection21.size(), collection31.size());
        System.out.format("%8d%8d%8d\n", collection12.size(), collection22.size(), collection32.size());
        System.out.format("%8d%8d%8d\n", collection13.size(), collection23.size(), collection33.size());
    }

    private static void printAllAges(final List<? extends Chordal> collection) {
        for (var animal : collection) {
            System.out.print(animal.getAge() + " ");
        }
        System.out.println();
    }

    private static void segregate(List<? extends Mammals> srcCollection, List<? super Hedgehogs> collection1, List<? super Manul> collection2, List<? super Feline> collection3) {
        for (Mammals animal : srcCollection) {
            if (animal instanceof CommonHedgehog) {
                collection1.add((CommonHedgehog) animal);
            } else if (animal instanceof Manul) {
                collection2.add((Manul) animal);
            } else if (animal instanceof Lynx) {
                collection3.add((Feline) animal);
            } else {
                throw new IllegalArgumentException();
            }
        }
    }
}
