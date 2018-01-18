package Java9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class StackWalkerLes {
    public static void main(String[] args) {
        one().forEach(System.out::println);

    }

    private static List<String> one(){

        return two();
    }

    private static List<String> two(){

         return StackWalker.getInstance().walk(s -> s.map(frame -> frame.getClassName()+"/"+frame.getMethodName())
                                                        .limit(10).collect(Collectors.toList()));
    }

}
