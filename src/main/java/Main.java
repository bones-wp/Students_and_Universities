import modelclass.Student;
import modelclass.StudyProfile;
import modelclass.University;

public class Main {

    public static void main(String[] args) {
        University university = new University("1", "КНИТУ им. А.Н. Туполева", "КАИ", 1932, StudyProfile.AVIATION);
        Student student = new Student("Иванов Иван Иванович", "1", 1, 4.2f);

        System.out.println(university);
        System.out.println(student);
    }
}
