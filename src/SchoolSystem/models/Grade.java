package src.SchoolSystem.models;

import java.time.LocalDate;
import src.SchoolSystem.builder.GradeBuilder;
import src.SchoolSystem.decorator.interfaces.IGrade;

public class Grade implements IGrade {
    private final int id;
    private final float value;
    private final LocalDate date;
    private final String subject;
    private final Teacher teacher;
    private final Student student;
    private final String type; // exam homework ? 
    private final double weight; // for weight strategy;

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
    
    @Override public int getId(){return this.id;}
    @Override public double getValue(){return this.value;}
    @Override public LocalDate getDate(){return this.date;}
    @Override public String getSubject(){return this.subject;}
    @Override public Teacher getTeacher(){return this.teacher;}
    @Override public Student getStudent(){return this.student;}
    @Override public String getType(){return this.type;}
    @Override public double getWeight(){return weight;}

    @Override
    public String toString() {
        return String.format("""
            ── Grade ───────────────────────────
            - ID: %d
            - Subject: %s
            - Value: %.2f  (Weight: %.2f)
            - Type: %s
            - Student: %s
            - Teacher: %s
            - Date: %s
            ────────────────────────────────────
            """, id, subject, value, weight, type, 
            student.getName(), teacher.getName(), date);
    }
}
