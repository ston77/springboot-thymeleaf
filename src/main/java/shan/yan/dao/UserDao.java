package shan.yan.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import shan.yan.domain.User;

@Mapper
public interface UserDao {
	@Select("select * from user where id=#{id}")
	public User getById(@Param("id") int id) ;
	
	@Insert("insert into user(id,uid,uname) values( #{id},#{uid},#{uname})")
	public void insert(User u1);
}
