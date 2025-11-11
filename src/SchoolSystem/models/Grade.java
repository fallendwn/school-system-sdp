package src.SchoolSystem.models;

import java.time.LocalDate;
import src.SchoolSystem.builder.GradeBuilder;


public class Grade {
    private final int id;
    private final float value;
    private final LocalDate date;
    private final String subject;
    private final Teacher teacher;
    private final Student student;
    private final String type; // exam homework ? 
    private final double weight; // for weight strategy;
    private String comment; // for decorator initially it's empty

    public Grade(GradeBuilder builder){

        this.id =  builder.id;
        this.value = builder.value;
        this.date = builder.date;
        this.subject = builder.subject;
        this.teacher = builder.teacher;
        this.student = builder.student;
        this.type = builder.type;
        this.weight = builder.weight;

    }
    
    public int getId(){return this.id;}
    public double getValue(){return this.value;}
    public LocalDate getDate(){return this.date;}
    public String getSubject(){return this.subject;}
    public Teacher getTeacher(){return this.teacher;}
    public Student getStudent(){return this.student;}
    public double getWeight(){return weight;}
    public String getType(){return this.type;}
    public String getComment(){return comment;}



    public void setComment(String comment){this.comment = comment;}

    @Override
    public String toString() {
        return String.format("Grade[id=%d, subject=%s, value=%.1f, weight=%.2f, student=%s, teacher=%s, type=%s, comment=%s]",
                id, subject, value, weight, 
                student.getName(), teacher.getName(), type, comment);
    }
}
