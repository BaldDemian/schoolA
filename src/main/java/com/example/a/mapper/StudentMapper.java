package com.example.a.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.a.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    @Select("select * from \"STUDENT\"")
    List<Student> findAllStudents();

    @Insert("insert into \"STUDENT\" (学号, 姓名, 性别, 院系, 关联账户) values(#{sno}, #{name}, #{sex}, #{dept}, #{account})")
    void insertOne(Student student);

}
