package com.example.a.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.a.pojo.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {
}
