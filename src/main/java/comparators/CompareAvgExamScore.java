package comparators;

import modelclass.Student;

public class CompareAvgExamScore implements StudentComparator{
    @Override
    public int compare(Student o1, Student o2) {
        return Float.compare(o1.getAvgExamScore(), o2.getAvgExamScore());
    }
}
