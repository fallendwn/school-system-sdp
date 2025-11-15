package src.SchoolSystem.decorator.decorators;

import src.SchoolSystem.decorator.interfaces.IGrade;

public class CommentDecorator extends BaseDecorator {
    private final String comment;

    public CommentDecorator(IGrade grade, String comment) {
        super(grade);
        this.comment = comment;
    }

    @Override
    public String toString() {
        return grade.toString() + " [Comment: " + comment + "] ";
    }
}
