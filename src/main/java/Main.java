import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Reader.readStudents();
        System.out.println(Reader.students);

        Reader.readUniversity();
        System.out.println(Reader.universities);

    }
}
