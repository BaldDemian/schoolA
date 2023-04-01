package com.example.a.controller;

import com.example.a.mapper.EnrollMapper;
import com.example.a.pojo.Enroll;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        // todo:由于MyBatisPlus不支持联合主键，所以语句需要手写
    }

    @PostMapping("/courses_selection/update")
    public void updateCoursesSelectionTable(@RequestBody String courses_selectionXml){
        xStream.processAnnotations(Enroll.class);
        Enroll enroll = (Enroll) xStream.fromXML(courses_selectionXml);
        enrollMapper.updateById(enroll);
    }
}
