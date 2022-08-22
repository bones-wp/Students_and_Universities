package modelclass;

import com.google.gson.annotations.SerializedName;
import jakarta.xml.bind.annotation.*;

@XmlType(propOrder = {"id", "fullName", "mainProfile"})
public class University {
    @SerializedName("Идентификатор Университета")
    private String id;

    @SerializedName("Полное название")
    private String fullName;

    @SerializedName("Сокращённое название")
    private String shortName;

    @SerializedName("Год основания")
    private int yearOfFoundation;

    @SerializedName("Профиль")
    StudyProfile mainProfile;

    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }

    @Override
    public String toString() {
        return "\n" + "Университет: " + "\n" +
                "ID Университета:'" + id + '\'' +
                ", полное название:'" + fullName + '\'' +
                ", сокращённое название:'" + shortName + '\'' +
                ", год основания:" + yearOfFoundation +
                ", профиль: " + mainProfile;
    }

    @XmlElement(name = "universityId")
    public String getId() {
        return id;
    }

    public University setId(String id) {
        this.id = id;
        return this;
    }

    @XmlElement(name = "universityName")
    public String getFullName() {
        return fullName;
    }

    public University setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    @XmlTransient
    public String getShortName() {
        return shortName;
    }

    public University setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    @XmlTransient
    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public University setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
        return this;
    }

    @XmlElement(name = "universityProfile")
    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public University setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
        return this;
    }
}
