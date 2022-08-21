package modelclass;

import com.google.gson.annotations.SerializedName;
import jakarta.xml.bind.annotation.*;

@XmlType(propOrder = {"fullName", "universityId", "avgExamScore"})
public class Student {
    @SerializedName("Полное имя")
    private String fullName;

    @SerializedName("Идентификатор Университета")
    private String universityId;

    @SerializedName("Текущий номер курса")
    private int currentCourseNumber;

    @SerializedName("Средняя экзаменационная оценка")
    private float avgExamScore;

    public Student(String fullName, String universityId, int currentCourseNumber, float avgExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "\n" + "Студент: " + "\n" +
                "полное имя:'" + fullName + '\'' +
                ", ID Университета:'" + universityId + '\'' +
                ", текущий номер курса:" + currentCourseNumber +
                ", средняя экзаменационная оценка:" + avgExamScore;
    }

    @XmlElement(name = "StudentName")
    public String getFullName() {
        return fullName;
    }

    public Student setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    @XmlElement(name = "universityId")
    public String getUniversityId() {
        return universityId;
    }

    public Student setUniversityId(String universityId) {
        this.universityId = universityId;
        return this;
    }

    @XmlTransient
    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public Student setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
        return this;
    }

    @XmlElement(name = "avgScore")
    public float getAvgExamScore() {
        return avgExamScore;
    }

    public Student setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }
}
