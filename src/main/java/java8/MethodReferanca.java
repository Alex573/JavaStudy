package java8;

import java.util.stream.Stream;

public class MethodReferanca {

    public static void main(String[] args) {
        Stream.of("one","two").map(x ->x.toUpperCase());
        Stream.of("one","two").map(String::toUpperCase);
        Stream.of(new Student("Max"), new Student("Mile"))
                .map(Student::getName)
                    .forEach(System.out::println);
        Stream.of("Jhonn","Elvis")
                .map(Student::new)
                .map(Student::getName)
                .forEach(System.out::println);
    }
}
class Student {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(String name) {

        this.name = name;
    }
}

