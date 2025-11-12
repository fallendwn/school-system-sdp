package src.SchoolSystem.factory;

import src.SchoolSystem.models.Teacher;

public class TeacherFactory implements IUserFactory {
    @Override
    public Teacher create(int id, String name, int age, Object... extraInformation){
        String subject = (String) extraInformation[0];
        return new Teacher(id, name, subject, age);
    }
}
