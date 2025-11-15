package src.SchoolSystem;

import java.time.LocalDate;

import src.SchoolSystem.decorator.decorators.BehaviorDecorator;
import src.SchoolSystem.decorator.decorators.CommentDecorator;
import src.SchoolSystem.decorator.interfaces.IGrade;
import src.SchoolSystem.facade.SchoolFacade;
import src.SchoolSystem.models.Grade;
import src.SchoolSystem.models.Student;
import src.SchoolSystem.models.Teacher;

public class Main {
    public static void main(String[] args) {
        SchoolFacade facade = new SchoolFacade();

        // add teachers and students
        Teacher teacherYevgeniy = facade.addTeacher("Yevgeniy", 40, "Math");
        Student studentArlan = facade.addStudent(teacherYevgeniy.getId(), "Arlan", 15, 10);
        Student studentDenis = facade.addStudent(teacherYevgeniy.getId(), "Denis", 16, 11);

        // add grades
        Grade grade1 = facade.addGrade(teacherYevgeniy.getId(), studentArlan.getId(), 95f, 40, "Exam", teacherYevgeniy.getSubject(), LocalDate.now());
        Grade grade2 = facade.addGrade(teacherYevgeniy.getId(), studentArlan.getId(), 80f, 60, "Homework", teacherYevgeniy.getSubject(), LocalDate.now());

        // show all students
        System.out.println("Students for teacher " + teacherYevgeniy.getName() + ":");
        for (Student s : facade.getStudents(teacherYevgeniy.getId())) {
            System.out.println(s);
        }

        // change student strategy by name and execute
        facade.setStudentStrategyByName(studentArlan.getId(), "weight");
        studentArlan.executeStrategy(studentArlan);

        // decorator
        IGrade behaviorGrade = new BehaviorDecorator(
                new CommentDecorator(grade1, "Good job"), 10);
        System.out.println(behaviorGrade);

        // delete a grade
        boolean removed = facade.deleteGrade(studentArlan.getId(), grade2.getId());
        System.out.println("Grade (id=" + grade2.getId() + ") deleted: " + removed);

        // change grade g1
        facade.changeGrade(studentArlan.getId(), grade1.getId(), 98f, 40, "Exam", teacherYevgeniy.getSubject(), LocalDate.now(), teacherYevgeniy.getId());
        System.out.println("Grades after change for " + studentArlan.getName() + ":");
        for (Grade g : facade.getStudentGrades(studentArlan.getId())){
            System.out.println(g);
        }

        // show notifications now
        studentArlan.showNotifications();

        // delete student
        boolean sRemoved = facade.removeStudent(teacherYevgeniy.getId(), studentDenis.getId());
        System.out.println("Student " + studentDenis.getName() +  " deleted: " + sRemoved);
    }
}
