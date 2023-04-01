package com.example.a.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.a.pojo.Course;
import com.example.a.pojo.Enroll;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EnrollMapper extends BaseMapper<Enroll> {

    @Delete("delete from ENROLL where 学生编号 = #{sno} and 课程编号 = #{cno}")
    void deleteByCnoAndSno(@Param("sno") String sno, @Param("cno") String cno);
}
