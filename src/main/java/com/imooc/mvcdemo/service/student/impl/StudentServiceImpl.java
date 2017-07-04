package com.imooc.mvcdemo.service.student.impl;

import com.imooc.mvcdemo.dao.MessageInterface;
import com.imooc.mvcdemo.model.Student;
import com.imooc.mvcdemo.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzy on 02/07/17.
 */
@Service("StudentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private MessageInterface messageDao;

    public void setMessageDao(MessageInterface messageDao) {
        this.messageDao = messageDao;
    }

    List<Student> list = new ArrayList<Student>();

    public List<Student> getStudentById(Integer id) {
        list = messageDao.queryMessageList(id.toString(), "", "");
        return list;
    }

    public List<Student> getStudentAll() {
        list = messageDao.queryMessageList("", "", "");
        return list;
    }

    public void addStudent(Student student) {
        String name = student.getName();
        String course = student.getCourse();
        int score = student.getScore();
        messageDao.addOne(name, course, score);
    }

    public void deleteOne(String id) {
        messageDao.deleteOne(Integer.valueOf(id));
    }

    public void updateOne(Student student) {
        String id = student.getId();
        String name = student.getName();
        String course = student.getCourse();
        int score = student.getScore();
        messageDao.updateOne(id, name, course, score);
    }
}
