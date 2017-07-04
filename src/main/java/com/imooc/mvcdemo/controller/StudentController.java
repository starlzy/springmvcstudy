package com.imooc.mvcdemo.controller;

import com.imooc.mvcdemo.model.Student;
import com.imooc.mvcdemo.service.student.StudentService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.misc.Request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lzy on 02/07/17.
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    private static Logger log = LoggerFactory.getLogger(StudentController.class);
    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    //根据id获取数据
    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    public String viewStudent(@PathVariable("id") Integer id, Map<String, Object> model) {
        log.info("in viewStudent,studentId={}", id);
        List<Student> studentList = studentService.getStudentById(id);
        model.put("student", studentList);
        return "feature_set_id";
    }

    //初始页面
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String ViewAllStudent(Map<String, Object> model) {
        return "feature_set_id";
    }
    //获取所有的数据
    @RequestMapping(value = "/searchAll", method = RequestMethod.POST)
    @ResponseBody
    public List<Student> ViewAllData() {
        List<Student> studentList = studentService.getStudentAll();
        return studentList;
    }

    /**
     * 添加一条记录
     */
    @RequestMapping(value = "/addOne", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> addOne(@RequestBody Student student) {
        Map<String, String> map = new HashMap<String, String>();
        studentService.addStudent(student);
        map.put("200", "success");
        return map;
    }

    //删除一条记录
    @RequestMapping(value = "deleteOne", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> deleteOne(@RequestBody String id) {

        Map<String,String> map = new HashMap<String, String>();
        studentService.deleteOne(id);
        map.put("200","success");
        return map;
    }

    @RequestMapping(value = "updateOne", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> updateOne(@RequestBody Student student){
        log.info("当前的id值是：" + student.getName());
        Map<String, String> map = new HashMap<String, String>();
        studentService.updateOne(student);
        map.put("200", "success");
        return map;
    }
}
