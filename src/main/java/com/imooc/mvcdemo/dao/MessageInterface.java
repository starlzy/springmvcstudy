package com.imooc.mvcdemo.dao;

import com.imooc.mvcdemo.model.Student;

import java.util.List;

/**
 * Created by lzy on 02/07/17.
 */
public interface MessageInterface {
    public List<Student> queryMessageList(String id, String name, String course);

    public void deleteOne(int id);

    public void deleteBatch(List<Integer> ids);

    public void addOne(String name, String course, int score);

    public void updateOne(String id, String name, String course, int score);
}
