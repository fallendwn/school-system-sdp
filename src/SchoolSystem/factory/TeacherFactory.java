package src.SchoolSystem.factory;

import src.SchoolSystem.models.Teacher;

public class TeacherFactory implements IUserFactory {
    private String subject;

    public TeacherFactory(String subject) {
        this.subject = subject;
    }

    public Teacher create(int id, String name, int age){
        return new Teacher(id, name, subject, age);
    }
}
