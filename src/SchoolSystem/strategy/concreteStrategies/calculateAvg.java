package src.SchoolSystem.strategy.concreteStrategies;

import java.util.ArrayList;
import src.SchoolSystem.models.Grade;
import src.SchoolSystem.models.Student;
import src.SchoolSystem.strategy.istrategy.IStrategy;

public class CalculateAvg implements IStrategy {

    @Override
    public void execute(Student student) {
        ArrayList<Grade> grades = student.getGrades();

        if (grades == null || grades.isEmpty()) {
            System.out.println("No grades for student: " + student.getName());
            return;
        }

        int totalGrade = 0;
        for(Grade grade : grades){
            totalGrade+=grade.getValue();
        }

        float average = totalGrade / grades.size();

        System.out.println("Average grade for " + student.getName() + ": " + average);

    }
}
