package JAXB;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import modelclass.Statistics;
import modelclass.Student;
import modelclass.University;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "root")
public class Info {

    @XmlElementWrapper(name="StudentsInfo")
    @XmlElement(name="studentEntry")
    public static List<Student> students = new ArrayList<>();

    @XmlElementWrapper(name="universitiesInfo")
    @XmlElement(name="universityEntry")
    public static List<University> universities = new ArrayList<>();

    @XmlElementWrapper(name="statisticalInfo")
    @XmlElement(name="statisticsEntry")
    public static List<Statistics> statistics = new ArrayList<>();


}
