package src.SchoolSystem.builder.ConcreteBuilder;

import java.time.LocalDate;
import src.SchoolSystem.builder.Builder.IGradeBuilder;
import src.SchoolSystem.models.Grade;
import src.SchoolSystem.models.Student;
import src.SchoolSystem.models.Teacher;

public class GradeBuilder implements IGradeBuilder{
    public int id;
    public float value;
    public LocalDate date;
    public String subject;
    public Teacher teacher;
    public Student student;
    public String type;
    public int weight;

    @Override
    public GradeBuilder setId(int id){
        this.id = id;
        return this;
    }

    @Override
    public GradeBuilder setValue(float value){
        this.value = value;
        return this;
    }

    @Override
    public GradeBuilder setDate(LocalDate date){
        this.date = date;
        return this;
    }

    @Override
    public GradeBuilder setSubject(String subject){
        this.subject = subject;
        return this;        
    }

    @Override
    public GradeBuilder setTeacher(Teacher teacher){
        this.teacher = teacher;
        return this;
    }

    @Override
    public GradeBuilder setStudent(Student student){
        this.student = student;
        return this;
    }

    @Override
    public GradeBuilder setType(String type){
        this.type = type;
        return this;
    }
    @Override
    public GradeBuilder setWeight(int weight){
        this.weight = weight;
        return this;
    }
    
    @Override
    public Grade build(){return new Grade(this);}
    


}
