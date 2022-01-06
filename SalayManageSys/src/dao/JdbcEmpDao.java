package dao;

import java.awt.RadialGradientPaint;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import util.DbUtil;
import entity.User;

public class JdbcEmpDao implements EmpDao{

	public List<User> findAll(int page, int pageSize) throws Exception {
		String sql = "select * from user limit ?,?";
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
			User emp = new User();
			emp.setUid(rs.getString("uid"));
			emp.setUempid(rs.getString("uempid"));
			emp.setUtruename(rs.getString("utruename"));
			emp.setUsername(rs.getString("username"));
			emp.setAge(rs.getString("age"));
			emp.setSex(rs.getString("sex"));
			emp.setDeptname(rs.getString("deptname"));
			emp.setStartdate(rs.getString("startdate"));
			emp.setPassword(rs.getString("password"));
			emp.setUsertype(rs.getString("usertype"));
			emp.setZhichen(rs.getString("zhichen"));
			emp.setZhiwu(rs.getString("zhiwu"));
			emp.setShifouduzi(rs.getString("shifouduzi"));
			emp.setTelnum(rs.getString("telnum"));
			emp.setPolity(rs.getString("polity"));
			emp.setBirthday(rs.getString("birthday"));
			emp.setMarry(rs.getString("marry"));
			list.add(emp);
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

	public void save(User emp) throws Exception {
		Connection conn=DbUtil.getConnection();
		DbUtil.startTransaction();
		String sql="insert into user(uid,uempid,utruename,age,sex,birthday,idnum," +
				"marry,polity,city,telnum,address,school,degree,startdate,deptname,remark,usertype) " +
				"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst=conn.prepareStatement(sql);
		UUID id=UUID.randomUUID();
		pst.setString(1, id.toString());
		pst.setString(2, emp.getUempid());
		pst.setString(3, emp.getUtruename());
		pst.setString(4, emp.getAge());
		pst.setString(5, emp.getSex());
		pst.setString(6, emp.getBirthday());
		pst.setString(7, emp.getIdnum());
		pst.setString(8, emp.getMarry());
		pst.setString(9, emp.getPolity());
		pst.setString(10, emp.getCity());
		pst.setString(11, emp.getTelnum());
		pst.setString(12, emp.getAddress());
		pst.setString(13, emp.getSchool());
		pst.setString(14, emp.getDegree());
		pst.setString(15, emp.getStartdate());
		pst.setString(16, emp.getDeptname());    //
		pst.setString(17, emp.getRemark());
		pst.setString(18, emp.getUsertype());
		pst.executeUpdate();
		
	/*	
		String sql2="insert into salarystandard(uid,did,dempid,dtruename) values(?,?,?,?)";
		PreparedStatement pst2=conn.prepareStatement(sql2);
		pst2.setString(1, id.toString());
		id=UUID.randomUUID();
		pst2.setString(2, id.toString());
		pst2.setString(3, emp.getUempid());
		pst2.setString(4, emp.getUtruename());
		pst2.executeUpdate();
		
		*/
		DbUtil.commit();
		DbUtil.closeConnection();
		
	}
	public void save1(User emp) throws Exception {
		Connection conn=DbUtil.getConnection();
		DbUtil.startTransaction();
		String sql="insert into user(uid,uempid,utruename,sex,birthday,marry," +
				"shifouduzi,zhiwu,zhichen,polity,startdate,deptname,"
				+ "usertype,telnum,username)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst=conn.prepareStatement(sql);
	//	UUID id=UUID.randomUUID();
		pst.setString(1, emp.getUid());
		pst.setString(2, emp.getUempid());
		pst.setString(3, emp.getUtruename());
		pst.setString(4, emp.getSex());
		pst.setString(5, emp.getBirthday());
		pst.setString(6, emp.getMarry());
		pst.setString(7, emp.getShifouduzi());
		pst.setString(8, emp.getZhiwu());
		pst.setString(9, emp.getZhichen());
		pst.setString(10, emp.getPolity());
		pst.setString(11, emp.getStartdate());
		pst.setString(12, emp.getDeptname());
		pst.setString(13, emp.getUsertype());
		pst.setString(14, emp.getTelnum()); 
		pst.setString(15, emp.getUsername()); 
		pst.executeUpdate();
		
		/*	
		String sql2="insert into salarystandard(uid,did,dempid,dtruename) values(?,?,?,?)";
		PreparedStatement pst2=conn.prepareStatement(sql2);
		pst2.setString(1, id.toString());
		id=UUID.randomUUID();
		pst2.setString(2, id.toString());
		pst2.setString(3, emp.getUempid());
		pst2.setString(4, emp.getUtruename());
		pst2.executeUpdate();
		
		 */
		DbUtil.commit();
		DbUtil.closeConnection();
		
	}
	public void save2(User emp) throws Exception {
		Connection conn=DbUtil.getConnection();
		DbUtil.startTransaction();
		String sql="insert into user(uid,uempid,utruename,sex,birthday,marry," +
				"shifouduzi,zhiwu,zhichen,polity,startdate,deptname,"
				+ "usertype,telnum,username)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst=conn.prepareStatement(sql);
		//	UUID id=UUID.randomUUID();
		pst.setString(1, emp.getUid());
		pst.setString(2, emp.getUempid());
		pst.setString(3, emp.getUtruename());
		pst.setString(4, emp.getSex());
		pst.setString(5, emp.getBirthday());
		pst.setString(6, emp.getMarry());
		pst.setString(7, emp.getShifouduzi());
		pst.setString(8, emp.getZhiwu());
		pst.setString(9, emp.getZhichen());
		pst.setString(10, emp.getPolity());
		pst.setString(11, emp.getStartdate());
		pst.setString(12, emp.getDeptname());
		pst.setString(13, emp.getUsertype());
		pst.setString(14, emp.getTelnum()); 
		pst.setString(15, emp.getUsername()); 
		pst.executeUpdate();
		
		/*	
		String sql2="insert into salarystandard(uid,did,dempid,dtruename) values(?,?,?,?)";
		PreparedStatement pst2=conn.prepareStatement(sql2);
		pst2.setString(1, id.toString());
		id=UUID.randomUUID();
		pst2.setString(2, id.toString());
		pst2.setString(3, emp.getUempid());
		pst2.setString(4, emp.getUtruename());
		pst2.executeUpdate();
		
		 */
		DbUtil.commit();
		DbUtil.closeConnection();
		
	}

	
	public User findById(String id) throws Exception {
		String sql = "select * from user where uid=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
					conn.prepareStatement(sql);
		pst.setString(1, id);
		ResultSet rs = pst.executeQuery();
		User user = null;
		if(rs.next()){
			user=new User();
			user.setUid(id);
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setUtruename(rs.getString("utruename"));
			user.setAddress(rs.getString("address"));
			user.setAge(rs.getString("age"));
			user.setBirthday(rs.getString("birthday"));
			user.setCity(rs.getString("city"));
			user.setDegree(rs.getString("degree"));
			user.setDeptname(rs.getString("deptname"));
			user.setUempid(rs.getString("uempid"));
			user.setIdnum(rs.getString("idnum"));
			user.setMarry(rs.getString("marry"));
			user.setPolity(rs.getString("polity"));
			user.setRemark(rs.getString("remark"));
			user.setSex(rs.getString("sex"));
			user.setSchool(rs.getString("school"));
			user.setStartdate(rs.getString("startdate"));
			user.setTelnum(rs.getString("telnum"));
			user.setUtruename(rs.getString("utruename"));
			user.setUsertype(rs.getString("usertype"));
			user.setShifouduzi(rs.getString("shifouduzi"));
			user.setGangwei(rs.getString("gangwei"));
			user.setZhichen(rs.getString("zhichen"));
		}
		DbUtil.closeConnection();
		return user;
	}
	
	public User findByIdEmp(String id) throws Exception {
		String sql = "select * from user where uid=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
				conn.prepareStatement(sql);
		pst.setString(1, id);
		ResultSet rs = pst.executeQuery();
		User user = null;
		if(rs.next()){
			user=new User();
			//user.setUid(id);
			user.setUid(rs.getString("uid"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setUtruename(rs.getString("utruename"));
			user.setAddress(rs.getString("address"));
			user.setAge(rs.getString("age"));
			user.setBirthday(rs.getString("birthday"));
			user.setCity(rs.getString("city"));
			user.setDegree(rs.getString("degree"));
			user.setDeptname(rs.getString("deptname"));
			user.setUempid(rs.getString("uempid"));
			user.setIdnum(rs.getString("idnum"));
			user.setMarry(rs.getString("marry"));
			user.setPolity(rs.getString("polity"));
			user.setRemark(rs.getString("remark"));
			user.setSex(rs.getString("sex"));
			user.setSchool(rs.getString("school"));
			user.setStartdate(rs.getString("startdate"));
			user.setTelnum(rs.getString("telnum"));
			user.setUtruename(rs.getString("utruename"));
			user.setUsertype(rs.getString("usertype"));
			user.setZhichen(rs.getString("zhichen"));
			user.setZhiwu(rs.getString("zhiwu"));
			user.setShifouduzi(rs.getString("shifouduzi"));
			
		}
		DbUtil.closeConnection();
		return user;
	}

	public void update(User emp) throws Exception {
		String sql="update user set uempid=?,utruename=?,age=?,sex=?,birthday=?,"+
				"idnum=?,marry=?,polity=?,city=?,telnum=?,address=?,school=?," +
				"degree=?,startdate=?,deptname=?,remark=?,usertype=? where uid=?";
		Connection conn=DbUtil.getConnection();
		PreparedStatement pst=conn.prepareStatement(sql);
		
		pst.setString(1, emp.getUempid());
		pst.setString(2, emp.getUtruename());
		pst.setString(3, emp.getAge());
		pst.setString(4, emp.getSex());
		pst.setString(5, emp.getBirthday());
		pst.setString(6, emp.getIdnum());
		pst.setString(7, emp.getMarry());
		pst.setString(8, emp.getPolity());
		pst.setString(9, emp.getCity());
		pst.setString(10, emp.getTelnum());
		pst.setString(11, emp.getAddress());
		pst.setString(12, emp.getSchool());
		pst.setString(13, emp.getDegree());
		pst.setString(14, emp.getStartdate());
		pst.setString(15, emp.getDeptname());
		pst.setString(16, emp.getRemark());
		pst.setString(17, emp.getUsertype());
		pst.setString(18, emp.getUid().split(",")[0]);
		
		pst.executeUpdate();
	
		DbUtil.closeConnection();
	}
	public void update1(User emp) throws Exception {
		String sql="update user set uempid=?,utruename=?,sex=?, birthday=?,marry=? ,shifouduzi=? ,zhiwu=? ,zhichen=?"
				+ " ,polity=? ,startdate=? "
				+ ",usertype=? ,telnum=? ,deptname=? where uid=?";
		Connection conn=DbUtil.getConnection();
		PreparedStatement pst=conn.prepareStatement(sql);
		
		pst.setString(1, emp.getUempid());
		pst.setString(2, emp.getUtruename());
		pst.setString(3, emp.getSex());
		pst.setString(4, emp.getBirthday());
		pst.setString(5, emp.getMarry());
		pst.setString(6, emp.getShifouduzi());
		pst.setString(7, emp.getZhiwu());
		pst.setString(8, emp.getZhichen());
		pst.setString(9, emp.getPolity());	
		pst.setString(10, emp.getStartdate());
		pst.setString(11, emp.getUsertype());
		pst.setString(12, emp.getTelnum());	
		pst.setString(13, emp.getDeptname());
		pst.setString(14, emp.getUid().split(",")[0]);
		pst.executeUpdate();
		
		DbUtil.closeConnection();
	}
	public void update2(User emp) throws Exception {
		String sql="update user set  username=? , usertype=? , password=?  where uid=?";
		Connection conn=DbUtil.getConnection();
		PreparedStatement pst=conn.prepareStatement(sql);	
		
		pst.setString(1, emp.getUsername());
		pst.setString(2, emp.getUsertype());
		pst.setString(3, emp.getPassword());			
		pst.setString(4, emp.getUid().split(",")[0]);
		
		pst.executeUpdate();
		
		DbUtil.closeConnection();
	}

	
	
	
	
	
	
	public void deleteById(String id) throws Exception {
		Connection conn=DbUtil.getConnection();
		String sql="delete from user where uid=?";
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setString(1, id);
		pst.executeUpdate();
		
		String sql1="delete from salary where uid=?";
		PreparedStatement pst1=conn.prepareStatement(sql1);
		pst1.setString(1, id);
		pst1.executeUpdate();
		
		String sql2="delete from salarystandard where uid=?";
		PreparedStatement pst2=conn.prepareStatement(sql2);
		pst2.setString(1, id);
		pst2.executeUpdate();
		
		String sql3="delete from attendence where uid=?";
		PreparedStatement pst3=conn.prepareStatement(sql3);
		pst3.setString(1, id);
		pst3.executeUpdate();
		DbUtil.closeConnection();
		
	}


	public List<User> findEmp(User emp) throws Exception {
		StringBuffer sql=new StringBuffer();
		sql.append("select * from user where 1=1");
		if(emp.getUempid()!=null&&!emp.getUempid().equals("")){
			sql.append(" and uempid like'%"+emp.getUempid()+"%'");
		}
		if(emp.getUtruename()!=null&&!emp.getUtruename().equals("")){
			sql.append(" and utruename like'%"+emp.getUtruename()+"%'");
		}
		Connection conn = DbUtil.getConnection();
		Statement stmt=conn.createStatement();
		String str=sql.toString();
		ResultSet rs=stmt.executeQuery(str);
		User user = null;
		List<User> emps=new ArrayList<User>();
		while(rs.next()){
			user=new User();
			user.setUid(rs.getString("uid"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setUtruename(rs.getString("utruename"));
			user.setAddress(rs.getString("address"));
			user.setAge(rs.getString("age"));
			user.setBirthday(rs.getString("birthday"));
			user.setCity(rs.getString("city"));
			user.setDegree(rs.getString("degree"));
			user.setDeptname(rs.getString("deptname"));
			user.setUempid(rs.getString("uempid"));
			user.setIdnum(rs.getString("idnum"));
			user.setMarry(rs.getString("marry"));
			user.setPolity(rs.getString("polity"));
			user.setRemark(rs.getString("remark"));
			user.setSex(rs.getString("sex"));
			user.setSchool(rs.getString("school"));
			user.setStartdate(rs.getString("startdate"));
			user.setTelnum(rs.getString("telnum"));
			user.setUtruename(rs.getString("utruename"));
			emps.add(user);
		}
		DbUtil.closeConnection();
		return emps;
	}

	

}
