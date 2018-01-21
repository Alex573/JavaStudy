package java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class Streams {

    public static void main(String[] args) {
        //Java 7
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        for (String s : list) {
            System.out.println(s);
        }
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        // Java 8

        Stream<String> stream = list.stream();
        stream.forEach(x -> System.out.println(x));
        //or 2x stream no
       // stream.forEach(System.out::println);
        //or
        list.forEach(System.out::println);
        System.out.println("-----------------------");
        list.stream()
                .filter(x -> {
            System.out.println(x);
            return x.equalsIgnoreCase("two");
        }).count();//filter lazy, count eager
        System.out.println("--------------");

        Set<String> lse =  list.stream()
                                .filter(x -> x.equalsIgnoreCase("two"))
                                .collect(Collectors.toSet());


        list.stream().map(String::toUpperCase).forEach(System.out::println);

        Stream.of(asList("one", "two"), asList("Four", "Five"))
                .flatMap(Collection::stream).forEach(System.out::println);


       int value = Stream.of(1,2).min(Comparator.comparing(x -> x)).get();
       int value2 = Stream.of(1,2).max(Comparator.comparing(x -> x)).get();

       int count = Stream.of(1,2,3).reduce(0,(acc, element) -> acc + element);
        System.out.println(count);

        List<String> sorted = Stream.of("one", "two").sorted().collect(Collectors.toList());

        List<String> limit = Stream.of("one", "two").limit(1).collect(Collectors.toList());

        List<String> distinct = Stream.of("one", "one").distinct().collect(Collectors.toList());

        List<String> skip = Stream.of("one", "one").skip(1).collect(Collectors.toList());

        Stream.of("one", "two")
                .filter(x -> x.equalsIgnoreCase("one"))
                .findAny()
                .get();

        Stream.of("one", "two")
                .filter(x -> x.equalsIgnoreCase("one"))
                .findAny()
                .isPresent();

        Stream.of(1, 2).mapToInt(x -> x).sum();
        Stream.of(1, 2).count();

        Stream.of("one", "two")
                .peek(String::toUpperCase)
                .findFirst()
                .get();

        IntStream intStream = Stream.of(1, 2).mapToInt(x -> x);
        intStream.summaryStatistics().getAverage();

    }

}
