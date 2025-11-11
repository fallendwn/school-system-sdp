package src.SchoolSystem.factory;

import src.SchoolSystem.models.Student;
import src.SchoolSystem.models.Teacher;

public class UserFactory {
    public IUser createUser(String role, int id, int age, String name, String extraInfo){
        role = role.toLowerCase().strip();
        switch(role){

            case "student" -> {
                return new Student(id, name, Integer.parseInt(extraInfo), age);
            }

            case "teacher" -> {
                return new Teacher(id, name, extraInfo, age);
            }

            default -> throw new IllegalArgumentException("Unknown user role: " + role);

        }

    }
}
