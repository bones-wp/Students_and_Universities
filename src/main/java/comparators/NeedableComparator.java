package comparators;

import java.util.logging.Logger;

public class NeedableComparator {
    private NeedableComparator (){};

    public static final Logger comparatorLog = Logger.getLogger(NeedableComparator.class.getName());


    public static StudentComparator getStudentsCompare (EnumStudentsCompare enumStudentsCompare) {
        StudentComparator comparator = null;
        switch (enumStudentsCompare) {
            case FULLNAME -> {
                comparator = new CompareFullName ();
                comparatorLog.info("Произведена сортировка по полному имени студента");
            }
            case AVGeXAMsCORE -> {
                comparator = new CompareAvgExamScore();
                comparatorLog.info("Произведена сортировка по среднему баллу студента");
            }
            case UNIVERSITYiD -> {
                comparator = new CompareUniversityId();
                comparatorLog.info("Произведена сортировка по университету студента");
            }
            case CURRENTCOURSENAME -> {
                comparator = new CompareCurrentCourseName();
                comparatorLog.info("Произведена сортировка по курсу студента");
            }
        }
        return comparator;
    }

    public static UniversityComparator getUniversityCompare (EnumUniversityCompare enumUniversityCompare){
        UniversityComparator comparator = null;
        switch (enumUniversityCompare){
            case FULLNAME -> {
                comparator = new CompareFullNameUniverse();
                comparatorLog.info("Произведена сортировка по полному названию университета");
            }
            case ID -> {
                comparator = new CompareId();
                comparatorLog.info("Произведена сортировка по ID университета");
            }
            case SHORTNAME -> {
                comparator = new CompareShortNameUniverse();
                comparatorLog.info("Произведена сортировка по сокращённому названию университета");
            }
            case MAINPROFILE -> {
                comparator = new CompareMainProfile();
                comparatorLog.info("Произведена сортировка по профилю университета");
            }
            case YEARofFOUNDATION -> {
                comparator = new CompareYearOfFaundation();
                comparatorLog.info("Произведена сортировка по году основания университета");
            }
        }
        return comparator;
    }
}
