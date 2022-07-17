package modelclass;

public enum StudyProfile {

    YURISPRUDENCIYA ("Юриспруденция"),
    POLITOLOGIYA ("Политология"),
    FILOSOFIYA("Философия"),
    MEDICINE("Медицина"),
    AVIATION ("Авиация");



    private String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }
}
