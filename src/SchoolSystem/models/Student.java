package src.SchoolSystem.models;

import java.util.ArrayList;
import src.SchoolSystem.factory.IUser;

public class Student implements IUser {


    private final int id;
    private final String name;
    private final ArrayList<Grade> grades = new ArrayList<>();
    private int gradeLevel;
    private int age;

    public Student(int gradeLevel, String name, int id, int age){

        this.id = id;
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.age = age;

    }
    @Override
    public int getId() { return id; }

    @Override
    public String getName() { return name; }

    @Override
    public String getRole() { return "Student"; }

    @Override
    public int getAge(){ return age; }

    public ArrayList<Grade> getGrades(){return grades;}

    public void setAge(int newAge){ this.age = newAge;}

    public void setGradeLevel(int gradeLevel){this.gradeLevel = gradeLevel;}

    public int getGradeLevel(){return gradeLevel;}

    public void addGrade(Grade grade){grades.add(grade);}

    public void changeGrade(Grade grade){}

}
    
