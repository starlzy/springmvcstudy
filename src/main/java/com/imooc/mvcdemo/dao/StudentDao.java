package com.imooc.mvcdemo.dao;

import com.imooc.mvcdemo.model.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by lzy on 02/07/17.
 */
public interface StudentDao {
   public List<Student> searchAll(Student student);

    public Student queryOne(String id);
    public void deleteOne(String id);

    public void deleteBatch(List<Integer> ids);

    public void addOne(Student student);

    public void updateOne(Student student);
}
