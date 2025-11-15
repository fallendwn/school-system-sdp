package src.SchoolSystem.utils;

public class Messages {

    public static class FacadeMessages{

        public static final String STUDENT_NOT_FOUND = "Student not found: "; 
        public static final String UNKNOWN_STRATEGY = "Unknown strategy: ";

    }

    public static class StudentMessages{

        public static final String UPDATE_MESSAGE = "You have received a new grade: %.1f for subject %s (type: %s, weight: %.0f%%)";
        public static final String NO_NEW_NOTIFICATIONS = " has no new notifications.";
        public static final String NOTIFICATIONS_FOR = " Notifications for ";
        public static final String CHANGED_GRADE = "You have changed a grade: %.1f for subject %s (type: %s, weight: %.0f%%)";
    }

    public static class TeacherMessages{

        public static final String GIVE_GRADE = "Teacher %s gave %.1f (%s) to %s in %s%n";

    }

    public static class StrategyMessages{

        public static final String NO_GRADES = "No grades for student: ";
        public static final String AVERAGE_GRADE = "Average grade for ";
        public static final String GRADE_WEIGHT = "Grade taking into account weight: ";

    }

    

}
