package src.SchoolSystem.models;
import java.util.ArrayList;
import src.SchoolSystem.factory.IUser;
public class Teacher implements IUser{
    
    private final int id;
    private final String name;
    private final String subject;
    private final ArrayList<Student> students = new ArrayList<>();
    private int age;

    public Teacher(int id, String subject, String name, int age){
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.age = age;
    }
    @Override
    public int getId() { return id; }

    @Override
    public String getName() { return name; }

    @Override
    public String getRole() { return "Teacher"; }

    @Override
    public int getAge(){ return age; }

    public void setAge(int newAge){ this.age = newAge; }

    public String getSubject() { return subject; }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void deleteStudent(Student student){students.remove(student);}

    public ArrayList<Student> getStudents(){return students;}

}
