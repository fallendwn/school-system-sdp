package src.SchoolSystem;

import java.time.LocalDate;

import src.SchoolSystem.builder.GradeBuilder;
import src.SchoolSystem.decorator.decorators.BehaviorDecorator;
import src.SchoolSystem.decorator.decorators.CommentDecorator;
import src.SchoolSystem.decorator.interfaces.IGrade;
import src.SchoolSystem.models.Grade;
import src.SchoolSystem.models.Student;
import src.SchoolSystem.models.Teacher;

public class Main {
    public static void main(String[] args) {
        Student student = new Student(100, "student0", 0, 11);
        Teacher teacher = new Teacher(1, "math", "teacher1", 31);

        // 1. Создаём базовую оценку через билдера
        Grade grade = new GradeBuilder()
                .setId(0)
                .setValue(95f)
                .setDate(LocalDate.of(2025, 6, 10))
                .setSubject("Math")
                .setTeacher(teacher)
                .setStudent(student)
                .setType("Exam")
                .setWeight(40)
                .build();
        IGrade behaviorGrade = new BehaviorDecorator(
                                    new CommentDecorator(grade, "Good job"), 10);
        System.out.println(behaviorGrade);
    }
}
