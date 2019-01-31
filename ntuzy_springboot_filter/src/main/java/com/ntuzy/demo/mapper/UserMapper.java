package com.ntuzy.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ntuzy.demo.bean.User;

/**
 * 
 * @author IamZY
 *
 */
public interface UserMapper {

	
	@Insert("INSERT INTO user(name,phone,create_time,age) value(#{name},#{phone},#{createTime},#{age})")
	@Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
	int insert(User user);
	
	@Select("SELECT * FROM user")
    @Results({
        @Result(column = "create_time",property = "createTime")  //javaType = java.util.Date.class
        // 多个
//        @Result(column = "create_time",property = "createTime").  //javaType = java.util.Date.class
    })
    List<User> getAll();
  
    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
    	 @Result(column = "create_time",property = "createTime")
    })
    User findById(Long id);

    @Update("UPDATE user SET name=#{name} WHERE id =#{id}")
    void update(User user);

    @Delete("DELETE FROM user WHERE id =#{userId}")
    void delete(Long userId);
	
}
