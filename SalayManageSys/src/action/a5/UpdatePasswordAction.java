package action.a5;

import action.BaseAction;
import util.Factory;
import dao.UserDao;
import entity.User;

public class UpdatePasswordAction  extends BaseAction{
	private User user;
	private String oldPassword;
	private String newPassword1;
	private String newPassword2;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword1() {
		return newPassword1;
	}
	public void setNewPassword1(String newPassword1) {
		this.newPassword1 = newPassword1;
	}
	public String getNewPassword2() {
		return newPassword2;
	}
	public void setNewPassword2(String newPassword2) {
		this.newPassword2 = newPassword2;
	}
	
	public String execute(){
		user=(User) session.get("user");
		String userid = (String) session.get("userInfo");
		UserDao userDao = (UserDao) Factory.getInstance("UserDao");
		try {
			if (!user.getPassword().equals(oldPassword)) {
				request.put("password_error", "密码错误");
				return "password_error";
			} else if (!newPassword1.equals(newPassword2)) {
				request.put("newPassword_error", "两次输入密码不一致");
				return "newPassword_error";
			} else {
				user.setPassword(newPassword1);
				userDao.changePassword(userid, newPassword1);
		//		userDao.update(user);
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}
	
}
