package src.SchoolSystem.decorator.interfaces;

import java.time.LocalDate;
import src.SchoolSystem.models.Student;
import src.SchoolSystem.models.Teacher;

public interface IGrade {
    int getId();
    float getValue();
    LocalDate getDate();
    String getSubject();
    Teacher getTeacher();
    Student getStudent();
    float getWeight();
    String getType();
}
