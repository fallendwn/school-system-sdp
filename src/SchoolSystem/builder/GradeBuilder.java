package src.SchoolSystem.builder;

import java.time.LocalDate;
import src.SchoolSystem.models.Grade;
import src.SchoolSystem.models.Student;
import src.SchoolSystem.models.Teacher;

public class GradeBuilder{
    public int id;
    public float value;
    public LocalDate date;
    public String subject;
    public Teacher teacher;
    public Student student;
    public String type;
    public int weight;


    public GradeBuilder setId(int id){
        this.id = id;
        return this;
    }


    public GradeBuilder setValue(float value){
        this.value = value;
        return this;
    }


    public GradeBuilder setDate(LocalDate date){
        this.date = date;
        return this;
    }


    public GradeBuilder setSubject(String subject){
        this.subject = subject;
        return this;        
    }


    public GradeBuilder setTeacher(Teacher teacher){
        this.teacher = teacher;
        return this;
    }


    public GradeBuilder setStudent(Student student){
        this.student = student;
        return this;
    }

    public GradeBuilder setType(String type){
        this.type = type;
        return this;
    }

    public GradeBuilder setWeight(int weight){
        this.weight = weight;
        return this;
    }

    public Grade build(){return new Grade(this);}
    


}
