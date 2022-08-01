import comparators.EnumStudentsCompare;
import comparators.NeedableComparator;
import modelclass.Student;
import modelclass.University;

import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Reader.readStudents();

        String jSonStudents = JsonUtil.jCollectionStudent();
        System.out.println(jSonStudents);

        List<Student> listStudentsFromJson = JsonUtil.studentsFromJson(jSonStudents);
        System.out.println(listStudentsFromJson);
        if (listStudentsFromJson.size() == Reader.students.size()){
            System.out.println("\n Сериализация коллекции студентов выполнена корректно \n");
        }

        Stream<String> streamStudent = Stream.of(JsonUtil.jSonStudent(Reader.students.get(0)));
        streamStudent.forEach(System.out::println);


        Reader.readUniversity();

        String jSonUniversity = JsonUtil.jCollectionUniversity();
        System.out.println(jSonUniversity);

        List<University> listUniversityFromJson = JsonUtil.universityFromJson(jSonUniversity);
        System.out.println(listUniversityFromJson);
        if (listUniversityFromJson.size() == Reader.universities.size()){
            System.out.println("\n Сериализация коллекции университетов выполнена корректно \n");
        }

        Stream<String> streamUniversity = Stream.of(JsonUtil.jSonUniversity(Reader.universities.get(0)));
        streamUniversity.forEach(System.out::println);


    }
}
