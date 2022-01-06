package action.a1;

import action.BaseAction;
import dao.UserDao;
import util.Factory;
import entity.User;

public class UserAction extends BaseAction{

	private User user;
	private String password2;

	
	
	

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String add(){
		UserDao userDao=(UserDao) Factory.getInstance("UserDao");
		try {
			if(!user.getPassword().equals(password2)){
				request.put("password_error", "两次密码不一致");
				return "password_error";
			}else{
			userDao.save1(user);
			return "list";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}
	public String load(){
		UserDao userDao=(UserDao) Factory.getInstance("UserDao");
		try {
			user=userDao.findById(user.getUid());
			return "load";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
	public String delete(){
		UserDao userDao=(UserDao) Factory.getInstance("UserDao");
		try {
			userDao.deleteById(user.getUid());
			return "delete";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
	public String update(){
		UserDao userDao=(UserDao) Factory.getInstance("UserDao");
		try {
			userDao.update(user);
			return "list";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	public String update1(){
		UserDao userDao=(UserDao) Factory.getInstance("UserDao");
		try {
			userDao.updateUser(user);
			return "update";
		} catch (Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	public String updateInf(){
		UserDao userDao=(UserDao) Factory.getInstance("UserDao");
		try {
			user=userDao.findByUsername(user.getUsername());
			userDao.update(user);
			return "updatesuccess";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
}









