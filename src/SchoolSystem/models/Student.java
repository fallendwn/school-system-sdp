package src.SchoolSystem.models;

import java.util.ArrayList;
import java.util.List;

import src.SchoolSystem.factory.IUser;
import src.SchoolSystem.observer.observer.IObserver;
import src.SchoolSystem.strategy.istrategy.IStrategy;

public class Student implements IUser,IObserver {


    private int id;
    private String name;
    private final ArrayList<Grade> grades = new ArrayList<>();
    private int gradeLevel;
    private int age;
    private IStrategy strategy;



    public void setName(String name){

        this.name = name;

    }

    public void setId(int id){

        this.id = id;

    }

    @Override
    public int getId() { return id; }

    @Override
    public String getName() { return name; }

    @Override
    public String getRole() { return "Student"; }

    @Override
    public int getAge(){ return age; }

    public ArrayList<Grade> getGrades(){return grades;}

    public void setAge(int newAge){ this.age = newAge;}

    public void setGradeLevel(int gradeLevel){this.gradeLevel = gradeLevel;}

    public int getGradeLevel(){return gradeLevel;}

    public void setStrategy(IStrategy strategy){this.strategy=strategy;}

    public void returnGrade(Student student){strategy.execute(student);}

    private final List<String> notifications = new ArrayList<>();
    
    @Override
     public void update(Grade grade) {
        String message = String.format(
                "You have received a new grade: %.1f for subject %s (type: %s, weight: %.0f%%)",
                grade.getValue(), grade.getSubject(), grade.getType(), grade.getWeight()
        );

        notifications.add(message);
        // System.out.println(name + ", " + message);
    }

    public void showNotifications() {
        if (notifications.isEmpty()) {
            System.out.println(name + " has no new notifications.");
            return;
        }
        System.out.println(" Notifications for " + name + ":");
        for (String message : notifications) {
            System.out.println(" - " + message);
        }
    }

}
    
