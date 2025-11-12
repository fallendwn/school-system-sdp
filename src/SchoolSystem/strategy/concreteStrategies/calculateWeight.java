package src.SchoolSystem.strategy.concreteStrategies;

import java.util.ArrayList;
import src.SchoolSystem.models.Grade;
import src.SchoolSystem.models.Student;
import src.SchoolSystem.strategy.istrategy.IStrategy;

public class calculateWeight implements IStrategy {

    @Override
    public void execute(Student student) {
        ArrayList<Grade> grades = student.getGrades();

        if (grades == null || grades.isEmpty()) {
            System.out.println("No grades for student: " + student.getName());
            return;
        }

        double totalWeighted = 0.0;

        for (Grade grade : grades) {
            double weight = grade.getWeight() / 100.0;
            totalWeighted += grade.getValue() * weight;
        }

        System.out.println("Grade taking into accoint weight: " + totalWeighted);

    }
}
