package comparators;

import modelclass.Student;
import org.apache.commons.lang3.StringUtils;

public class CompareUniversityId implements StudentComparator{
    @Override
    public int compare(Student o1, Student o2) {
        return StringUtils.compare(o1.getUniversityId(), o2.getUniversityId());
    }
}
