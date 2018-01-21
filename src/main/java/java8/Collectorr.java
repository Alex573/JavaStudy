package java8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Collectorr {
    public static void main(String[] args) {
        Stream.of("one","two").collect(toCollection(TreeSet::new));
        Stream.of("one","two").collect(minBy(Comparator.comparing(x -> x)));
        Stream.of("one", "two").max(Comparator.comparing(x -> x));
        Stream.of(1, 2).collect(averagingInt(x ->x));

        Map<Boolean, List<Integer>> map = Stream.of(1,2,3,4)
                .collect(partitioningBy(x -> x> 2));
        System.out.println(map);
        Map<Integer, List<Integer>> map2 = Stream.of(1,2,1,4)
                .collect(groupingBy(x -> x));
        System.out.println(map2);
        String result = Stream.of("one","two","three").collect(joining(",","{","}"));
        System.out.println(result);

        Map<Integer, Long> map3 = Stream.of(1,2,1,4)
                .collect(groupingBy(x -> x, counting()));
        System.out.println(map3);

        Map<Integer, List<Integer>> map4 = Stream.of(1,2,1,4)
                .collect(groupingBy(x -> x,mapping(x ->x , toList())));
        System.out.println(map4);
    }
}
