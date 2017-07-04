package com.imooc.mvcdemo.dao.impl;

import com.imooc.mvcdemo.dao.MessageInterface;
import com.imooc.mvcdemo.db.impl.DBAccess;
import com.imooc.mvcdemo.model.Student;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzy on 01/07/17.
 */
@Repository
public class MessageDao implements MessageInterface {
    /**
     * 查询数据
     */
    public List<Student> queryMessageList(String id, String name, String course) {
        DBAccess dbAccess = new DBAccess();
        List<Student> messageList = new ArrayList<Student>();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            Student student = new Student();
            student.setId(id);
            student.setName(name);
            student.setCourse(course);
            //通过sqlSession执行sql语句
            messageList = sqlSession.selectList("Student.queryMessageList", student);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return messageList;
    }

    /**
     * 单条删除
     */
    public void deleteOne(int id) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            //通过sqlSession执行sql语句
            sqlSession.delete("Student.deleteOne", id);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            sqlSession.delete("Student.deleteBatch", ids);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 添加一条记录
     */
    public void addOne(String name, String course, int score) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            Student student = new Student();
            student.setName(name);
            student.setCourse(course);
            student.setScore(score);
            sqlSession = dbAccess.getSqlSession();
            sqlSession.insert("Student.addOne", student);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    //修改记录
    public void updateOne(String id, String name, String course, int score) {
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            Student student = new Student();
            student.setId(id);
            student.setName(name);
            student.setCourse(course);
            student.setScore(score);
            sqlSession = dbAccess.getSqlSession();
            sqlSession.update("Student.updateOne", student);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public static void main(String args[]) {
        List<Student> list = new ArrayList<Student>();
        MessageDao messageDao = new MessageDao();
        List<Integer> index = new ArrayList<Integer>();
        index.add(1);
        index.add(2);
        //   messageDao.addOne("张三","英语",77);
        //  messageDao.deleteOne(5);
        list = messageDao.queryMessageList("", "", "");
        for (Student lists : list) {
            System.out.println(lists.getId() + "," + lists.getName() + "," + lists.getCourse() + "," + lists.getScore());
        }
    }
}
