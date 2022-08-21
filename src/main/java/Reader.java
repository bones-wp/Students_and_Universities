import JAXB.Info;
import modelclass.Student;
import modelclass.StudyProfile;
import modelclass.University;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Logger;

public class Reader {

    private Reader() {
    }

    public static final Logger readerLog = Logger.getLogger(Reader.class.getName());

    public static void readStudents() throws IOException {
        readerLog.info("Создание списка студентов начато");

        FileInputStream fis;
        try {
            fis = new FileInputStream("src/main/resources/universityInfo.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet("Студенты");
            Iterator<Row> iterator = sheet.iterator();
            iterator.next();
            while (iterator.hasNext()) {
                Row row = iterator.next();
                Info.students.add(new Student(row.getCell(1).getStringCellValue(), row.getCell(0).getStringCellValue(),
                        (int) row.getCell(2).getNumericCellValue(), (float) row.getCell(3).getNumericCellValue()));
            }
            readerLog.info("Создание списка студентов завершено");

        } catch (FileNotFoundException e){
            readerLog.severe("Ошибка чтения universityInfo.xlsx!");
        }
    }

    public static void readUniversity() throws IOException {
        readerLog.info("Создание списка университетов начато");

        FileInputStream fis;
        try {
            fis = new FileInputStream("src/main/resources/universityInfo.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet("Университеты");
            Iterator<Row> iterator = sheet.iterator();
            iterator.next();
            while (iterator.hasNext()) {
                Row row = iterator.next();

                String param = row.getCell(4).getStringCellValue();
                StudyProfile profile = StudyProfile.valueOf(param);

                Info.universities.add(new University(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue(),
                        row.getCell(2).getStringCellValue(), (int) row.getCell(3).getNumericCellValue(), profile));
            }
            readerLog.info("Создание списка университетов завершено");

        } catch (FileNotFoundException e){
            readerLog.severe("Ошибка чтения universityInfo.xlsx!");
        }
    }
}
