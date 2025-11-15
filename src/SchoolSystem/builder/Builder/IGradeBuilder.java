package src.SchoolSystem.builder.Builder;

import java.time.LocalDate;

import src.SchoolSystem.models.Grade;
import src.SchoolSystem.models.Student;
import src.SchoolSystem.models.Teacher;


public interface IGradeBuilder {
    
    
    public IGradeBuilder setId(int id);

    public IGradeBuilder setValue(float value);

    public IGradeBuilder setDate(LocalDate date);

    public IGradeBuilder setSubject(String subject);

    public IGradeBuilder setTeacher(Teacher teacher);

    public IGradeBuilder setStudent(Student student);

    public IGradeBuilder setType(String type);

    public IGradeBuilder setWeight(int weight);

    public Grade build();
    


}
