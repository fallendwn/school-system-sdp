package src.SchoolSystem.strategy.concreteStrategies;

import java.util.ArrayList;
import src.SchoolSystem.models.Grade;
import src.SchoolSystem.models.Student;
import src.SchoolSystem.strategy.IStrategy.IStrategy;

public class CalculateWeight implements IStrategy {

    @Override
    public void execute(Student student) {
        ArrayList<Grade> grades = student.getGrades();

        if (grades == null || grades.isEmpty()) {
            System.out.println("No grades for student: " + student.getName());
            return;
        }

        float totalWeighted = 0f;

        for (Grade grade : grades) {
            float weight = grade.getWeight() / 100f;
            totalWeighted += grade.getValue() * weight;
        }

        System.out.println("Grade taking into accoint weight: " + totalWeighted);

    }
}
