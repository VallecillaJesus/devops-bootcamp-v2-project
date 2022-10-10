package models;

import models.enums.Grade;
import models.enums.Score;

public class Student implements Entity{
    private String code;
    private String name;
    private int age;
    private Grade grade;
    private Score score;

    public Student(String name, int age, Grade grade) {
        this.code = "ST" + (int)(Math.random() * 100 + 1) + name;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public Student(String code, String name, int age, Grade grade) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getScore() {
        return getScore();
    }

    @Override
    public String getCode() {
        return this.code;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                ", score=" + score +
                '}';
    }
}
