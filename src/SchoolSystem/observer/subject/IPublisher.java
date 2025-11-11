package src.SchoolSystem.observer.subject;

import src.SchoolSystem.models.Grade;
import src.SchoolSystem.models.Student;

public interface IPublisher {
    public void attach(Student student);
    public void detach(Student student);
    public void notify(Grade grade);
    
}
