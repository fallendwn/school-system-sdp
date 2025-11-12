package src.SchoolSystem.factory;

import src.SchoolSystem.models.Student;


public class StudentFactory implements IUserFactory {
    @Override
    public Student create(int id, String name, int age, Object... extraInformation){
        int gradeLevel = (int) extraInformation[0];
        return new Student(id, name, age, gradeLevel);
    }
}
