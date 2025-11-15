package src.SchoolSystem.observer.subject;

import src.SchoolSystem.models.Grade;
import src.SchoolSystem.utils.GradeEventType;

public interface IPublisher {
    public void notify(Grade grade, GradeEventType type);
    
}
