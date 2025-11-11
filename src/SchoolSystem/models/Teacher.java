package src.SchoolSystem.models;
import java.util.ArrayList;
import src.SchoolSystem.factory.IUser;
public class Teacher implements IUser{
    
    private int id;
    private String name;
    private String subject;
    private final ArrayList<Student> students = new ArrayList<>();
    private int age;

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

    public void setName(String name){

        this.name = name;

    }

    public void setId(int id){

        this.id = id;

    }

    public void setSubject(String subject){

        this.subject = subject;

    }


    public void deleteStudent(Student student){students.remove(student);}

    public ArrayList<Student> getStudents(){return students;}

}
