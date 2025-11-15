package src.SchoolSystem.models;
import java.time.LocalDate;
import java.util.ArrayList;
import src.SchoolSystem.builder.ConcreteBuilder.GradeBuilder;
import src.SchoolSystem.factory.factory.IUser;
import src.SchoolSystem.observer.subject.IPublisher;
import src.SchoolSystem.utils.Messages.TeacherMessages;
public class Teacher implements IUser, IPublisher{
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

    public void giveGrade(Student student, int id,float value, int weight, String type) {
        Grade grade = new GradeBuilder()
                .setId(id)
                .setValue(value)
                .setDate(LocalDate.now()) 
                .setSubject(this.subject)
                .setTeacher(this)
                .setStudent(student)
                .setType(type)
                .setWeight(weight)
                .build();

        student.getGrades().add(grade);
        System.out.printf(TeacherMessages.GIVE_GRADE,
                name, value, type, student.getName(), subject);
        notify(grade); 
    }
    
    @Override
    public void notify(Grade grade) {
        for(Student student : students){
            if (student.getId() == grade.getStudent().getId()) {
                student.update(grade);
            }
        }
    }

    @Override
    public String toString() {
        return String.format("- %s (id=%d, age=%d, subject=%s)", name, id, age, subject);
    }
}
            
