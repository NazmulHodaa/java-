package agec;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class AgeC {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your birthday(yyyy MM dd)");
        LocalDate birthday = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
        System.out.println(calculate(birthday));
    }

    static String calculate(LocalDate birthday) {
        Period p = Period.between(birthday, LocalDate.now());
        return p.getYears() + " years " + p.getMonths() + " months " + p.getDays() + " days";
    }

}
