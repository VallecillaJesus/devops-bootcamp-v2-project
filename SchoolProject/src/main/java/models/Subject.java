package models;

import models.enums.Grade;

public class Subject {
    private String name;
    private Grade grade;

    public Subject(String name, Grade grade) {
        this.name = name;
        this.grade = grade;
    }
}
