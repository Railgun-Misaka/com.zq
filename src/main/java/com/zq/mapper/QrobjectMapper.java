package com.zq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zq.pojo.Qrobject;

@Mapper
public interface QrobjectMapper {
	
	@Select("select * from qrobject where id = #{id}")
	public Qrobject get(int id) ;
	
	@Select("select * from qrobject")
	public List<Qrobject> list();
	
	@Insert("insert into qrobject values (#{id}, #{name}, #{description}, 1)")
	public int add(Qrobject qr);
	
	@Delete("delete from qrobject where id = #{id} and version = 1")
	public int delete(int id);
	
	@Update("update qrobject set name = #{name}, description = #{description}, version = 0 where id = #{id} and version = 1")
	public int update(Qrobject qr);
	
	@Update("update qrobject set version = 1 where id = #{id} and version = 0")
	public int release(Qrobject qr);
}
