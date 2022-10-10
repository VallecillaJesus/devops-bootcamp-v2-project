package repositories;

import models.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class TeacherRepository implements Repository<Teacher> {

    private List<Teacher> teachers= new ArrayList<>();
    private static TeacherRepository teacherRepository;

    public static TeacherRepository getInstance(){
        if(Objects.isNull(teacherRepository)){
            teacherRepository = new TeacherRepository();
        }
        return teacherRepository;
    }

    @Override
    public void save(Teacher teacher) {
        teachers.add(teacher);
    }

    @Override
    public List<Teacher> getAll() {
        return teachers;
    }

    @Override
    public Optional<Teacher> getByCode(String code) {;
        return teachers.stream().filter(teacher -> teacher.getCode().equals(code)).findAny();
    }

}
