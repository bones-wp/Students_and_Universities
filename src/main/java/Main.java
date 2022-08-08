import comparators.EnumStudentsCompare;
import comparators.EnumUniversityCompare;
import comparators.NeedableComparator;
import modelclass.Statistics;
import modelclass.Student;
import modelclass.University;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static modelclass.StudyProfile.MATHEMATICS;
import static modelclass.StudyProfile.PHYSICS;

public class Main {

    public static void main(String[] args) throws IOException {

        Reader.readStudents();

        String jSonStudents = JsonUtil.jCollectionStudent();
        System.out.println(jSonStudents);

        List<Student> listStudentsFromJson = JsonUtil.studentsFromJson(jSonStudents);
        System.out.println(listStudentsFromJson);
        if (listStudentsFromJson.size() == Reader.students.size()) {
            System.out.println("\n Сериализация коллекции студентов выполнена корректно \n");
        }

        Reader.readUniversity();

        String jSonUniversity = JsonUtil.jCollectionUniversity();
        System.out.println(jSonUniversity);

        List<University> listUniversityFromJson = JsonUtil.universityFromJson(jSonUniversity);
        System.out.println(listUniversityFromJson);
        if (listUniversityFromJson.size() == Reader.universities.size()) {
            System.out.println("\n Сериализация коллекции университетов выполнена корректно \n");
        }


        Reader.students.stream()
                .sorted(NeedableComparator.getStudentsCompare(EnumStudentsCompare.AVGeXAMsCORE))
                .forEach(x -> {
                    System.out.println("\n Сериализованный объект: " + JsonUtil.toJSonStudent(x));
                    System.out.println("Десериализованный объект: " + JsonUtil.fromJsonStudent(JsonUtil.toJSonStudent(x)));
                });

        Reader.universities.stream()
                .sorted(NeedableComparator.getUniversityCompare(EnumUniversityCompare.ID))
                .forEach(x -> {
                    System.out.println("\n Сериализованный объект: " + JsonUtil.toJSonUniversity(x));
                    System.out.println("Десериализованный объект: " + JsonUtil.fromJsonUniversity(JsonUtil.toJSonUniversity(x)));
                });


        String fos = "src/main/resources/statistics.xlsx";

        List<Statistics> statistics = StatisticsUtil.getStatistic(Reader.students, Reader.universities);

        XlsWriter.writeStatistics(statistics, fos);

    }

}
