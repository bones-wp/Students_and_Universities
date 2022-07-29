import comparators.EnumStudentsCompare;
import comparators.EnumUniversityCompare;
import comparators.StudentComparator;
import comparators.UniversityComparator;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<StudentComparator> studentComp = new ArrayList<>();
        studentComp.add(NeedableComparator.getStudentsCompare(EnumStudentsCompare.UNIVERSITYiD));
        studentComp.add(NeedableComparator.getStudentsCompare(EnumStudentsCompare.CURRENTCOURSENAME));
        studentComp.add(NeedableComparator.getStudentsCompare(EnumStudentsCompare.FULLNAME));
        studentComp.add(NeedableComparator.getStudentsCompare(EnumStudentsCompare.AVGeXAMsCORE));

        List<UniversityComparator> universityComp = new ArrayList<>();
        universityComp.add(NeedableComparator.getUniversityCompare(EnumUniversityCompare.ID));
        universityComp.add(NeedableComparator.getUniversityCompare(EnumUniversityCompare.FULLNAME));
        universityComp.add(NeedableComparator.getUniversityCompare(EnumUniversityCompare.MAINPROFILE));
        universityComp.add(NeedableComparator.getUniversityCompare(EnumUniversityCompare.SHORTNAME));
        universityComp.add(NeedableComparator.getUniversityCompare(EnumUniversityCompare.YEARofFOUNDATION));

        Reader.readStudents();

        Reader.students
                .stream()
                .sorted(studentComp.get(0))
                .sorted(studentComp.get(1))
                .sorted(studentComp.get(2))
                .sorted(studentComp.get(3))
                .forEach(System.out::println);

        Reader.readUniversity();

        Reader.universities
                .stream()
                .sorted(universityComp.get(0))
                .sorted(universityComp.get(1))
                .sorted(universityComp.get(2))
                .sorted(universityComp.get(3))
                .sorted(universityComp.get(4))
                .forEach(System.out::println);
    }
}
