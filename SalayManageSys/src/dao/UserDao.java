package dao;

import java.util.List;

import entity.User;

public interface UserDao {
	public User findByUsername(String username)throws Exception;
	public void save(User user)throws Exception;
	public List<User> findAll(int page,int pageSize)throws Exception;
	public int countTotalPage(int pageSize) throws Exception;
	public User findById(String id)throws Exception;
	public void update(User user)throws Exception;
	public void deleteById(String id)throws Exception;
	public void changePassword(String id,String password) throws Exception;
	public void save1(User user) throws Exception;
	public void save2(User user) throws Exception;
	public User findByUsernameInf(String username) throws Exception;
	public void updateUser(User user) throws Exception;
}
