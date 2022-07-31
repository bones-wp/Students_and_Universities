import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import modelclass.Student;
import modelclass.University;

import java.lang.reflect.Type;
import java.util.List;


public class JsonUtil {

    private JsonUtil () {}

    static Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public static void jSonStudent(Student student) {
        String json = gson.toJson(student);
        System.out.println(json);
    }

    public static void jSonUniversity(University university) {
        String json = gson.toJson(university);
        System.out.println(json);
    }

    public static String jCollectionStudent() {
        return gson.toJson(Reader.students);
    }

    public static String jCollectionUniversity () {
        return gson.toJson(Reader.universities);
    }

    public static List<Student> studentsFromJson (String students) {
        Type type = new TypeToken<List<Student>>(){}.getType();
        return gson.fromJson(students, type);
    }

    public static List<University> universityFromJson (String university) {
        Type type = new TypeToken<List<University>>(){}.getType();
        return gson.fromJson(university, type);
    }
}
