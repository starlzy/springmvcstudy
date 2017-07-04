package com.imooc.mvcdemo.service.student;

import com.imooc.mvcdemo.model.Student;

import java.util.List;

/**
 * Created by lzy on 02/07/17.
 */
public interface StudentService {
    public List<Student> getStudentById(Integer id);

    public List<Student> getStudentAll();

    public void addStudent(Student student);

    public void deleteOne(String id);

    public void updateOne(Student student);
}
