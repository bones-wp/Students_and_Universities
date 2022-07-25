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

public class Reader {

    static FileInputStream fis;

    static {
        try {
            fis = new FileInputStream("src/main/resources/universityInfo.xlsx");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static XSSFWorkbook workbook;

    static {
        try {
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Reader(FileInputStream fis, XSSFWorkbook workbook) {
        Reader.fis = fis;
        Reader.workbook = workbook;
    }



    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<University> universities = new ArrayList<>();

    public static void readStudents() {
        XSSFSheet sheet = workbook.getSheet("Студенты");
        Iterator<Row> iterator = sheet.iterator();
        iterator.next();
        while (iterator.hasNext()) {
            Row row = iterator.next();
            students.add(new Student(row.getCell(1).getStringCellValue(), row.getCell(0).getStringCellValue(),
                    (int) row.getCell(2).getNumericCellValue(), (float) row.getCell(3).getNumericCellValue()));
        }
    }
    public static void readUniversity() {
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
