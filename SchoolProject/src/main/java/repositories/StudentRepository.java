package repositories;

import models.Student;
import models.enums.Grade;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class StudentRepository implements Repository<Student> {
    private List<Student> students = new ArrayList<>();
    private static StudentRepository studentRepository;

    public static StudentRepository getInstance(){
        if(Objects.isNull(studentRepository)){
            studentRepository = new StudentRepository();
        }
        return studentRepository;
    }

    @Override
    public void save(Student student) {
        if(Objects.nonNull(student.getCode()))
            students.remove(student);
        students.add(student);
    }

    @Override
    public List<Student> getAll() {
        return students;
    }

    @Override
    public Optional<Student> getByCode(String code) {
        return students.stream().filter(student -> student.getCode().equals(code)).findAny();
    }

    public List<Student> getByGrade(Grade grade){
        List<Student> coincidences = new ArrayList<>();
        students.forEach(student -> {
            if(student.getGrade().equals(grade))
                coincidences.add(student);
        });
        return coincidences;
    }
}
