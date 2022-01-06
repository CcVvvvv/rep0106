package action.a0;

import org.omg.CORBA.PRIVATE_MEMBER;

import util.Factory;
import action.BaseAction;
import dao.UserDao;
import entity.User;

//第一次使用分支
public class LoginAction extends BaseAction{
	private String username;
	private String password;
	private User user;
	private String usertype;
	
	public String execute() throws Exception{
		UserDao userDao=(UserDao) Factory.getInstance("UserDao");
		user=userDao.findByUsernameInf(username);
		String quanxian = user.getUsertype();
		if(user==null){
			request.put("username_error", "用户名不能为空");
			return "username_error";
		}else if(!user.getPassword().equals(password)){
				request.put("password_error", "用户名或密码不正确");
				return "password_error";
			}else if(!usertype.equals(quanxian)){
				request.put("password_error", "用户名 密码或权限不正确");
				return "password_error";
				}
			else {
			
				session.put("userInfo", user.getUid());
				session.put("user",user);
//				session.put("userType", user.getUsertype());
				String typeString = null;
				switch (usertype) {
				case "admin":
					typeString= "success1";
					break;
					
				case "renshichu":
					typeString= "success2";
					break;
					
				case "caiwuchu":
					typeString= "success3";
					break;
					
				case "xuexiaobumen":
					typeString= "success4";
					break;
					
				case "jiaozhigong":
					typeString= "success5";
					break;				
				}
				return typeString;
			}
			}
		
	
	

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}


	public String getUsertype() {
		return usertype;
	}


	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
}
