package modelclass;

public enum StudyProfile {

    PHYSICS ("Физика"),
    MEDICINE("Медицина"),
    LINGUISTICS ("Лингвистика"),
    MATHEMATICS ("Матемактика");



    private String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }
}
