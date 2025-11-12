package src.SchoolSystem.observer.subject;

import src.SchoolSystem.models.Grade;

public interface IPublisher {
    public void notify(Grade grade);
    
}
