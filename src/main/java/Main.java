import modelclass.Student;
import modelclass.University;

import java.util.List;

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

        //JsonUtil.jSonStudent(Reader.students.get(0));

        /*Reader.students
                .stream()
                .sorted(NeedableComparator.getStudentsCompare(EnumStudentsCompare.AVGeXAMsCORE))
                .forEach(System.out::println);*/

        Reader.readUniversity();

        String jSonUniversity = JsonUtil.jCollectionUniversity();
        System.out.println(jSonUniversity);

        List<University> listUniversityFromJson = JsonUtil.universityFromJson(jSonUniversity);
        System.out.println(listUniversityFromJson);
        if (listUniversityFromJson.size() == Reader.universities.size()){
            System.out.println("\n Сериализация коллекции университетов выполнена корректно \n");
        }


        //JsonUtil.jSonUniversity(Reader.universities.get(0));

        /*Reader.universities
                .stream()
                .sorted(NeedableComparator.getUniversityCompare(EnumUniversityCompare.ID))
                .forEach(System.out::println);*/
    }
}
