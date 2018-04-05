package ncu.zp.service;

import java.util.List;

import ncu.zp.entity.User;


public interface UserService {
	/**
	 * 判断用户是否存在
	 * @param userName
	 * @return user
	 * @ 
	 * */
	public boolean isExitUser(String userName) ;
	
	/**
	 * 判断用户是否存在
	 * @param userName passWord
	 * @return user
	 * @ 
	 * */
	public boolean isExitByNameAndPass(User user) ;
	
	/**
	 * 保存用户
	 * @param user
	 * @return boolean
	 * @ 
	 * */
	public void save(User user) ;
	
	/**
	 * 查询�?有用�?
	 * @param 
	 * @return List<User>
	 * @ 
	 * */
	public List<User> getUsers() ;
	/**
	 * 删除用户
	 * @param userId
	 * @return 
	 * @ 
	 * */
	public void del(int userId) ;
	
	/**
	 * 修改用户
	 * @param user
	 * @return 
	 * @ 
	 * */
	public void update(User user) ;
	
	/**
	 * 根据id获得user
	 * @param userId
	 * @return user
	 * @ 
	 * */
	public User getUserById(int userId) ;
	
	
}
