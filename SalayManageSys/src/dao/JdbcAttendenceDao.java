package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import util.DbUtil;
import entity.Attendence;
import entity.AttendenceSet;
import entity.Dept;
import entity.User;

public class JdbcAttendenceDao implements AttendenceDao{

	public List<Attendence> findAll(int page, int pageSize,String year,String month) throws Exception {
		Connection conn = DbUtil.getConnection();
		//查询考勤信息
		String sqlAttendence="select * from attendence where ayear=? and amonth=? ";
		PreparedStatement pstAttendence=conn.prepareStatement(sqlAttendence);
		pstAttendence.setString(1, year);
		pstAttendence.setString(2, month);
		//设置分页查询参数
//		int begin = (page-1)*pageSize;
//		pstAttendence.setInt(3, begin);//设置抓取的起始点(从0开始)
//		pstAttendence.setInt(4, pageSize);//设置最多抓取记录数
		ResultSet rsAttendence=pstAttendence.executeQuery();
		List<Attendence> attendences=new ArrayList<Attendence>();
		Attendence attendence=null;
		while(rsAttendence.next()){
			attendence=new Attendence();
			attendence.setAid(rsAttendence.getString("aid"));
			attendence.setAempid(rsAttendence.getString("aempid"));
			attendence.setDept(rsAttendence.getString("dept"));
			attendence.setAtruename(rsAttendence.getString("atruename"));
			attendence.setAyear(rsAttendence.getString("ayear"));
			attendence.setAmonth(rsAttendence.getString("amonth"));
			attendence.setAlatecome(rsAttendence.getString("alatecome"));
			attendence.setAearlyleave(rsAttendence.getString("aearlyleave"));
			attendence.setAleave(rsAttendence.getString("aleave"));
			attendence.setAovertime(rsAttendence.getString("aovertime"));
			attendence.setAnegletwork(rsAttendence.getString("anegletwork"));
//			attendence.setChuqin(rsAttendence.getString("chuqin"));
//			attendence.setChuqinpay(rsAttendence.getString("chuqinpay"));
//			attendence.setDept(rsAttendence.getString("dept"));
			attendences.add(attendence);
		}
		DbUtil.closeConnection();
		return attendences;
	}
	
	public List<Attendence> findAll1(int page, int pageSize,String year,String month) throws Exception {
		Connection conn = DbUtil.getConnection();
		//查询考勤信息
		String sqlAttendence="select * from attendence where ayear=? and amonth=? ";
		PreparedStatement pstAttendence=conn.prepareStatement(sqlAttendence);
		pstAttendence.setString(1, year);
		pstAttendence.setString(2, month);
		//设置分页查询参数
//		int begin = (page-1)*pageSize;
//		pstAttendence.setInt(3, begin);//设置抓取的起始点(从0开始)
//		pstAttendence.setInt(4, pageSize);//设置最多抓取记录数
		ResultSet rsAttendence=pstAttendence.executeQuery();
		List<Attendence> attendences=new ArrayList<Attendence>();
		Attendence attendence=null;
		while(rsAttendence.next()){
			attendence=new Attendence();
			attendence.setAid(rsAttendence.getString("aid"));
			attendence.setAempid(rsAttendence.getString("aempid"));
			attendence.setAtruename(rsAttendence.getString("atruename"));
			attendence.setAyear(rsAttendence.getString("ayear"));
			attendence.setAmonth(rsAttendence.getString("amonth"));			
			attendence.setDept(rsAttendence.getString("dept"));
			attendence.setAlatecome(rsAttendence.getString("alatecome"));
			attendence.setAearlyleave(rsAttendence.getString("aearlyleave"));
			attendence.setAnegletwork(rsAttendence.getString("anegletwork"));
			attendence.setAleave(rsAttendence.getString("aleave"));
			attendence.setAovertime(rsAttendence.getString("aovertime"));
			attendence.setQueqinday(rsAttendence.getString("queqinday"));
			attendence.setKoukuanmeici(rsAttendence.getString("koukuanmeici"));
			attendence.setYinkou(rsAttendence.getString("yinkou"));
			
			int yingk =( Integer.parseInt(attendence.getQueqinday())*Integer.parseInt(attendence.getKoukuanmeici()));
			attendence.setYinkou(String.valueOf(yingk));
			
			attendences.add(attendence);
		}
		DbUtil.closeConnection();
		return attendences;
	}
	public List<Attendence> findAllDYM(String dept,String year,String month) throws Exception {
		//获取奖罚详情
				String sql="select  * from attendenceset";
				Connection conn = DbUtil.getConnection();
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql);
				AttendenceSet attendenceSet=null;
				int cearlyleave =0;
				int clatecome =0;
				int cnegletwork=0 ;
				int cleave =0;
				int covertime = 0  ;
				if(rs.next()){
					attendenceSet=new AttendenceSet();
					attendenceSet.setCid(rs.getString("cid"));
					attendenceSet.setCearlyleave(rs.getString(("cearlyleave")));
					cearlyleave = Integer.parseInt(attendenceSet.getCearlyleave());
					
					attendenceSet.setClatecome(rs.getString("clatecome"));		
					clatecome = Integer.parseInt(attendenceSet.getClatecome());
					
					attendenceSet.setCnegletwork(rs.getString("cnegletwork"));
					cnegletwork = Integer.parseInt(attendenceSet.getCnegletwork());
					
					attendenceSet.setCleave(rs.getString("cleave"));
					cleave = Integer.parseInt(attendenceSet.getCleave());
					
					attendenceSet.setCovertime(rs.getString("covertime"));
					covertime = Integer.parseInt(attendenceSet.getCovertime());
				}
		
		Connection conn2 = DbUtil.getConnection();
		//查询考勤信息
		String sqlAttendence="select * from attendenceInf where ayear=? and amonth=? and dept=?";
		PreparedStatement pstAttendence=conn2.prepareStatement(sqlAttendence);
		pstAttendence.setString(1, year);
		pstAttendence.setString(2, month);
		pstAttendence.setString(3, dept);
		//设置分页查询参数
//		int begin = (page-1)*pageSize;
//		pstAttendence.setInt(3, begin);//设置抓取的起始点(从0开始)
//		pstAttendence.setInt(4, pageSize);//设置最多抓取记录数
		ResultSet rsAttendence=pstAttendence.executeQuery();
		List<Attendence> attendences=new ArrayList<Attendence>();
		Attendence attendence=null;
		while(rsAttendence.next()){
			attendence=new Attendence();
			attendence.setAid(rsAttendence.getString("aid"));
			attendence.setAempid(rsAttendence.getString("aempid"));
			attendence.setAtruename(rsAttendence.getString("atruename"));
			attendence.setAyear(rsAttendence.getString("ayear"));
			attendence.setAmonth(rsAttendence.getString("amonth"));			
			attendence.setDept(rsAttendence.getString("dept"));
			attendence.setAlatecome(rsAttendence.getString("alatecome"));
			attendence.setAearlyleave(rsAttendence.getString("aearlyleave"));
			attendence.setAnegletwork(rsAttendence.getString("anegletwork"));
			attendence.setAleave(rsAttendence.getString("aleave"));
			attendence.setAovertime(rsAttendence.getString("aovertime"));
			
			int yingjiang = Integer.parseInt(attendence.getAovertime())* covertime;
			attendence.setYinjiang(String.valueOf(yingjiang));
			
			int alatecome = Integer.parseInt(attendence.getAlatecome())*clatecome;
			int aearlyleave= Integer.parseInt(attendence.getAearlyleave())*cearlyleave;			
			int anegletwork= Integer.parseInt(attendence.getAnegletwork())*cnegletwork;			
			int aleave= Integer.parseInt(attendence.getAleave())*cleave;
			
			int yingkou = alatecome+aearlyleave+anegletwork+aleave;
			attendence.setYinkou(String.valueOf(yingkou));
			
			attendences.add(attendence);
		}
		DbUtil.closeConnection();
		return attendences;
	}
	public List<Attendence> findAllYM(String year,String month) throws Exception {
/////////////////////////////////////////////////////////////////////////////////////////////////		
		//获取奖罚详情
		String sql="select  * from attendenceset";
		Connection conn = DbUtil.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		AttendenceSet attendenceSet=null;
		int cearlyleave =0;
		int clatecome =0;
		int cnegletwork=0 ;
		int cleave =0;
		int covertime = 0  ;
		if(rs.next()){
			attendenceSet=new AttendenceSet();
			attendenceSet.setCid(rs.getString("cid"));
			attendenceSet.setCearlyleave(rs.getString(("cearlyleave")));
			cearlyleave = Integer.parseInt(attendenceSet.getCearlyleave());
			
			attendenceSet.setClatecome(rs.getString("clatecome"));		
			clatecome = Integer.parseInt(attendenceSet.getClatecome());
			
			attendenceSet.setCnegletwork(rs.getString("cnegletwork"));
			cnegletwork = Integer.parseInt(attendenceSet.getCnegletwork());
			
			attendenceSet.setCleave(rs.getString("cleave"));
			cleave = Integer.parseInt(attendenceSet.getCleave());
			
			attendenceSet.setCovertime(rs.getString("covertime"));
			covertime = Integer.parseInt(attendenceSet.getCovertime());
		}		
		Connection conn1 = DbUtil.getConnection();
		//查询考勤信息
		String sqlAttendence="select * from attendenceInf where ayear=? and amonth=? ";
		PreparedStatement pstAttendence=conn1.prepareStatement(sqlAttendence);
		pstAttendence.setString(1, year);
		pstAttendence.setString(2, month);
		//设置分页查询参数
//		int begin = (page-1)*pageSize;
//		pstAttendence.setInt(3, begin);//设置抓取的起始点(从0开始)
//		pstAttendence.setInt(4, pageSize);//设置最多抓取记录数
		ResultSet rsAttendence=pstAttendence.executeQuery();
		List<Attendence> attendences=new ArrayList<Attendence>();
		Attendence attendence=null;
		while(rsAttendence.next()){
			attendence=new Attendence();
			attendence.setAid(rsAttendence.getString("aid"));
			attendence.setAempid(rsAttendence.getString("aempid"));
			attendence.setAtruename(rsAttendence.getString("atruename"));
			attendence.setAyear(rsAttendence.getString("ayear"));
			attendence.setAmonth(rsAttendence.getString("amonth"));			
			attendence.setDept(rsAttendence.getString("dept"));
			
			attendence.setAlatecome(rsAttendence.getString("alatecome"));
			attendence.setAearlyleave(rsAttendence.getString("aearlyleave"));
			attendence.setAnegletwork(rsAttendence.getString("anegletwork"));
			attendence.setAleave(rsAttendence.getString("aleave"));
			
			attendence.setAovertime(rsAttendence.getString("aovertime"));							
			attendence.setYinkou(rsAttendence.getString("yinkou"));
			attendence.setYinjiang(rsAttendence.getString("yinjiang"));
			
			int yingjiang = Integer.parseInt(attendence.getAovertime())* covertime;
			attendence.setYinjiang(String.valueOf(yingjiang));
			
			int alatecome = Integer.parseInt(attendence.getAlatecome())*clatecome;
			int aearlyleave= Integer.parseInt(attendence.getAearlyleave())*cearlyleave;			
			int anegletwork= Integer.parseInt(attendence.getAnegletwork())*cnegletwork;			
			int aleave= Integer.parseInt(attendence.getAleave())*cleave;
			
			int yingkou = alatecome+aearlyleave+anegletwork+aleave;
			attendence.setYinkou(String.valueOf(yingkou));
			
			attendences.add(attendence);
/////////////////////////////////////////////////////////////////////////////////////////////////
		}
		DbUtil.closeConnection();
		return attendences;
	}
	public List<Attendence> findAllInf(int page, int pageSize,String dept,String year,String month) throws Exception {
		Connection conn = DbUtil.getConnection();
		//查询考勤信息
		String sqlAttendence="select * from attendence where dept=? ayear=? and amonth=? limit ?,?,?";
		PreparedStatement pstAttendence=conn.prepareStatement(sqlAttendence);
		pstAttendence.setString(1, dept);
		pstAttendence.setString(2, year);
		pstAttendence.setString(3, month);
		//设置分页查询参数
		int begin = (page-1)*pageSize;
		pstAttendence.setInt(1, begin);//设置抓取的起始点(从0开始)
		pstAttendence.setInt(2, pageSize);//设置最多抓取记录数
		ResultSet rsAttendence=pstAttendence.executeQuery();
		List<Attendence> attendences=new ArrayList<Attendence>();
		Attendence attendence=null;
		while(rsAttendence.next()){
			attendence=new Attendence();
			attendence.setAid(rsAttendence.getString("aid"));
			attendence.setAempid(rsAttendence.getString("aempid"));
			attendence.setAtruename(rsAttendence.getString("atruename"));
			attendence.setDept(rsAttendence.getString("dept"));
			attendence.setAyear(rsAttendence.getString("ayear"));
			attendence.setAmonth(rsAttendence.getString("amonth"));
			attendence.setAlatecome(rsAttendence.getString("alatecome"));
			attendence.setAearlyleave(rsAttendence.getString("aearlyleave"));
			attendence.setAleave(rsAttendence.getString("aleave"));
			attendence.setAovertime(rsAttendence.getString("aovertime"));
			attendence.setAnegletwork(rsAttendence.getString("anegletwork"));
			attendences.add(attendence);
		}
		DbUtil.closeConnection();
		return attendences;
	}

	
	public int countTotalPage(int pageSize) throws Exception {
		String sql = "select count(*) from attendence";
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

	public void save(Attendence attendence) throws Exception {
		String sql = "insert into attendenceInf(aid,aempid,ayear,amonth,dept,atruename,alatecome," +
				"anegletwork,aleave,aearlyleave,aovertime) values(?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
					conn.prepareStatement(sql);
	//	UUID id=UUID.randomUUID();
		pst.setString(1,attendence.getAid());
		pst.setString(2,attendence.getAempid());
		pst.setString(3,attendence.getAyear());
		pst.setString(4,attendence.getAmonth());
		pst.setString(5,attendence.getDept());
		pst.setString(6,attendence.getAtruename());
		pst.setString(7,attendence.getAlatecome());
		pst.setString(8,attendence.getAnegletwork());
		pst.setString(9,attendence.getAleave());
		pst.setString(10,attendence.getAearlyleave());
		pst.setString(11,attendence.getAovertime());
	
		pst.executeUpdate();
		DbUtil.closeConnection();
		
	}

	public Attendence findById(String id) throws Exception {
		String sql = "select * from attendence where aid=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
					conn.prepareStatement(sql);
		pst.setString(1, id);
		ResultSet rs = pst.executeQuery();
		Attendence attendence =  null;
		if(rs.next()){
			attendence = new Attendence();
			attendence.setAid(rs.getString("aid"));
			attendence.setAempid(rs.getString("aempid"));
			attendence.setAtruename(rs.getString("atruename"));
			attendence.setAyear(rs.getString("ayear"));
			attendence.setAmonth(rs.getString("amonth"));
			attendence.setAlatecome(rs.getString("alatecome"));
			attendence.setAearlyleave(rs.getString("aearlyleave"));
			attendence.setAleave(rs.getString("aleave"));
			attendence.setAovertime(rs.getString("aovertime"));
			attendence.setAnegletwork(rs.getString("anegletwork"));
			attendence.setChuqin(rs.getString("chuqin"));
			attendence.setChuqinpay(rs.getString("chuqinpay"));
			attendence.setDept(rs.getString("dept"));
			attendence.setQueqinday(rs.getString("queqinday"));
			attendence.setKoukuanmeici(rs.getString("koukuanmeici"));
			attendence.setYinkou(rs.getString("yinkou"));
		}
		DbUtil.closeConnection();
		return attendence;
	}
	public Attendence findByIdInf(String id) throws Exception {
		String sql = "select * from attendenceInf where aid=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
				conn.prepareStatement(sql);
		pst.setString(1, id);
		ResultSet rs = pst.executeQuery();
		Attendence attendence =  null;
		if(rs.next()){
			attendence = new Attendence();
			attendence.setAid(rs.getString("aid"));
			attendence.setAempid(rs.getString("aempid"));
			attendence.setAtruename(rs.getString("atruename"));
			attendence.setAyear(rs.getString("ayear"));
			attendence.setAmonth(rs.getString("amonth"));
			attendence.setAlatecome(rs.getString("alatecome"));
			attendence.setAearlyleave(rs.getString("aearlyleave"));
			attendence.setAleave(rs.getString("aleave"));
			attendence.setAovertime(rs.getString("aovertime"));
			attendence.setAnegletwork(rs.getString("anegletwork"));
			attendence.setDept(rs.getString("dept"));
		}
		DbUtil.closeConnection();
		return attendence;
	}

	public void update(Attendence attendence) throws Exception {
		String sql = "update attendence set aempid=?,ayear=?,atruename=? ," +
				"amonth=?,alatecome=?,aearlyleave=?,aleave=? ,aovertime=?," +
				"anegletwork=? ,dept=? where aid=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
					conn.prepareStatement(sql);
	
		pst.setString(1,attendence.getAempid());
		pst.setString(2, attendence.getAyear());
		pst.setString(3, attendence.getAtruename());
		pst.setString(4,attendence.getAmonth());
		pst.setString(5, attendence.getAlatecome());
		pst.setString(6, attendence.getAearlyleave());
		pst.setString(7, attendence.getAleave());
		pst.setString(8, attendence.getAovertime());
		pst.setString(9, attendence.getAnegletwork());
		pst.setString(10,attendence.getDept());
		pst.setString(11,attendence.getAid());
		pst.executeUpdate();
		DbUtil.closeConnection();
		
	}
	public void updateInf(Attendence attendence) throws Exception {
		String sql = "update attendenceInf set aempid=?,ayear=?,atruename=? ," +
				"amonth=?,alatecome=?,aearlyleave=?,aleave=? ,aovertime=?," +
				"anegletwork=? ,dept=? where aid=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
				conn.prepareStatement(sql);
		
		pst.setString(1,attendence.getAempid());
		pst.setString(2, attendence.getAyear());
		pst.setString(3, attendence.getAtruename());
		pst.setString(4,attendence.getAmonth());
		pst.setString(5, attendence.getAlatecome());
		pst.setString(6, attendence.getAearlyleave());
		pst.setString(7, attendence.getAleave());
		pst.setString(8, attendence.getAovertime());
		pst.setString(9, attendence.getAnegletwork());
		pst.setString(10,attendence.getDept());
		pst.setString(11,attendence.getAid());
		pst.executeUpdate();
		DbUtil.closeConnection();
		
	}
	public void update1(Attendence attendence) throws Exception {
		String sql = "update attendence set aempid=?,ayear=?,atruename=? ," +
				"amonth=?,alatecome=?,aearlyleave=?,dept=? ,anegletwork=?, aleave=?, aovertime=? where aid=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
				conn.prepareStatement(sql);	
		pst.setString(1,attendence.getAempid());
		pst.setString(2, attendence.getAyear());
		pst.setString(3, attendence.getAtruename());
		pst.setString(4,attendence.getAmonth());
		pst.setString(5,attendence.getAlatecome());
		pst.setString(6,attendence.getAearlyleave());
		pst.setString(7,attendence.getDept());
		pst.setString(8,attendence.getAnegletwork());
		pst.setString(9,attendence.getAleave());
		pst.setString(10,attendence.getAovertime());
		pst.setString(11, attendence.getAid());
		pst.executeUpdate();
		DbUtil.closeConnection();
		
	}
	public void update2(Attendence attendence) throws Exception {
		String sql = "update attendence set aempid=?,atruename=? , dept =? , ayear=?,amonth=?,queqinday=?,koukuanmeici=? where aid=?";
		
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
				conn.prepareStatement(sql);	
		pst.setString(1,attendence.getAempid());
		pst.setString(2, attendence.getAtruename());
		pst.setString(3,attendence.getDept());
		pst.setString(4,attendence.getAyear());
		pst.setString(5,attendence.getAmonth());
		pst.setString(6,attendence.getQueqinday());
		pst.setString(7,attendence.getKoukuanmeici());
		pst.setString(8, attendence.getAid());
		pst.executeUpdate();
		DbUtil.closeConnection();
		
	}

	public void deleteById(String id) throws Exception {
		String sql="delete from attendenceInf where aid=?";
		Connection conn=DbUtil.getConnection();
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setString(1, id);
		pst.executeUpdate();
		DbUtil.closeConnection();
		
	}
	public void deleteByIdInf(String id) throws Exception {
		String sql="delete from attendenceInf where aid=?";
		Connection conn=DbUtil.getConnection();
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setString(1, id);
		pst.executeUpdate();
		DbUtil.closeConnection();
		
	}

	public List<Attendence> findAttendence(Attendence attendence)
			throws Exception {
		StringBuffer sql=new StringBuffer();
		sql.append("select * from attendence where 1=1");
		if(attendence.getAempid()!=null&&!attendence.getAempid().equals("")){
			sql.append(" and aempid like'%"+attendence.getAempid()+"%'");
		}
		if(attendence.getAtruename()!=null&&!attendence.getAtruename().equals("")){
			sql.append(" and atruename like'%"+attendence.getAtruename()+"%'");
		}
		sql.append(" and ayear like'%"+attendence.getAyear()+"%'");
		sql.append(" and amonth like'%"+attendence.getAmonth()+"%'");
		Connection conn = DbUtil.getConnection();
		Statement stmt=conn.createStatement();
		String str=sql.toString();
		ResultSet rs=stmt.executeQuery(str);
		Attendence a = null;
		List<Attendence> attendences=new ArrayList<Attendence>();
		while(rs.next()){
			a=new Attendence();
			a.setAid(rs.getString("aid"));
			a.setAempid(rs.getString("aempid"));
			a.setAtruename(rs.getString("atruename"));
			a.setAyear(rs.getString("ayear"));
			a.setAmonth(rs.getString("amonth"));
			a.setAlatecome(rs.getString("alatecome"));
			a.setAearlyleave(rs.getString("aearlyleave"));
			a.setAleave(rs.getString("aleave"));
			a.setAovertime(rs.getString("aovertime"));
			a.setAnegletwork(rs.getString("anegletwork"));
			attendences.add(a);
		}
		return attendences;
	}

	public List<Attendence> showAttendence() throws Exception {
		/*String sql="select  * from attendence";
		Connection conn = DbUtil.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		List<Attendence> list = new ArrayList<Attendence>();
		while(rs.next()){
			Attendence attendence = new Attendence();
			attendence.setEarlyLeave(rs.getString("earlyleave"));
			attendence.setAempid(rs.getString("empid"));
			attendence.setId(rs.getString("id"));
			attendence.setLateCome(rs.getString("latecome"));
			attendence.setLeaveDays(rs.getString("leavedays"));
			attendence.setMonth(rs.getString("month"));
			attendence.setWorkHour(rs.getString("workhour"));
			attendence.setYear(rs.getString("year"));
			attendence.setTruename(rs.getString("truename"));
			list.add(attendence);
		}
		DbUtil.closeConnection();*/
		return null;
	}
//、、、、、、、、、、、、、、、、、
	public AttendenceSet findAttendenceSet() throws Exception {
		String sql="select  * from attendenceset";
		Connection conn = DbUtil.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		AttendenceSet attendenceSet=null;
		if(rs.next()){
			attendenceSet=new AttendenceSet();
			attendenceSet.setCid(rs.getString("cid"));
			attendenceSet.setCearlyleave(rs.getString(("cearlyleave")));
			attendenceSet.setClatecome(rs.getString("clatecome"));

			attendenceSet.setCovertime(rs.getString("covertime"));
			attendenceSet.setCnegletwork(rs.getString("cnegletwork"));
			attendenceSet.setCleave(rs.getString("cleave"));
			attendenceSet.setQunuanbu(rs.getString("qunuanbu"));
			attendenceSet.setGongjijin(rs.getString("gongjijin"));
			attendenceSet.setYiliaoxian(rs.getString("yiliaoxian"));
		}
		return attendenceSet;
	}
	public AttendenceSet findAttendenceSetYeji() throws Exception {
		String sql="select  * from attendenceset";
		Connection conn = DbUtil.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		AttendenceSet attendenceSet=null;
		if(rs.next()){
			attendenceSet=new AttendenceSet();
			attendenceSet.setCid(rs.getString("cid"));
			attendenceSet.setCearlyleave(rs.getString(("cearlyleave")));
			attendenceSet.setClatecome(rs.getString("clatecome"));
			attendenceSet.setCearlyleave(rs.getString("cleave"));
			attendenceSet.setCovertime(rs.getString("covertime"));
			attendenceSet.setCnegletwork(rs.getString("cnegletwork"));
			attendenceSet.setCleave(rs.getString("cleave"));
		
		}
		return attendenceSet;
	}

	public void updateSet(AttendenceSet attendenceSet) throws Exception {
		String sql="update attendenceset set cearlyleave=?,clatecome=?, " +
				"cleave=?,covertime=?,cnegletwork=? ,gongjijin=? ,qunuanbu=? ,yiliaoxian=? where cid=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setString(1, attendenceSet.getCearlyleave());
		pst.setString(2,attendenceSet.getClatecome());
		pst.setString(3, attendenceSet.getCleave());
		pst.setString(4, attendenceSet.getCovertime());
		pst.setString(5, attendenceSet.getCnegletwork());
		pst.setString(6, attendenceSet.getGongjijin());
		pst.setString(7, attendenceSet.getQunuanbu());
		pst.setString(8, attendenceSet.getYiliaoxian());
		pst.setString(9, attendenceSet.getCid());
		pst.executeUpdate();
	}
	public void updateSetYeji(AttendenceSet attendenceSet) throws Exception {
		String sql="update attendenceset set cearlyleave=?,clatecome=?, " +
				"cleave=?,covertime=?,cnegletwork=? where cid=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setString(1, attendenceSet.getCearlyleave());
		pst.setString(2,attendenceSet.getClatecome());
		pst.setString(3, attendenceSet.getCleave());
		pst.setString(4, attendenceSet.getCovertime());
		pst.setString(5, attendenceSet.getCnegletwork());
		pst.setString(6, attendenceSet.getCid());
		pst.executeUpdate();
	}

	public List<Attendence> generateByMonth(int page, int pageSize,String year, String month)
			throws Exception {
		Connection conn = DbUtil.getConnection();
		//查询考勤信息,保存数据
				String sqlA="select * from attendence where ayear=? and amonth=? ";
				PreparedStatement pstA=conn.prepareStatement(sqlA);
				pstA.setString(1, year);
				pstA.setString(2, month);
				ResultSet rsA=pstA.executeQuery();
				List<Attendence> attendencesA=new ArrayList<Attendence>();
				Attendence attendenceA=null;
				while(rsA.next()){	
					attendenceA=new Attendence();
					attendenceA.setAid(rsA.getString("aid"));
					attendenceA.setAempid(rsA.getString("aempid"));
					attendenceA.setAtruename(rsA.getString("atruename"));
					attendenceA.setAyear(rsA.getString("ayear"));
					attendenceA.setAmonth(rsA.getString("amonth"));
					attendenceA.setAlatecome(rsA.getString("alatecome"));
					attendenceA.setAearlyleave(rsA.getString("aearlyleave"));
					attendenceA.setAleave(rsA.getString("aleave"));
					attendenceA.setAovertime(rsA.getString("aovertime"));
					attendenceA.setAnegletwork(rsA.getString("anegletwork"));
					attendencesA.add(attendenceA);
				}
		
		//删除当月信息
				String sqlDel="delete from attendence where ayear=? and amonth=? ";
				PreparedStatement pstDel=conn.prepareStatement(sqlDel);
				pstDel.setString(1, year);
				pstDel.setString(2, month);
				pstDel.executeUpdate();
		
		//查询所有员工
		String sqlEmpId = "select * from user";
		
		DbUtil.startTransaction();
		PreparedStatement pst=conn.prepareStatement(sqlEmpId);
		ResultSet rs=pst.executeQuery();
		List<User> emps = new ArrayList<User>();
		User emp=null;
		while(rs.next()){
			emp=new User();
			emp.setUid(rs.getString("uid"));
			emp.setUempid(rs.getString("uempid"));
			emp.setUtruename(rs.getString("utruename"));
			emps.add(emp);
		}
		
		//插入当月默认的考勤信息
		String sqlAdd="insert into attendence(aid,aempid,ayear,amonth,atruename,uid) values(?,?,?,?,?,?)";
		PreparedStatement pstAdd=conn.prepareStatement(sqlAdd);
		for(int i=0;i<emps.size();i++){
			User e=emps.get(i);
			UUID id=UUID.randomUUID();
			pstAdd.setString(1, id.toString());
			pstAdd.setString(2,e.getUempid());
			pstAdd.setString(3, year);
			pstAdd.setString(4, month);
			pstAdd.setString(5, e.getUtruename());
			pstAdd.setString(6, e.getUid());
			pstAdd.executeUpdate();
		}
		DbUtil.commit();
		DbUtil.closeConnection();
		conn = DbUtil.getConnection();
		
		//将原来的数据还原
		if(attendencesA!=null){
		String sqlUpdate = "update attendence set atruename=? ," +
				"alatecome=?,aearlyleave=?,aleave=? ,aovertime=?," +
				"anegletwork=?  where aempid=? and ayear=? and amonth=?";
//		conn = DbUtil.getConnection();
		PreparedStatement pstU = 
					conn.prepareStatement(sqlUpdate);
		for(int i=0;i<attendencesA.size();i++){
			Attendence attendence=attendencesA.get(i);
		
		pstU.setString(1, attendence.getAtruename());
		pstU.setString(2, attendence.getAlatecome());
		pstU.setString(3, attendence.getAearlyleave());
		pstU.setString(4, attendence.getAleave());
		pstU.setString(5, attendence.getAearlyleave());
		pstU.setString(6, attendence.getAnegletwork());
		pstU.setString(7,attendence.getAempid());
		pstU.setString(8, attendence.getAyear());
		pstU.setString(9,attendence.getAmonth());
		pstU.executeUpdate();
		}		
		}
		
		//查询考勤信息
		String sqlAttendence="select * from attendence where ayear=? and amonth=? limit ?,?";
		PreparedStatement pstAttendence=conn.prepareStatement(sqlAttendence);
		pstAttendence.setString(1, year);
		pstAttendence.setString(2, month);
		//设置分页查询参数
		int begin = (page-1)*pageSize;
		pstAttendence.setInt(3, begin);//设置抓取的起始点(从0开始)
		pstAttendence.setInt(4, pageSize);//设置最多抓取记录数
		ResultSet rsAttendence=pstAttendence.executeQuery();
		List<Attendence> attendences=new ArrayList<Attendence>();
		Attendence attendence=null;
		while(rsAttendence.next()){	
			attendence=new Attendence();
			attendence.setAid(rsAttendence.getString("aid"));
			attendence.setUid(rsAttendence.getString("uid"));
			attendence.setAempid(rsAttendence.getString("aempid"));
			attendence.setAtruename(rsAttendence.getString("atruename"));
			attendence.setAyear(rsAttendence.getString("ayear"));
			attendence.setAmonth(rsAttendence.getString("amonth"));
			attendence.setAlatecome(rsAttendence.getString("alatecome"));
			attendence.setAearlyleave(rsAttendence.getString("aearlyleave"));
			attendence.setAleave(rsAttendence.getString("aleave"));
			attendence.setAovertime(rsAttendence.getString("aovertime"));
			attendence.setAnegletwork(rsAttendence.getString("anegletwork"));
			attendences.add(attendence);
		}
		DbUtil.closeConnection();
		return attendences;
	}

	public boolean checkMonth(String year, String month) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void updateSetInf(AttendenceSet attendenceSet) throws Exception {
		// TODO Auto-generated method stub
		
	}
	

}






