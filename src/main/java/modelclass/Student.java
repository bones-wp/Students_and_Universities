package modelclass;

import com.google.gson.annotations.SerializedName;

public class Student {
    @SerializedName("Полное имя")
    String fullName;

    @SerializedName("Идентификатор Университета")
    String universityId;

    @SerializedName("Текущий номер курса")
    int currentCourseNumber;

    @SerializedName("Средняя экзаменационная оценка")
    float avgExamScore;

    public Student(String fullName, String universityId, int currentCourseNumber, float avgExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }

    @Override
    public String toString() {
        return "\n" + "Студент: " + "\n" +
                "полное имя:'" + fullName + '\'' +
                ", ID Университета:'" + universityId + '\'' +
                ", текущий номер курса:" + currentCourseNumber +
                ", средняя экзаменационная оценка:" + avgExamScore;
    }

    public String getFullName() {
        return fullName;
    }

    public Student setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getUniversityId() {
        return universityId;
    }

    public Student setUniversityId(String universityId) {
        this.universityId = universityId;
        return this;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public Student setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
        return this;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public Student setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }
}
