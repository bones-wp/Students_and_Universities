import comparators.EnumStudentsCompare;
import comparators.EnumUniversityCompare;

public class Main {

    public static void main(String[] args) {

        Reader.readStudents();

        Reader.students
                .stream()
                .sorted(NeedableComparator.getStudentsCompare(EnumStudentsCompare.AVGeXAMsCORE))
                .forEach(System.out::println);

        Reader.readUniversity();

        Reader.universities
                .stream()
                .sorted(NeedableComparator.getUniversityCompare(EnumUniversityCompare.ID))
                .forEach(System.out::println);
    }
}
