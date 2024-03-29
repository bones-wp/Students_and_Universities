import modelclass.Statistics;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XlsWriter {
    private XlsWriter() {
    }

    public static void writeStatistics(List<Statistics> statistics, String fos) throws IOException {
        XSSFWorkbook newWorkbook = new XSSFWorkbook();

        XSSFFont font = newWorkbook.createFont();
        font.setFontHeightInPoints((short) 10);
        font.setFontName("Courier New");
        font.setBold(true);

        XSSFCellStyle style = newWorkbook.createCellStyle();
        style.setFont(font);

        XSSFSheet sheet = newWorkbook.createSheet("Статистика");
        sheet.setColumnWidth(0, 6000);
        sheet.setColumnWidth(1, 7000);
        sheet.setColumnWidth(2, 12000);
        sheet.setColumnWidth(3, 12000);
        sheet.setColumnWidth(4, 12000);

        XSSFRow row = sheet.createRow(0);
        XSSFCell cell = row.createCell(0);
        cell.setCellStyle(style);
        cell.setCellValue("Профиль обучения");
        cell = row.createCell(1);
        cell.setCellStyle(style);
        cell.setCellValue("Средний балл за экзамен");
        cell = row.createCell(2);
        cell.setCellStyle(style);
        cell.setCellValue("Количество студентов по профилю");
        cell = row.createCell(3);
        cell.setCellStyle(style);
        cell.setCellValue("Количество университетов по профилю");
        cell = row.createCell(4);
        cell.setCellStyle(style);
        cell.setCellValue("Название университетов");

        int i = 0;

        for (Statistics s : statistics) {
            row = sheet.createRow(1 + i);
            cell = row.createCell(0);
            cell.setCellValue(s.getStudyProfile().toString());
            cell = row.createCell(1);
            cell.setCellValue(s.getAvgExamScore());
            cell = row.createCell(2);
            cell.setCellValue(s.getSumProfileStudents());
            cell = row.createCell(3);
            cell.setCellValue(s.getSumProfileUniversities());
            cell = row.createCell(4);
            cell.setCellValue(s.getUniversityName());
            i++;
        }

        FileOutputStream outputStream = new FileOutputStream(fos);
        newWorkbook.write(outputStream);
    }

}
