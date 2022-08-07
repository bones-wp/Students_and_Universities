import modelclass.Student;
import modelclass.StudyProfile;
import modelclass.University;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Reader {

    private Reader() {}

    static List<Student> students = new ArrayList<>();
    static List<University> universities = new ArrayList<>();

    public static void readStudents() throws IOException {
        FileInputStream fis = new FileInputStream("src/main/resources/universityInfo.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Студенты");
        Iterator<Row> iterator = sheet.iterator();
        iterator.next();
        while (iterator.hasNext()) {
            Row row = iterator.next();
            students.add(new Student(row.getCell(1).getStringCellValue(), row.getCell(0).getStringCellValue(),
                    (int) row.getCell(2).getNumericCellValue(), (float) row.getCell(3).getNumericCellValue()));
        }
    }

    public static void readUniversity() throws IOException {
        FileInputStream fis = new FileInputStream("src/main/resources/universityInfo.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Университеты");
        Iterator<Row> iterator = sheet.iterator();
        iterator.next();
        while (iterator.hasNext()) {
            Row row = iterator.next();

            String param = row.getCell(4).getStringCellValue();
            StudyProfile profile = StudyProfile.valueOf(param);

            universities.add(new University(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue(),
                    row.getCell(2).getStringCellValue(), (int) row.getCell(3).getNumericCellValue(), profile));
        }
    }
}
