package com.imooc.mvcdemo.dao.impl;

import com.imooc.mvcdemo.dao.StudentDao;
import com.imooc.mvcdemo.model.Student;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lzy on 06/07/17.
 */
@Repository
public class StudentDaoImpl implements StudentDao {

    @Resource
    SqlSessionFactory sqlSessionFactory;

    /**
     * 查询数据
     */

    @Override
    public List<Student> searchAll(Student student) {
        return sqlSessionFactory.openSession().selectList("",student);
    }

    @Override
    public Student queryOne(String id) {
        return sqlSessionFactory.openSession().selectOne(id);
    }

    @Override
    public void deleteOne(String id) {
        sqlSessionFactory.openSession().delete(id);

    }

    @Override
    public void deleteBatch(List<Integer> ids) {
        sqlSessionFactory.openSession().delete("",ids);
    }

    @Override
    public void addOne(Student student) {
        sqlSessionFactory.openSession().insert("",student);
    }

    @Override
    public void updateOne(Student student) {
        sqlSessionFactory.openSession().update("", student);
    }
}
