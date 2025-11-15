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
        Teacher t1 = facade.addTeacher("Yevgeniy", 40, "Math");
        Student s1 = facade.addStudent(t1.getId(), "Arlan", 15, 10);
        Student s2 = facade.addStudent(t1.getId(), "Denis", 16, 11);

        // add grades
        Grade g1 = facade.addGrade(t1.getId(), s1.getId(), 95f, 40, "Exam", t1.getSubject(), LocalDate.now());
        Grade g2 = facade.addGrade(t1.getId(), s1.getId(), 80f, 60, "Homework", t1.getSubject(), LocalDate.now());

        // show all students
        System.out.println("Students for teacher " + t1.getName() + ":");
        for (Student s : facade.getStudents(t1.getId())) {
            System.out.println(s);
        }

        // change student strategy by name and execute
        facade.setStudentStrategyByName(s1.getId(), "avg");
        s1.executeStrategy(s1);

        // decorator
        IGrade behaviorGrade = new BehaviorDecorator(
                new CommentDecorator(g1, "Good job"), 10);
        System.out.println(behaviorGrade);

        // delete a grade
        boolean removed = facade.deleteGrade(s1.getId(), g2.getId());
        System.out.println("Grade (id=" + g2.getId() + ") deleted: " + removed);

        // change grade g1
        facade.changeGrade(s1.getId(), g1.getId(), 98f, 40, "Exam", t1.getSubject(), LocalDate.now(), t1.getId());
        System.out.println("Grades after change for " + s1.getName() + ":");
        for (Grade g : facade.getStudentGrades(s1.getId())){
            System.out.println(g);
        }

        // show notifications now
        s1.showNotifications();

        // delete student
        boolean sRemoved = facade.removeStudent(t1.getId(), s2.getId());
        System.out.println("Student " + s2.getName() +  " deleted: " + sRemoved);
    }
}
