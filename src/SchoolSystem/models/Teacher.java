package src.SchoolSystem.models;
import java.time.LocalDate;
import java.util.ArrayList;

import src.SchoolSystem.builder.GradeBuilder;
import src.SchoolSystem.factory.IUser;
import src.SchoolSystem.observer.subject.IPublisher;
public class Teacher implements IUser, IPublisher{
    
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

    public void giveGrade(Student student, float value, int weight, String type) {
        Grade grade = new GradeBuilder()
                .setId() // надо как то айдишку добавлять
                .setValue(value)
                .setDate()
                .setSubject(this.subject)
                .setTeacher(this)
                .setStudent(student)
                .setType(type)
                .setWeight(weight)
                .build();

        student.getGrades().add(grade);
        System.out.printf("Teacher %s gave %.1f (%s) to %s in %s%n",
                name, value, type, student.getName(), subject);

        notify(grade); 
    }


    @Override
    public void attach(Student student) { // делает то же самое что и addStudent надо что то придумать
        if(!students.contains(student)){
        students.add(student);
       }
    }

    @Override
    public void detach(Student student) {
        students.remove(student);
    }
    
    @Override
    public void notify(Grade grade) {
        for(Student student : students){
            if (student.getId() == grade.getStudent().getId()) {
                student.update(grade);
            }
        }
    }
}
            
