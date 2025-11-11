package src.SchoolSystem.models;

import java.util.ArrayList;
import src.SchoolSystem.factory.IUser;

public class Teacher implements IUser {
    private int id;
    private String name;
    private String subject;
    private final ArrayList<Student> students = new ArrayList<>();
    private int age;

    public Teacher(int id, String name, String subject, int age) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.age = age;
    }

    // Getters
    @Override public int getId() { return id; }
    @Override public String getName() { return name; }
    @Override public String getRole() { return "Teacher"; }
    @Override public int getAge() { return age; }
    public String getSubject() { return subject; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAge(int newAge){ this.age = newAge; }
    public void setSubject(String subject) { this.subject = subject; }

    // Student management
    public ArrayList<Student> getStudents(){ return students; }
    public void addStudent(Student student) { students.add(student); }
    public void deleteStudent(Student student){ students.remove(student); }
}
