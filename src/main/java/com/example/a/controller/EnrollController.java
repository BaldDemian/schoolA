package com.example.a.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.a.mapper.EnrollMapper;
import com.example.a.pojo.Enroll;
import com.example.a.pojo.Student;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnrollController {
    XStream xStream = new XStream(new StaxDriver());
    @Autowired
    private EnrollMapper enrollMapper;

    @GetMapping("/courses_selection")
    public String getAllCoursesSelectionTable(){
        xStream.processAnnotations(Enroll.class);
        return xStream.toXML(enrollMapper.selectList(null)); // 返回全部课程
    }

    @GetMapping("/courses_selection/add")
    public void addCoursesSelectionTable(@RequestParam String courses_selectionXml){
        System.out.println("frontend return: " + courses_selectionXml);
        xStream.processAnnotations(Enroll.class);
        Enroll enroll = (Enroll) xStream.fromXML(courses_selectionXml);
        enrollMapper.insert(enroll);
    }

    @PostMapping("/courses_selection/delete")
    public void deleteCoursesSelectionTable(@RequestBody String courses_selectionXml){
        xStream.processAnnotations(Enroll.class);
        Enroll enroll = (Enroll) xStream.fromXML(courses_selectionXml);
        enrollMapper.deleteByCnoAndSno(enroll.getCno(), enroll.getSno());
    }

    @PostMapping("/courses_selection/update")
    public void updateCoursesSelectionTable(@RequestBody String courses_selectionXml){
        xStream.processAnnotations(Enroll.class);
        Enroll enroll = (Enroll) xStream.fromXML(courses_selectionXml);
        enrollMapper.updateById(enroll);
    }

    @PostMapping("/courses_selection/find_by_sno")
    public String findEnrollBySno(@RequestParam String studentXML) {
        xStream.processAnnotations(Student.class);
        Student student = (Student) xStream.fromXML(studentXML);
        QueryWrapper<Enroll> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("学生编号", student.getSno());
        List<Enroll> enrollList = enrollMapper.selectList(queryWrapper);
        return xStream.toXML(enrollList);
    }
}
