import JAXB.JavaToXml;
import JAXB.Info;
import comparators.EnumStudentsCompare;
import comparators.EnumUniversityCompare;
import comparators.NeedableComparator;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import json.JavaToJson;
import json.JsonUtil;
import modelclass.Student;
import modelclass.University;

import java.io.IOException;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static JAXB.Info.statistics;


public class Main {

    public static final Logger mainLog = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException, JAXBException {

        LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("logging.properties"));
        mainLog.info("Программа запущена");

        Reader.readStudents();

        String jSonStudents = JsonUtil.jCollectionStudent();
        //System.out.println(jSonStudents);

        List<Student> listStudentsFromJson = JsonUtil.studentsFromJson(jSonStudents);
        /*System.out.println(listStudentsFromJson);
        if (listStudentsFromJson.size() == Reader.students.size()) {
            System.out.println("\n Сериализация коллекции студентов выполнена корректно \n");
        }*/

        Reader.readUniversity();

        String jSonUniversity = JsonUtil.jCollectionUniversity();
        //System.out.println(jSonUniversity);

        List<University> listUniversityFromJson = JsonUtil.universityFromJson(jSonUniversity);
        /*System.out.println(listUniversityFromJson);
        if (listUniversityFromJson.size() == Reader.universities.size()) {
            System.out.println("\n Сериализация коллекции университетов выполнена корректно \n");
        }*/


        Info.students.stream()
                .sorted(NeedableComparator.getStudentsCompare(EnumStudentsCompare.AVGeXAMsCORE))
                .forEach(x -> {
                    /*System.out.println("\n Сериализованный объект: " + */
                    JsonUtil.toJSonStudent(x);
                    /*System.out.println("Десериализованный объект: " + */
                    JsonUtil.fromJsonStudent(JsonUtil.toJSonStudent(x));
                });

        Info.universities.stream()
                .sorted(NeedableComparator.getUniversityCompare(EnumUniversityCompare.ID))
                .forEach(x -> {
                    /*System.out.println("\n Сериализованный объект: " + */
                    JsonUtil.toJSonUniversity(x);
                    /*System.out.println("Десериализованный объект: " + */
                    JsonUtil.fromJsonUniversity(JsonUtil.toJSonUniversity(x));
                });


        String fos = "src/main/resources/statistics.xlsx";

        statistics = StatisticsUtil.getStatistic(Info.students, Info.universities);

        XlsWriter.writeStatistics(statistics, fos);

        JAXBContext context = JAXBContext.newInstance(Info.class);

        JavaToJson.javaToJson(context);
        JavaToXml.javaToXml(context);

        mainLog.info("Программа завершена");
    }

}
