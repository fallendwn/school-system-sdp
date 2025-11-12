package src.SchoolSystem.decorator.decorators;

import src.SchoolSystem.decorator.interfaces.IGrade;

public class BehaviorDecorator extends BaseDecorator {
    private int behaviorRate;

    public BehaviorDecorator(IGrade grade, int behaviorRate) {
        super(grade);
        this.behaviorRate = behaviorRate;
    }

    public String toString() {
        return grade.toString() + " [Behavior: " + behaviorRate + "/10] ";
    }
}
