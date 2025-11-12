package src.SchoolSystem;

import java.time.LocalDate;

import src.SchoolSystem.builder.GradeBuilder;
import src.SchoolSystem.factory.IUserFactory;
import src.SchoolSystem.factory.StudentFactory;
import src.SchoolSystem.factory.TeacherFactory;
import src.SchoolSystem.models.Grade;
import src.SchoolSystem.models.Student;
import src.SchoolSystem.models.Teacher;

public class Main {
    public static void main(String[] args) {
        IUserFactory studentFactory = new StudentFactory();
        Student student = (Student) studentFactory.create(0, "student0", 11);

        IUserFactory mathTeacherFactory = new TeacherFactory("math");
        Teacher teacher = (Teacher) mathTeacherFactory.create(0, "teacher0", 31);

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
        // IGrade behaviorGrade = new BehaviorDecorator(
        //                             new CommentDecorator(grade, "Good job"), 10);
        // System.out.println(behaviorGrade);
    }
}
