package com.imooc.mvcdemo.service.student.impl;

import com.imooc.mvcdemo.dao.StudentDao;
import com.imooc.mvcdemo.model.Student;
import com.imooc.mvcdemo.service.student.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lzy on 02/07/17.
 */
@Service
public class StudentServiceImpl implements StudentService {
    private static Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
    @Autowired
    private StudentDao studentDao;

    public Student getStudentById(String id) {

         return studentDao.queryOne(id);

    }
    public void deleteOne(String id) {
        studentDao.deleteOne(id);
    }

    public List<Student> getStudentAll() {

        Student student = new Student();
        return studentDao.searchAll(student);
    }

    public void addStudent(Student student) {
        studentDao.addOne(student);
    }

    public void updateOne(Student student) {
        studentDao.updateOne(student);
    }
}
