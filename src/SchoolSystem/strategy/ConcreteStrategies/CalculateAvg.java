package src.SchoolSystem.strategy.ConcreteStrategies;

import java.util.ArrayList;
import src.SchoolSystem.models.Grade;
import src.SchoolSystem.models.Student;
import src.SchoolSystem.strategy.strategy.IStrategy;
import src.SchoolSystem.utils.Messages.StrategyMessages;

public class CalculateAvg implements IStrategy {

    @Override
    public void execute(Student student) {
        ArrayList<Grade> grades = student.getGrades();

        if (grades == null || grades.isEmpty()) {
            System.out.println(StrategyMessages.NO_GRADES + student.getName());
            return;
        }

        int totalGrade = 0;
        for(Grade grade : grades){
            totalGrade+=grade.getValue();
        }

        float average = totalGrade / grades.size();

        System.out.println(StrategyMessages.AVERAGE_GRADE + student.getName() + ": " + average);

    }
}
