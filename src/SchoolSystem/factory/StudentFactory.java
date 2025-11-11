package src.SchoolSystem.factory;

import src.SchoolSystem.models.Student;


public class StudentFactory implements IUserFactory {
    public Student create(int id, String name, int age){
        return new Student(id, name, calculateGradeLevel(age), age);
    }

    private int calculateGradeLevel(int age) {
        if (age < 7) return 0;
        if (age <= 7) return 1;
        if (age <= 8) return 2;
        if (age <= 9) return 3;
        if (age <= 10) return 4;
        if (age <= 11) return 5;
        if (age <= 12) return 6;
        if (age <= 13) return 7;
        if (age <= 14) return 8;
        if (age <= 15) return 9;
        if (age <= 16) return 10;
        if (age <= 17) return 11;
        if (age <= 18) return 12;
        return 13; // graduated
    }
}
