package Java8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateJAva8 {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        localDate = localDate.minusDays(6);
        localDate = localDate.plusMonths(3);
        System.out.println(localDate);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(localDate.format(dateTimeFormatter));
        LocalDate  localDate1 = LocalDate.of(1990,12,31);
        System.out.println(localDate1);
        LocalDate localDate2 = LocalDate.parse("23/12/2001",dateTimeFormatter);
        System.out.println(localDate2);
    }
}
