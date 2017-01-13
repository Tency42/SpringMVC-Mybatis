package com.ctc.ServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ctc.Mapper.UserMapper;
import com.ctc.Model.PageConstants;
import com.ctc.Model.Pager;
import com.ctc.Model.User;
import com.ctc.Service.UserService;

/**
 * 
 * @author Tency
 * 
 * Date 2016/11
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	HttpSession session;
	HttpServletRequest request;
	@Override
	public List<User> checkLogin(@Param("userName")String userName, @Param("passWord")String passWord) {
		// TODO Auto-generated method stub
		List<User> list= userMapper.retrieve(userName, passWord);
		 request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest(); 
		 session=request.getSession();
		if(!list.isEmpty())
		{
			session.setAttribute("userName", list.get(0).getUserName());
		}
		
		return list;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		this.userMapper.add(user);
	}

	@Override
	public User showUser(int id) {
		// TODO Auto-generated method stub
		return userMapper.load(id);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		this.userMapper.update(user);
		request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest(); 
		session=request.getSession();
		session.setAttribute("userName", user.getUserName());
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		this.userMapper.delete(id);
	}

	@Override
	public Pager<User> userList() {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		Pager<User> pager = new Pager<User>();
		int size = PageConstants.getSize();
		int offset = PageConstants.getOffset();
		map.put("size", size);
		map.put("offset", offset);
		pager.setDatas(userMapper.retrieveAll(map));
		pager.setTotal(userMapper.retrieveCount());
		return pager;
	}




	
}
