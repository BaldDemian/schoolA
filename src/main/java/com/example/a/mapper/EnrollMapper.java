package com.example.a.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.a.pojo.Enroll;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EnrollMapper extends BaseMapper<Enroll> {
    @Select("select * from demo.ENROLL")
    List<Enroll> findAllEnroll();

    @Delete("delete from demo.ENROLL where 课程编号 = #{cno} and 学生编号 = #{sno}")
    // 删除掉一条选课记录，(cno, sno)是联合主键
    void deleteByCnoSno(@Param("cno") String cno, @Param("sno") String sno);
}
