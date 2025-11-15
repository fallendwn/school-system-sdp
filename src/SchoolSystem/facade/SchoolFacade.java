package src.SchoolSystem.facade;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import src.SchoolSystem.builder.ConcreteBuilder.GradeBuilder;
import src.SchoolSystem.factory.ConcreteFactory.StudentFactory;
import src.SchoolSystem.factory.ConcreteFactory.TeacherFactory;
import src.SchoolSystem.models.Grade;
import src.SchoolSystem.models.Student;
import src.SchoolSystem.models.Teacher;
import src.SchoolSystem.strategy.IStrategy.IStrategy;
import src.SchoolSystem.strategy.concreteStrategies.CalculateAvg;
import src.SchoolSystem.strategy.concreteStrategies.CalculateWeight;
import src.SchoolSystem.utils.Messages.FacadeMessages;

public class SchoolFacade {

    private final List<Student> students = new ArrayList<>();
    private final List<Teacher> teachers = new ArrayList<>();
    private int nextUserId = 1;
    private int nextGradeId = 1;

    // Student operations
    public Student addStudent(int teacherId, String name, int age, int gradeLevel) {
        Teacher teacher = findTeacherById(teacherId);
        if (teacher == null) return null;
        StudentFactory sf = new StudentFactory();
        Student student = sf.create(nextUserId++, name, age, gradeLevel);
        teacher.addStudent(student);
        students.add(student);
        return student;
    }

    public boolean removeStudent(int teacherId, int studentId){
        Teacher teacher = findTeacherById(teacherId);
        Student student = findStudentById(studentId);
        if (teacher == null || student == null) return false;
        teacher.deleteStudent(student);
        students.remove(student);
        return true;
    }

    public List<Student> getStudents(int teacherId){
        Teacher teacher = findTeacherById(teacherId);
        if (teacher == null) return List.of();
        return List.copyOf(teacher.getStudents());
    }

    // Teacher operations
    public Teacher addTeacher(String name, int age, String subject) {
        TeacherFactory tf = new TeacherFactory();
        Teacher teacher = tf.create(nextUserId++, name, age, subject);
        teachers.add(teacher);
        return teacher;
    }

    public boolean deleteTeacher(int teacherId) {
        Teacher teacher = findTeacherById(teacherId);
        if (teacher == null) return false;
        for (Student student : teacher.getStudents()) {
            students.remove(student);
        }

        return teachers.remove(teacher);
    }

    // Grade operations
    public Grade addGrade(int teacherId, int studentId, float value, int weight, String type, String subject, LocalDate date){
        Teacher teacher = findTeacherById(teacherId);
        Student student = findStudentById(studentId);
        if (teacher == null || student == null) return null;

        Grade grade = new GradeBuilder()
                .setId(nextGradeId++)
                .setValue(value)
                .setDate(date != null ? date : LocalDate.now())
                .setSubject(subject != null ? subject : teacher.getSubject())
                .setTeacher(teacher)
                .setStudent(student)
                .setType(type)
                .setWeight(weight)
                .build();

        student.getGrades().add(grade);

        student.update(grade);
        teacher.notify(grade);

        return grade;
    }

    public boolean changeGrade(int studentId, int gradeId, float newValue, int newWeight, String newType, String newSubject, LocalDate newDate, int teacherId){
        Student student = findStudentById(studentId);
        Teacher teacher = findTeacherById(teacherId);
        if (student == null) return false;

        Grade newGrade = new GradeBuilder()
                .setId(gradeId)
                .setValue(newValue)
                .setDate(newDate != null ? newDate : LocalDate.now())
                .setSubject(newSubject != null ? newSubject : (teacher != null ? teacher.getSubject() : null))
                .setTeacher(teacher != null ? teacher : (student.getGrades().isEmpty() ? null : student.getGrades().get(0).getTeacher()))
                .setStudent(student)
                .setType(newType)
                .setWeight(newWeight)
                .build();

        student.changeGrade(newGrade);

        student.update(newGrade);
        return true;
    }

    public boolean deleteGrade(int studentId, int gradeId){
        Student student = findStudentById(studentId);
        if (student == null) return false;
        return student.getGrades().removeIf(g -> g.getId() == gradeId);
    }

    public List<Grade> getStudentGrades(int studentId){
        Student student = findStudentById(studentId);
        if (student == null) return List.of();
        return List.copyOf(student.getGrades());
    }

    public void setStudentStrategy(int studentId, IStrategy strategy){
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println(FacadeMessages.STUDENT_NOT_FOUND + studentId);
            return;
        }
        student.setStrategy(strategy);
    }

    public void setStudentStrategyByName(int studentId, String name){
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println(FacadeMessages.STUDENT_NOT_FOUND + studentId);
            return;
        }
        switch(name.toLowerCase().strip()){
            case "avg", "average" -> student.setStrategy(new CalculateAvg());
            case "weighted", "weight" -> student.setStrategy(new CalculateWeight());
            default -> System.out.println(FacadeMessages.UNKNOWN_STRATEGY + name);
        }
    }

    // Calculation
    public void calculateGradeStrategy(int studentId) {
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println(FacadeMessages.STUDENT_NOT_FOUND + studentId);
            return;
        }
        student.executeStrategy(student);
    }

    // helpers
    private Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) return student;
        }
        return null;
    }

    private Teacher findTeacherById(int id) {
        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) return teacher;
        }
        return null;
    }
}
