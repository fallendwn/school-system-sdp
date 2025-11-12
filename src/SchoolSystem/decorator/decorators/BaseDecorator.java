package src.SchoolSystem.decorator.decorators;

import java.time.LocalDate;

import src.SchoolSystem.decorator.interfaces.IGrade;
import src.SchoolSystem.models.Student;
import src.SchoolSystem.models.Teacher;

public class BaseDecorator implements IGrade {
    protected IGrade grade;

    public BaseDecorator(IGrade grade) {
        this.grade = grade;
    }

    @Override public int getId() { return grade.getId(); }
    @Override public double getValue() { return grade.getValue(); }
    @Override public LocalDate getDate() { return grade.getDate(); }
    @Override public String getSubject() { return grade.getSubject(); }
    @Override public double getWeight() { return grade.getWeight(); }
    @Override public Teacher getTeacher() { return grade.getTeacher(); }
    @Override public Student getStudent() { return grade.getStudent(); }

    @Override
    public String toString() {
        return grade.toString();
    }
}
