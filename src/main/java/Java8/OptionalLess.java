package Java8;

import java.util.Optional;

public class OptionalLess {
    public static void main(String[] args) {
        Optional<String> optionalS = get0();
        optionalS.ifPresent(System.out::println);

    }
    static Optional<String> get0(){
        if(false){
            return Optional.of("Hello");

        }
        return Optional.empty();

    }
}
