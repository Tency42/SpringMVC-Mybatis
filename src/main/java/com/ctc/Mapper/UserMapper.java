package com.ctc.Mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.ctc.Model.User;

/**
 * 
 * @author Tency
 * 
 * Date 2016/11
 */

@MapperScan
public interface UserMapper {

	List<User> retrieve(String userName,String passWord);
	void add(User user);
	List<User> retrieveAll(Map<String,Object> map);
	int retrieveCount();
	User load(int id);
	void update(User user);
	void delete(int id);

}
