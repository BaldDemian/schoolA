package com.example.a.controller;

import com.example.a.mapper.CourseMapper;
import com.example.a.pojo.Course;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    XStream xStream = new XStream(new StaxDriver());

    @Autowired
    private CourseMapper courseMapper;

    @GetMapping("/courses")
    public String getAllCourses(){
        xStream.processAnnotations(Course.class);
        return xStream.toXML(courseMapper.selectList(null));
    }

    @GetMapping("/courses/add")
    public void addCourse(@RequestParam String courseXml){
        xStream.processAnnotations(Course.class);
        Course course = (Course) xStream.fromXML(courseXml);
        courseMapper.insert(course);
    }

    @GetMapping("/courses/delete")
    public void deleteCourse(@RequestParam String courseXml){
        xStream.processAnnotations(Course.class);
        Course course = (Course) xStream.fromXML(courseXml);
        courseMapper.deleteById(course.getCno());
    }

    @GetMapping("/courses/update")
    public void updateCourse(@RequestParam String courseXml){
        xStream.processAnnotations(Course.class);
        Course course = (Course) xStream.fromXML(courseXml);
        courseMapper.updateById(course);
    }

    @GetMapping("courses/searchByCno")
    public String searchByCno(String courseXml){
        xStream.processAnnotations(Course.class);
        Course course = (Course) xStream.fromXML(courseXml);
        return xStream.toXML(courseMapper.selectById(course.getCno()));
    }

    @GetMapping("/courses/sendSharedCourse")
    public String sendSharedCourse(@RequestParam String courseXml){
        xStream.processAnnotations(Course.class);
        Course sharedCourse = (Course) xStream.fromXML(courseXml);
        sharedCourse.setShared("1");
        courseMapper.updateById(sharedCourse);
        return xStream.toXML(courseMapper.selectById(sharedCourse.getCno()));
    }

    @GetMapping("/courses/receiveSharedCourse")
    public void receiveSharedCourse(@RequestParam String courseXml){
        addCourse(courseXml);
    }
}
