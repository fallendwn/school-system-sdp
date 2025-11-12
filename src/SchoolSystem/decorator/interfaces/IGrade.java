package src.SchoolSystem.decorator.interfaces;

import java.time.LocalDate;

import src.SchoolSystem.models.Student;
import src.SchoolSystem.models.Teacher;

public interface IGrade {
    int getId();
    double getValue();
    LocalDate getDate();
    String getSubject();
    Teacher getTeacher();
    Student getStudent();
    double getWeight();
    String getType();
    String toString();
}
