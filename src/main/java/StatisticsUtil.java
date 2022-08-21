import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import modelclass.Statistics;
import modelclass.Student;
import modelclass.StudyProfile;
import modelclass.University;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;


public class StatisticsUtil {
    private StatisticsUtil() {}
    public static final Logger statisticsLog = Logger.getLogger(StatisticsUtil.class.getName());

    @XmlElementWrapper(name = "statisticalInfo")
    @XmlElement(name = "statisticsEntry")
    public static List<Statistics> getStatistic(List<Student> studentList, List<University> universityList) {
        statisticsLog.info("Сбор статистики запущен");
        List<Statistics> statistics = new ArrayList<>();

        Arrays.stream(StudyProfile.values())
                .forEach(x -> {
                    int sumUniversities = 0;
                    int sumStudents = 0;
                    float sumExamScore = 0F;
                    float avgExamScore;
                    String universityNames = "";

                    for (University university : universityList) {
                        if (university.getMainProfile() == x) {

                            sumUniversities++;
                            universityNames = universityNames + " " + university.getShortName() + "\n";

                            for (Student students : studentList) {
                                if (students.getUniversityId().equals(university.getId())) {
                                    sumStudents++;
                                    sumExamScore += students.getAvgExamScore();
                                }
                            }
                        }
                    }
                    avgExamScore = sumExamScore / sumStudents;
                    if (sumStudents == 0) {
                        Optional<Float> avgOptional = Optional.of(0F);
                        avgExamScore = avgOptional.get();
                    }
                    BigDecimal avgDecimal = new BigDecimal(avgExamScore);
                    float avgExamDecimal = avgDecimal.setScale(2, RoundingMode.UP).floatValue();

                    statistics.add(new Statistics(x, avgExamDecimal, sumStudents, sumUniversities, universityNames));
                });
        statisticsLog.info("Сбор статистики завершён");
        return statistics;
    }
}
