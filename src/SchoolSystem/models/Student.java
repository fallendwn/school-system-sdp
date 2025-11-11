package src.SchoolSystem.models;

import java.util.ArrayList;
import src.SchoolSystem.factory.IUser;

public class Student implements IUser {
    private int id;
    private String name;
    private final ArrayList<Grade> grades = new ArrayList<>();
    private int gradeLevel;
    private int age;

    public Student(int id, String name, int gradeLevel, int age) {
        this.id = id;
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.age = age;
    }

    // Getters
    @Override public int getId() { return id; }
    @Override public String getName() { return name; }
    @Override public String getRole() { return "Student"; }
    @Override public int getAge(){ return age; }
    public int getGradeLevel(){return gradeLevel;}

    // Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setGradeLevel(int gradeLevel) { this.gradeLevel = gradeLevel; }
    public void setAge(int newAge) { this.age = newAge; }

    // Grade management
    public ArrayList<Grade> getGrades(){return grades;}
    public void addGrade(Grade grade){grades.add(grade);}
    public void changeGrade(Grade grade){}

}
    
