package com.imooc.mvcdemo.service.student;

import com.imooc.mvcdemo.model.Student;

import java.util.List;

/**
 * Created by lzy on 02/07/17.
 */
public interface StudentService {
    public Student getStudentById(String id);
    public void deleteOne(String id);

    public List<Student> getStudentAll();

    public void addStudent(Student student);

    public void updateOne(Student student);
}
