package models;

import java.util.ArrayList;
import java.util.List;

public class Teacher implements Entity{
    private String code;
    private String name;
    private List<Subject> subjectList;

    public Teacher(String name) {
        this.code = "TE" + (int)(Math.random() * 100 + 1) + name;
        this.name = name;
    }

    public Teacher(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public void addSubject(Subject sub) {
        if (this.subjectList == null) {
            this.subjectList = new ArrayList<>();
        }

        this.subjectList.add(sub);
    }

    public String getName() {
        return name;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", subjectList=" + subjectList +
                '}';
    }
}
