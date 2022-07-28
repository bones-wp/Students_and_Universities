package comparators;

import modelclass.Student;

public class CompareCurrentCourseName implements StudentComparator{
    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getCurrentCourseNumber(), o2.getCurrentCourseNumber());
    }
}
