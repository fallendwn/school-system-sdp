package src.SchoolSystem.observer.observer;

import src.SchoolSystem.models.Grade;
import src.SchoolSystem.utils.GradeEventType;

public interface IObserver {
    public void update(Grade grade, GradeEventType type);
}