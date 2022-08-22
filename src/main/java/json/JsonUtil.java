package json;

import JAXB.Info;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import modelclass.Student;
import modelclass.University;

import java.lang.reflect.Type;
import java.util.List;

public class JsonUtil {

    private JsonUtil() {
    }

    static Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public static String toJSonStudent(Student student) {
        return gson.toJson(student);
    }

    public static String toJSonUniversity(University university) {
        return gson.toJson(university);
    }

    public static Student fromJsonStudent(String string) {
        return gson.fromJson(string, Student.class);
    }

    public static University fromJsonUniversity(String string) {
        return gson.fromJson(string, University.class);
    }

    public static String jCollectionStudent() {
        return gson.toJson(Info.students);
    }

    public static String jCollectionUniversity() {
        return gson.toJson(Info.universities);
    }

    public static List<Student> studentsFromJson(String students) {
        Type type = new TypeToken<List<Student>>() {}.getType();
        return gson.fromJson(students, type);
    }

    public static List<University> universityFromJson(String university) {
        Type type = new TypeToken<List<University>>() {}.getType();
        return gson.fromJson(university, type);
    }
}
