package modelclass;

public class Statistics {
    StudyProfile studyProfile;
    float avgExamScore;
    int sumProfileStudents;
    int sumProfileUniversities;
    String universityName;

    public Statistics(StudyProfile studyProfile, float avgExamScore, int sumProfileStudents, int sumProfileUniversities, String universityName) {
        this.studyProfile = studyProfile;
        this.avgExamScore = avgExamScore;
        this.sumProfileStudents = sumProfileStudents;
        this.sumProfileUniversities = sumProfileUniversities;
        this.universityName = universityName;
    }

    public StudyProfile getStudyProfile() {
        return studyProfile;
    }

    public void setStudyProfile(StudyProfile studyProfile) {
        this.studyProfile = studyProfile;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public int getSumProfileStudents() {
        return sumProfileStudents;
    }

    public void setSumProfileStudents(int sumProfileStudents) {
        this.sumProfileStudents = sumProfileStudents;
    }

    public int getSumProfileUniversities() {
        return sumProfileUniversities;
    }

    public void setSumProfileUniversities(int sumProfileUniversities) {
        this.sumProfileUniversities = sumProfileUniversities;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
}
