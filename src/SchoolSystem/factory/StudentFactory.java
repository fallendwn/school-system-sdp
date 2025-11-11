package src.SchoolSystem.factory;

import src.SchoolSystem.models.Student;


public class StudentFactory {
    public Student createStudent(){
        return new Student();
    }
}
