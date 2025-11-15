package src.SchoolSystem.decorator.decorators;

import src.SchoolSystem.decorator.interfaces.IGrade;

public class BehaviorDecorator extends BaseDecorator {
    private final int behaviorRate;

    public BehaviorDecorator(IGrade grade, int behaviorRate) {
        super(grade);
        this.behaviorRate = behaviorRate;
    }
    @Override
    public String toString() {
        return grade.toString() + " [Behavior: " + behaviorRate + "/10] ";
    }
}
