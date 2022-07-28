import comparators.*;

public class NeedableComparator {
    private NeedableComparator (){};

    public static StudentComparator getStudentsCompare (EnumStudentsCompare enumStudentsCompare) {
        StudentComparator comparator = null;
        switch (enumStudentsCompare) {
            case FULLNAME -> {
                comparator = new CompareFullName ();
            }
            case AVGeXAMsCORE -> {
                comparator = new CompareAvgExamScore();
            }
            case UNIVERSITYiD -> {
                comparator = new CompareUniversityId();
            }
            case CURRENTCOURSENAME -> {
                comparator = new CompareCurrentCourseName();
            }
        }
        return comparator;
    }

    public static UniversityComparator getUniversityCompare (EnumUniversityCompare enumUniversityCompare){
        UniversityComparator comparator = null;
        switch (enumUniversityCompare){
            case FULLNAME -> {
                comparator = new CompareFullNameUniverse();
            }
            case ID -> {
                comparator = new CompareId();
            }
            case SHORTNAME -> {
                comparator = new CompareShortNameUniverse();
            }
            case MAINPROFILE -> {
                comparator = new CompareMainProfile();
            }
            case YEARofFOUNDATION -> {
                comparator = new CompareYearOfFaundation();
            }
        }
        return comparator;
    }
}
