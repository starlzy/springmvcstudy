package com.letv.bigdata.Chapter1.springtest;

import com.imooc.mvcdemo.model.Student;
import com.imooc.mvcdemo.service.student.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
/**
 * Created by lzy on 24/06/17.
 */

@RunWith(BlockJUnit4ClassRunner.class)
public class TestStudent extends UnitTestBase {
    public TestStudent(){
        super("classpath:springConfig/application-*.xml");
    }

    @Test
    public void testSetter(){
        StudentService service = super.getBean("studentServiceImpl");
        service.getStudentById("12");
    }

    @Test
    public void testSearch() {
        StudentService service = super.getBean("studentServiceImpl");
        service.getStudentAll();

    }

    @Test
    public void testInsert() {
        Student student = new Student();
        student.setId("10");
        student.setScore(88);
        student.setCourse("数据");
        student.setName("不知火舞");
        StudentService service = super.getBean("studentServiceImpl");
      //  service.addStudent(student);
        service.updateOne(student);
    }

}
