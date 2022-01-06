package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import util.DbUtil;

import entity.User;

public class JdbcUserDao implements UserDao{

	public User findByUsername(String username) throws Exception {
		Connection conn=DbUtil.getConnection();
		User user=null;
		Statement stat=conn.createStatement();
		String sql="select * from user where username='"+username+"'";
		ResultSet rs=stat.executeQuery(sql);
		if(rs.next()){
	//		String uid=rs.getString("uid");
			String password = rs.getString("password");
			user = new User();
	//		user.setUid(uid);
			user.setUsername(username);		
			user.setPassword(password);
			user.setUempid(rs.getString("uempid"));
			user.setUid(rs.getString("uid"));
			user.setUtruename(rs.getString("utruename"));
			user.setAge(rs.getString("age"));			
			user.setSex(rs.getString("sex"));
			user.setBirthday(rs.getString("birthday"));
			user.setIdnum(rs.getString("idnum"));
			user.setMarry(rs.getString("marry"));
			user.setPolity(rs.getString("polity"));
			user.setCity(rs.getString("city"));			
			user.setTelnum(rs.getString("telnum"));		
			user.setAddress(rs.getString("address"));
			user.setSchool(rs.getString("school"));	
			user.setDegree(rs.getString("degree"));
			user.setStartdate(rs.getString("startdate"));			
			user.setDeptname(rs.getString("deptname"));		
			user.setRemark(rs.getString("remark"));
			user.setUsertype(rs.getString("usertype"));
			user.setGangwei(rs.getString("gangwei"));
		}
		DbUtil.closeConnection();
		return user;
	}
	public User findByUsernameInf(String username) throws Exception {
		Connection conn=DbUtil.getConnection();
		User user=null;
		Statement stat=conn.createStatement();
		String sql="select * from userInf where username='"+username+"'";
		ResultSet rs=stat.executeQuery(sql);
		if(rs.next()){
			//		String uid=rs.getString("uid");
			String password = rs.getString("password");
			user = new User();
			//		user.setUid(uid);
			user.setUsername(username);		
			user.setPassword(password);	
			user.setUid(rs.getString("uid"));
			user.setUsertype(rs.getString("usertype"));
			
		}
		DbUtil.closeConnection();
		return user;
	}

	public void save(User user) throws Exception {
		Connection conn=DbUtil.getConnection();
		String sql="insert into user(uid,username,password,utruename,uempid,usertype) values(?,?,?,?,?,?)";
		PreparedStatement pst=conn.prepareStatement(sql);
		UUID id=UUID.randomUUID();
		pst.setString(1, id.toString());
		pst.setString(2, user.getUsername());
		pst.setString(3, user.getPassword());
		pst.setString(4, user.getUtruename());
		pst.setString(5, user.getUempid());
		pst.setString(6, user.getUsertype());
		pst.executeUpdate();
	
		DbUtil.closeConnection();
	}
	public void save1(User user) throws Exception {
		Connection conn=DbUtil.getConnection();
		String sql="insert into userInf(uid,username,password,usertype) values(?,?,?,?)";
		PreparedStatement pst=conn.prepareStatement(sql);
	//	UUID id=UUID.randomUUID();
		pst.setString(1, user.getUid());
		pst.setString(2, user.getUsername());
		pst.setString(3, user.getPassword());
	
		pst.setString(4, user.getUsertype());
		pst.executeUpdate();
		
		DbUtil.closeConnection();
	}
	public void save2(User user) throws Exception {
		Connection conn=DbUtil.getConnection();
		String sql="insert into user(uid,username,password,utruename,uempid,usertype) values(?,?,?,?,?,?)";
		PreparedStatement pst=conn.prepareStatement(sql);
		//	UUID id=UUID.randomUUID();
		pst.setString(1, user.getUid());
		pst.setString(2, user.getUsername());
		pst.setString(3, user.getPassword());
		pst.setString(4, user.getUtruename());
		pst.setString(5, user.getUempid());
		pst.setString(6, user.getUsertype());
		pst.executeUpdate();
		
		DbUtil.closeConnection();
	}

	public List<User> findAll(int page, int pageSize) throws Exception {
		String sql = "select * from userInf limit ?,?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
					conn.prepareStatement(sql);
		//设置分页查询参数
		int begin = (page-1)*pageSize;
		pst.setInt(1, begin);//设置抓取的起始点(从0开始)
		pst.setInt(2, pageSize);//设置最多抓取记录数
		ResultSet rs = pst.executeQuery();
		List<User> list = new ArrayList<User>();
		while(rs.next()){
			User user = new User();
			user.setUid(rs.getString("uid"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setUsertype(rs.getString("usertype"));
			list.add(user);
		}
		DbUtil.closeConnection();
		return list;
	}

	public int countTotalPage(int pageSize) throws Exception {
		String sql = "select count(*) from user";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
				conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		rs.next();//任何情况下都返回一个结果才可以这么写
		int totalRows = rs.getInt(1);
		DbUtil.closeConnection();
		//根据totalRows和pageSize计算总页数totalPages
		if(totalRows == 0){
			return 1;//没有记录认为1页
		}else if(totalRows%pageSize == 0){
			return totalRows/pageSize;
		}else{
			return totalRows/pageSize+1;
		}
	}
	
	public User findById(String uid) throws Exception {
		String sql = "select * from userInf where uid=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
					conn.prepareStatement(sql);
		pst.setString(1, uid);
		ResultSet rs = pst.executeQuery();
		User user = null;
		if(rs.next()){
			user=new User();
			user.setUid(uid);
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setUsertype(rs.getString("usertype"));
		}
		DbUtil.closeConnection();
		return user;
	}
	public void changePassword(String id,String password) throws Exception {
		String sql="update userInf set password=? where uid=?";
		Connection conn=DbUtil.getConnection();
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setString(1, password);
		pst.setString(2, id);
		pst.executeUpdate();
		DbUtil.closeConnection();
		
	}

	public void update(User user) throws Exception {
		String sql="update user set uid=?,password=?," +
				"utruename=?,uempid=? ,gangwei=? where username=?";
		Connection conn=DbUtil.getConnection();
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setString(1, user.getUid());
		pst.setString(2, user.getPassword());
		pst.setString(3, user.getUtruename());
		pst.setString(4, user.getUempid());
		pst.setString(5, user.getGangwei());
		pst.setString(6, user.getUsername());
		pst.executeUpdate();
		DbUtil.closeConnection();
		
	}
	public void updateUser(User user) throws Exception {
		String sql="update userInf set username=?,usertype=? where uid=?";
		Connection conn=DbUtil.getConnection();
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setString(1, user.getUsername());	
		pst.setString(2, user.getUsertype());
		pst.setString(3, user.getUid());
		pst.executeUpdate();
		DbUtil.closeConnection();
		
	}

	public void deleteById(String id) throws Exception {
		String sql="delete from userInf where uid=?";
		Connection conn=DbUtil.getConnection();
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setString(1, id);
		pst.executeUpdate();
		DbUtil.closeConnection();
	}

	
}





