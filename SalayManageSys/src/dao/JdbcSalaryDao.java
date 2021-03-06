package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import util.DbUtil;
import entity.Attendence;
import entity.AttendenceSet;
import entity.Dept;
import entity.Insurance;
import entity.QueryInfomation;
import entity.Salary;
import entity.SalaryStandard;
import entity.User;

public class JdbcSalaryDao implements SalaryDao{

	public List<Salary> findAll(int page, int pageSize,String year,String month) throws Exception {
		String sql = "select * from salary where syear=? and smonth=? limit ?,?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
					conn.prepareStatement(sql);
		//设置分页查询参数
		int begin = (page-1)*pageSize;
		pst.setString(1, year);
		pst.setString(2, month);
		pst.setInt(3, begin);//设置抓取的起始点(从0开始)
		pst.setInt(20, pageSize);//设置最多抓取记录数
		ResultSet rs = pst.executeQuery();
		List<Salary> list = new ArrayList<Salary>();
		Salary salary=null;
		while(rs.next()){
			salary = new Salary();
			salary.setSid(rs.getString("sid"));
			salary.setUid(rs.getString("uid"));
			salary.setDept(rs.getString("dept"));
			salary.setSempid(rs.getString("sempid"));
			salary.setStruename(rs.getString("struename"));
			salary.setSyear(rs.getString("syear"));
			salary.setSmonth(rs.getString("smonth"));
			salary.setSbasesalary(rs.getDouble("sbasesalary"));
			salary.setXinji(rs.getDouble("xinji"));
			salary.setJintie(rs.getDouble("jintie"));
			salary.setDushengzibu(rs.getDouble("dushengzibu"));
			salary.setGongjijin(rs.getDouble("gongjijin"));
			salary.setYiliaoxian(rs.getDouble("yiliaoxian"));
			salary.setQunuanbu(rs.getDouble("qunuanbu"));
			salary.setJishuixiangmu(rs.getDouble("jishuixiangmu"));
			salary.setSuodeshui(rs.getDouble("suodeshui"));
			salary.setYingfa(rs.getDouble("yingfa"));
			salary.setYingkou(rs.getDouble("yingkou"));
			salary.setShifa(rs.getDouble("shifa"));
			salary.setKaoqin(rs.getDouble("kaoqin"));
			salary.setYeji(rs.getDouble("yeji"));
			/*//
			int yingf = Integer.parseInt(salary.getKaoqin())+Integer.parseInt(salary.getYeji())+Integer.parseInt(salary.getSbasesalary())+Integer.parseInt(salary.getXinji())+Integer.parseInt(salary.getJintie())+Integer.parseInt(salary.getGongjijin())+Integer.parseInt(salary.getDushengzibu())+Integer.parseInt(salary.getGongjijinbu())+Integer.parseInt(salary.getQunuanbu());
			
			salary.setYingfa(String.valueOf(yingf)) ;
			
			
			int yingk =( Integer.parseInt(salary.getYiliaoxian())+Integer.parseInt(salary.getGongjijinjian()));
			salary.setYingkou(String.valueOf(yingk));
			
			int shif = (Integer.parseInt(salary.getYingfa())-Integer.parseInt(salary.getYingkou()));
			
			salary.setShifa(String.valueOf(shif));
			//
*/			list.add(salary);
		}
		DbUtil.closeConnection();
		return list;	
	}
	public List<Salary> findAllYear(String year) throws Exception {
		String sql = "select * from salary where syear=? ";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
				conn.prepareStatement(sql);
		//设置分页查询参数
	//	int begin = (page-1)*pageSize;
		pst.setString(1, year);
	//	pst.setString(2, month);
	//	pst.setInt(3, begin);//设置抓取的起始点(从0开始)
	//	pst.setInt(20, pageSize);//设置最多抓取记录数
		ResultSet rs = pst.executeQuery();
		List<Salary> list = new ArrayList<Salary>();
		Salary salary=null;
		while(rs.next()){
			salary = new Salary();
			salary.setSid(rs.getString("sid"));
			salary.setUid(rs.getString("uid"));
			salary.setSyear(rs.getString("syear"));
			salary.setXiangmu(rs.getDouble("xiangmu"));
			salary.setDept(rs.getString("dept"));
			salary.setKeyan(rs.getString("keyan"));
			salary.setNianzhongjia(rs.getDouble("nianzhongjia"));
			salary.setKaoqin(rs.getDouble("kaoqin"));
			salary.setYeji(rs.getDouble("yeji"));
			/*//
			int yingf = Integer.parseInt(salary.getKaoqin())+Integer.parseInt(salary.getYeji())+Integer.parseInt(salary.getSbasesalary())+Integer.parseInt(salary.getXinji())+Integer.parseInt(salary.getJintie())+Integer.parseInt(salary.getGongjijin())+Integer.parseInt(salary.getDushengzibu())+Integer.parseInt(salary.getGongjijinbu())+Integer.parseInt(salary.getQunuanbu());
			
			salary.setYingfa(String.valueOf(yingf)) ;
			
			
			int yingk =( Integer.parseInt(salary.getYiliaoxian())+Integer.parseInt(salary.getGongjijinjian()));
			salary.setYingkou(String.valueOf(yingk));
			
			int shif = (Integer.parseInt(salary.getYingfa())-Integer.parseInt(salary.getYingkou()));
			
			salary.setShifa(String.valueOf(shif));*/
					list.add(salary);
		}
		DbUtil.closeConnection();
		return list;	
	}
	public List<Salary> findAllYear(String dept,String year) throws Exception {
		String sql = "select * from salaryInf where syear=? and dept=? ";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
				conn.prepareStatement(sql);
		//设置分页查询参数
		//	int begin = (page-1)*pageSize;
		pst.setString(1, year);
		pst.setString(2, dept);
		//	pst.setString(2, month);
		//	pst.setInt(3, begin);//设置抓取的起始点(从0开始)
		//	pst.setInt(20, pageSize);//设置最多抓取记录数
		ResultSet rs = pst.executeQuery();
		List<Salary> list = new ArrayList<Salary>();
		Salary salary=null;
		while(rs.next()){
			
			salary = new Salary();
			salary.setSid(rs.getString("sid"));
			salary.setUid(rs.getString("uid"));
			salary.setSyear(rs.getString("syear"));
			salary.setDept(rs.getString("dept"));
			salary.setZuizhongyeji(rs.getString("zuizhongyeji"));
			salary.setGongzuoliang(rs.getString("gongzuoliang"));
			salary.setJiaoyan(rs.getString("jiaoyan"));
			salary.setKeyan(rs.getString("keyan"));
			salary.setStruename(rs.getString("struename"));
			list.add(salary);
		}
		DbUtil.closeConnection();
		return list;	
	}
	public List<Salary> findAll2(String year) throws Exception {
		String sql = "select * from salaryInf where syear=? ";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
				conn.prepareStatement(sql);
		//设置分页查询参数
		//	int begin = (page-1)*pageSize;
		pst.setString(1, year);
		//	pst.setString(2, month);
		//	pst.setInt(3, begin);//设置抓取的起始点(从0开始)
		//	pst.setInt(20, pageSize);//设置最多抓取记录数
		ResultSet rs = pst.executeQuery();
		List<Salary> list = new ArrayList<Salary>();
		Salary salary=null;
		while(rs.next()){
			salary = new Salary();
			salary.setSid(rs.getString("sid"));
			salary.setUid(rs.getString("uid"));
			salary.setSyear(rs.getString("syear"));
			salary.setDept(rs.getString("dept"));
			salary.setZuizhongyeji(rs.getString("zuizhongyeji"));
			salary.setGongzuoliang(rs.getString("gongzuoliang"));
			salary.setJiaoyan(rs.getString("jiaoyan"));
			salary.setKeyan(rs.getString("keyan"));
			salary.setStruename(rs.getString("struename"));
			list.add(salary);
		}
		DbUtil.closeConnection();
		return list;	
	}
	public List<Salary> findAllDept(String dept) throws Exception {
		
		String sql = "select * from salary where dept=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
				conn.prepareStatement(sql);
		//设置分页查询参数
//		int begin = (page-1)*pageSize;
		pst.setString(1, dept);
//		pst.setInt(2, begin);//设置抓取的起始点(从0开始)
//		pst.setInt(2, pageSize);//设置最多抓取记录数
		ResultSet rs = pst.executeQuery();
		List<Salary> list = new ArrayList<Salary>();
		Salary salary=null;
		while(rs.next()){
			salary = new Salary();
			salary.setSid(rs.getString("sid"));
			salary.setUid(rs.getString("uid"));
			salary.setGusuangongzi(rs.getDouble("gusuangongzi"));
			salary.setDept(rs.getString("dept"));
			salary.setSempid(rs.getString("sempid"));
			salary.setStruename(rs.getString("struename"));
			salary.setSyear(rs.getString("syear"));
			salary.setSmonth(rs.getString("smonth"));
			salary.setSbasesalary(rs.getDouble("sbasesalary"));
			salary.setXinji(rs.getDouble("xinji"));
			salary.setJintie(rs.getDouble("jintie"));
			salary.setDushengzibu(rs.getDouble("dushengzibu"));
			salary.setGongjijin(rs.getDouble("gongjijin"));
			salary.setYiliaoxian(rs.getDouble("yiliaoxian"));
			salary.setQunuanbu(rs.getDouble("qunuanbu"));
			salary.setJishuixiangmu(rs.getDouble("jishuixiangmu"));
			salary.setSuodeshui(rs.getDouble("suodeshui"));
			salary.setYingfa(rs.getDouble("yingfa"));
			salary.setYingkou(rs.getDouble("yingkou"));
			salary.setShifa(rs.getDouble("shifa"));
			salary.setGongjijinjian(rs.getDouble("gongjijinjian"));
			salary.setGongjijinbu(rs.getDouble("gongjijinbu"));
			salary.setKaoqin(rs.getDouble("kaoqin"));
			salary.setYeji(rs.getDouble("yeji"));
			salary.setZuizhongyeji(rs.getString("zuizhongyeji"));
			//
						
			double yingf = salary.getYeji()+salary.getSbasesalary()+salary.getXinji()+salary.getJintie()+salary.getGongjijin()+salary.getDushengzibu()+salary.getGongjijinbu()+salary.getQunuanbu();						
			salary.setYingfa(yingf) ;
			
			salary.setJishuixiangmu(yingf);
			
			DecimalFormat de = new DecimalFormat("#######0.00");
			
			double gongjijinjian =yingf *0.2;			 			
			double yiliaoxian = yingf*0.015;
			double kaoqin = salary.getKaoqin();
			double bili;
			if(yingf >5000){
				bili = 0.015;
			}else {
				if(yingf >3500){
					bili =  0.01;
				}else {
					bili = 0;
				}
			}		
			double suodeshui = yingf * bili;
			
			
			String gString = de.format(gongjijinjian);
			String yString = de.format(yiliaoxian);
			String kString = de.format(kaoqin);
			String sString = de.format(suodeshui);
			
			salary.setGongjijinjian(Double.parseDouble(gString));
			salary.setYiliaoxian(Double.parseDouble(yString));
			salary.setSuodeshui(Double.parseDouble(sString));
			
			
			double yingk =suodeshui+ yiliaoxian+gongjijinjian+kaoqin;
			String yingkouString = de.format(yingk);		
			salary.setYingkou(Double.parseDouble(yingkouString));
			
			double shif = yingf - yingk ;	
			String shifaString = de.format(shif);
			salary.setShifa(Double.parseDouble(shifaString));
			///
			list.add(salary);
		}
		DbUtil.closeConnection();
		return list;	
	}

	
	public int countTotalPage(int pageSize) throws Exception {
		String sql = "select count(*) from salarystandard";
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
	
	public int countTotalPage2(int pageSize) throws Exception {
		String sql = "select count(*) from salary";
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
	
	public void saveSalarys(List<Salary> salarys) throws Exception {
		/*String Sql="select b.*,c.* from user a left join salary b on a.empid=b.empid ";
		String attendenceSetSql="select * from attendenceset";
		Connection conn=DbUtil.getConnection();
		PreparedStatement pst=conn.prepareStatement(attendenceSetSql);
		ResultSet rs=pst.executeQuery();
		AttendenceSet attendenceSet=null;
		if(rs.next()){
			attendenceSet=new AttendenceSet();
			attendenceSet.setId(rs.getString("id"));
			attendenceSet.setLateCome(rs.getDouble("latecome"));
			attendenceSet.setEarlyLeave(rs.getDouble("earlyleave"));
			attendenceSet.setAffairLeave(rs.getDouble("affairleave"));
			attendenceSet.setSickLeave(rs.getDouble("sickleave"));
		}*/
	}


	public void save(Salary salary) throws Exception {
		String sql = "insert into salaryInf(sid,uid,dept,syear," +			
				"gongzuoliang,keyan,jiaoyan,zuizhongyeji,struename) values(?,?,?,?,?,?,?,?,?)";
		
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst =conn.prepareStatement(sql);
	//	UUID id=UUID.randomUUID();
		pst.setString(1,salary.getSid());
		pst.setString(2, salary.getUid());
		pst.setString(3, salary.getDept());
		pst.setString(4, salary.getSyear());
		pst.setString(5, salary.getGongzuoliang());
		pst.setString(6, salary.getKeyan());
		pst.setString(7, salary.getJiaoyan());
		pst.setString(8, salary.getZuizhongyeji());
		pst.setString(9, salary.getStruename());
	
		pst.executeUpdate();
		DbUtil.closeConnection();
		
	}
	
	

	public Salary findById(String uid) throws Exception {
		String sql = "select * from salary where uid=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
					conn.prepareStatement(sql);
		pst.setString(1, uid);
		ResultSet rs = pst.executeQuery();
		Salary salary = null;
		if(rs.next()){
			salary=new Salary();
			salary.setSid(rs.getString("sid"));
			salary.setUid(rs.getString("uid"));
			salary.setSempid(rs.getString("sempid"));
			salary.setStruename(rs.getString("struename"));
			salary.setSyear(rs.getString("syear"));
			salary.setSmonth(rs.getString("smonth"));
			salary.setSbasesalary(rs.getDouble("sbasesalary"));
			salary.setXinji(rs.getDouble("xinji"));
			salary.setJintie(rs.getDouble("jintie"));
			salary.setDushengzibu(rs.getDouble("dushengzibu"));
			salary.setGongjijin(rs.getDouble("gongjijin"));
			salary.setYiliaoxian(rs.getDouble("yiliaoxian"));
			salary.setQunuanbu(rs.getDouble("qunuanbu"));
			salary.setJishuixiangmu(rs.getDouble("jishuixiangmu"));
			salary.setSuodeshui(rs.getDouble("suodeshui"));
			salary.setYingfa(rs.getDouble("yingfa"));
			salary.setYingkou(rs.getDouble("yingkou"));
			salary.setShifa(rs.getDouble("shifa"));
			salary.setKaoqin(rs.getDouble("kaoqin"));
			salary.setYeji(rs.getDouble("yeji"));
			/*//
			int yingf = Integer.parseInt(salary.getKaoqin())+Integer.parseInt(salary.getYeji())+Integer.parseInt(salary.getSbasesalary())+Integer.parseInt(salary.getXinji())+Integer.parseInt(salary.getJintie())+Integer.parseInt(salary.getGongjijin())+Integer.parseInt(salary.getDushengzibu())+Integer.parseInt(salary.getGongjijinbu())+Integer.parseInt(salary.getQunuanbu());
			
			salary.setYingfa(String.valueOf(yingf)) ;
			
			
			int yingk =( Integer.parseInt(salary.getYiliaoxian())+Integer.parseInt(salary.getGongjijinjian()));
			salary.setYingkou(String.valueOf(yingk));
			
			int shif = (Integer.parseInt(salary.getYingfa())-Integer.parseInt(salary.getYingkou()));
			
			salary.setShifa(String.valueOf(shif));*/
			//		
		}
		DbUtil.closeConnection();
		return salary;
		
	}
	public Salary findById1(String uid) throws Exception {
		String sql = "select * from salaryInf where uid=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
				conn.prepareStatement(sql);
		pst.setString(1, uid);
		ResultSet rs = pst.executeQuery();
		Salary salary = null;
		if(rs.next()){
			salary=new Salary();
			salary.setSid(rs.getString("sid"));
			salary.setUid(rs.getString("uid"));
			salary.setSyear(rs.getString("syear"));
			salary.setDept(rs.getString("dept"));
			salary.setGongzuoliang(rs.getString("gongzuoliang"));
			salary.setJiaoyan(rs.getString("jiaoyan"));
			salary.setKeyan(rs.getString("keyan"));
			salary.setZuizhongyeji(rs.getString("zuizhongyeji"));
			salary.setStruename(rs.getString("struename"));
		}
		DbUtil.closeConnection();
		return salary;
		
	}
	public Salary findById2(String uid) throws Exception {
		String sql = "select * from salaryInf where uid=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
				conn.prepareStatement(sql);
		pst.setString(1, uid);
		ResultSet rs = pst.executeQuery();
		Salary salary = null;
		if(rs.next()){
			salary=new Salary();
			salary.setSid(rs.getString("sid"));
			salary.setUid(rs.getString("uid"));
			salary.setSyear(rs.getString("syear"));
			salary.setDept(rs.getString("dept"));
			salary.setKeyan(rs.getString("keyan"));
			salary.setZuizhongyeji(rs.getString("zuizhongyeji"));
			salary.setGongzuoliang(rs.getString("gongzuoliang"));
			salary.setJiaoyan(rs.getString("jiaoyan"));
			salary.setStruename(rs.getString("struename"));
			
			
			
		}
		DbUtil.closeConnection();
		return salary;
		
	}
	public Salary findByIYM(String uid,String year,String month) throws Exception {
		String sql = "select * from salary where uid=? and syear=? and smonth=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
				conn.prepareStatement(sql);
		pst.setString(1, uid);
		pst.setString(2, year);
		pst.setString(3, month);
		ResultSet rs = pst.executeQuery();
		Salary salary = null;
		if(rs.next()){
			salary=new Salary();
			salary.setSid(rs.getString("sid"));
			salary.setUid(rs.getString("uid"));
			salary.setSempid(rs.getString("sempid"));
			salary.setStruename(rs.getString("struename"));
			salary.setSyear(rs.getString("syear"));
			salary.setSmonth(rs.getString("smonth"));
			salary.setSbasesalary(rs.getDouble("sbasesalary"));
			salary.setXinji(rs.getDouble("xinji"));
			salary.setJintie(rs.getDouble("jintie"));
			salary.setDushengzibu(rs.getDouble("dushengzibu"));
			salary.setGongjijin(rs.getDouble("gongjijin"));
			salary.setYiliaoxian(rs.getDouble("yiliaoxian"));
			salary.setQunuanbu(rs.getDouble("qunuanbu"));
			salary.setJishuixiangmu(rs.getDouble("jishuixiangmu"));
			salary.setSuodeshui(rs.getDouble("suodeshui"));
			salary.setYingfa(rs.getDouble("yingfa"));
			salary.setYingkou(rs.getDouble("yingkou"));
			salary.setShifa(rs.getDouble("shifa"));
			salary.setGongjijinbu(rs.getDouble("gongjijinbu"));
			salary.setGongjijinjian(rs.getDouble("gongjijinjian"));
			salary.setKaoqin(rs.getDouble("kaoqin"));
			salary.setYeji(rs.getDouble("yeji"));
						
			double yingf = salary.getYeji()+salary.getSbasesalary()+salary.getXinji()+salary.getJintie()+salary.getGongjijin()+salary.getDushengzibu()+salary.getGongjijinbu()+salary.getQunuanbu();						
			salary.setYingfa(yingf) ;
			
			salary.setJishuixiangmu(yingf);
			
			DecimalFormat de = new DecimalFormat("#######0.00");
			
			double gongjijinjian =yingf *0.2;			 			
			double yiliaoxian = yingf*0.015;
			double kaoqin = salary.getKaoqin();
			double bili;
			if(yingf >5000){
				bili = 0.015;
			}else {
				if(yingf >3500){
					bili =  0.01;
				}else {
					bili = 0;
				}
			}		
			double suodeshui = yingf * bili;
			
			
			String gString = de.format(gongjijinjian);
			String yString = de.format(yiliaoxian);
			String kString = de.format(kaoqin);
			String sString = de.format(suodeshui);
			
			salary.setGongjijinjian(Double.parseDouble(gString));
			salary.setYiliaoxian(Double.parseDouble(yString));
			salary.setSuodeshui(Double.parseDouble(sString) );

			
			double yingk =suodeshui+ yiliaoxian+gongjijinjian+kaoqin;
			String yingkouString = de.format(yingk);		
			salary.setYingkou(Double.parseDouble(yingkouString));
			
			double shif = yingf - yingk ;	
			String shifaString = de.format(shif);
			salary.setShifa(Double.parseDouble(shifaString));
			///
		
			/*int yingf = Integer.parseInt(salary.getKaoqin())+Integer.parseInt(salary.getYeji())+Integer.parseInt(salary.getSbasesalary())+Integer.parseInt(salary.getXinji())+Integer.parseInt(salary.getJintie())+Integer.parseInt(salary.getGongjijin())+Integer.parseInt(salary.getDushengzibu())+Integer.parseInt(salary.getGongjijinbu())+Integer.parseInt(salary.getQunuanbu());
			
			salary.setYingfa(String.valueOf(yingf)) ;
			
			
			int yingk =( Integer.parseInt(salary.getSuodeshui())+ Integer.parseInt(salary.getYiliaoxian())+Integer.parseInt(salary.getGongjijinjian()));
			salary.setYingkou(String.valueOf(yingk));
			
			int shif = (Integer.parseInt(salary.getYingfa())-Integer.parseInt(salary.getYingkou()));
			
			salary.setShifa(String.valueOf(shif));*/
		}
		DbUtil.closeConnection();
		return salary;
		
	}

	public void update(Salary salary) throws Exception {
	/*	String sql = "update salary set sempid=?,struename=?," +
				"syear=?,smonth=?,sbasesalary=?,sfinalsalary=?,sinsurance=?,sattendencefee=?  where sid=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
					conn.prepareStatement(sql);
		UUID id=UUID.randomUUID();
		pst.setString(1,id.toString());
		pst.setString(2, salary.getEmpId());
		pst.setString(3, salary.getTrueName());
		pst.setString(4, salary.getYear());
		pst.setString(5, salary.getMonth());
		pst.setDouble(6, salary.getBaseSalary());
		pst.setDouble(7, salary.getFinalSalary());
		pst.setDouble(8, salary.getInsurance());
		pst.setDouble(9, salary.getAttendenceFee());
		pst.executeUpdate();
		DbUtil.closeConnection();*/
		
	}
	public void update1(Salary salary) throws Exception {
			String sql = "update salary set dept=?,syear=?,"
					+ "xiangmu=?,keyan=?,nianzhongjia=?  where uid=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
					conn.prepareStatement(sql);
	//	UUID id=UUID.randomUUID();
	//	pst.setString(1,salary.getUid());
		pst.setString(1, salary.getDept());
		pst.setString(2, salary.getSyear());
		pst.setDouble(3, salary.getXiangmu());
		pst.setString(4, salary.getKeyan());
		pst.setDouble(5, salary.getNianzhongjia());
		pst.setString(6,salary.getUid());
		pst.executeUpdate();
		DbUtil.closeConnection();
		
	}
	public void update2(Salary salary) throws Exception {
		String sql = "update salaryInf set dept=?,syear=?,"
				+ "gongzuoliang=?,jiaoyan=?,keyan=? ,zuizhongyeji=?,sid=? ,struename=? where uid=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
				conn.prepareStatement(sql);
		//	UUID id=UUID.randomUUID();
		//	pst.setString(1,salary.getUid());
		pst.setString(1, salary.getDept());
		pst.setString(2, salary.getSyear());
		pst.setString(3, salary.getGongzuoliang());
		pst.setString(4, salary.getJiaoyan());
		pst.setString(5, salary.getKeyan());
		pst.setString(6, salary.getZuizhongyeji());
		pst.setString(7, salary.getSid());
		pst.setString(8,salary.getStruename());
		pst.setString(9,salary.getUid());
		pst.executeUpdate();
		DbUtil.closeConnection();
		
	}

	public void deleteById(String id) throws Exception {
		String sql="delete from salaryInf where uid=?";
		Connection conn=DbUtil.getConnection();
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setString(1, id);
		pst.executeUpdate();
		DbUtil.closeConnection();
	}

	

	public List<Salary> showSalary() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
//
//	public List<Salary> saveSalarysByMonth(int page, int pageSize,String year,String month) throws Exception {
//		//查询所有员工的考勤信息、工资标准、考勤奖罚信息
//				String sql = "select   a.*,b.* from salarystandard   a join attendence b " +
//						"on a.dempid=b.aempid where b.ayear=? and b.amonth=?";
//				Connection conn = DbUtil.getConnection();
//				DbUtil.startTransaction();
//				PreparedStatement pst=conn.prepareStatement(sql);
//				pst.setString(1, year);
//				pst.setString(2, month);
//				ResultSet rs=pst.executeQuery();
//				List<QueryInfomation> infos = new ArrayList<QueryInfomation>();
//				QueryInfomation info=null;
//				while(rs.next()){
//					info=new QueryInfomation();
//					info.setEmpId(rs.getString("aempid"));
//					info.setTrueName(rs.getString("atruename"));
//					info.setYear(rs.getString("ayear"));
//					info.setMonth(rs.getString("amonth"));
//					info.setBaseSalary(rs.getDouble("dbasesalary"));
//					info.setLateCome(rs.getInt("alatecome"));
//					info.setEarlyLeave(rs.getInt("aearlyleave"));
//					info.setLeave(rs.getInt("aleave"));
//					info.setOvertime(rs.getInt("aovertime"));
//					info.setNegletwork(rs.getInt("anegletwork"));
//					info.setUid(rs.getString("uid"));
//					infos.add(info);
//				}
//				
//				String sql2 = "select * from attendenceset";
//				PreparedStatement pst2=conn.prepareStatement(sql2);
//				ResultSet rs2=pst2.executeQuery();
//				AttendenceSet attendenceSet=null;
//				if(rs2.next()){
//					attendenceSet=new AttendenceSet();
//					
//					attendenceSet.setCid(rs2.getString("cid"));
//					attendenceSet.setClatecome(rs2.getString("clatecome"));
//					attendenceSet.setCearlyleave(rs2.getString("cearlyleave"));
//					attendenceSet.setCleave(rs2.getString("cleave"));
//					attendenceSet.setCovertime(rs2.getString("covertime"));
//					attendenceSet.setCnegletwork(rs2.getString("cnegletwork"));
//					
//				}
//				String sqlDel="delete from salary where syear=? and smonth=? ";
//				PreparedStatement pstDel=conn.prepareStatement(sqlDel);
//				pstDel.setString(1, year);
//				pstDel.setString(2, month);
//				pstDel.executeUpdate();
//				
//				String sqlIn="select  * from insurance";
//				conn = DbUtil.getConnection();
//				Statement stmt=conn.createStatement();
//				ResultSet rsIn=stmt.executeQuery(sqlIn);
//				Insurance insurance=null;
//				if(rsIn.next()){
//					insurance=new Insurance();
//					insurance.setId(rsIn.getString("id"));
//					insurance.setBear(rsIn.getString("bear"));
//					insurance.setHouse(rsIn.getString("house"));
//					insurance.setInjury(rsIn.getString("injury"));
//					insurance.setMedical(rsIn.getString("medical"));
//					insurance.setOld(rsIn.getString("old"));
//					insurance.setUnemployment(rsIn.getString("unemployment"));
//				}
//				
//				
//				
//				//插入当月的考勤信息
//				String sql3="insert into salary(sid,sempid,struename,syear,smonth,sbasesalary,sfinalsalary,slatecome," +
//						"searlyleave,sleave,sovertime,snegletwork,sold,sunemployment,sinjury,sbear,smedical,shouse,uid) " +
//						"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//				PreparedStatement pst3=conn.prepareStatement(sql3);
//				for(int i=0;i<infos.size();i++){
//					info=infos.get(i);
//					
//					double finalSalary=info.getBaseSalary()-info.getLateCome()*attendenceSet.getClatecome()
//							-info.getEarlyleave()*attendenceSet.getCearlyleave()
//							-info.getLeave()*attendenceSet.getCearlyleave()
//							+info.getOvertime()*attendenceSet.getCovertime()
//							-info.getNegletwork()*attendenceSet.getNegletwork();
//					
//					double finalSal=info.getBaseSalary()-finalSalary*insurance.getOld()/100-finalSalary*insurance.getUnemployment()/100
//														-finalSalary*insurance.getInjury()/100-finalSalary*insurance.getBear()/100
//														-finalSalary*insurance.getMedical()/100-finalSalary*insurance.getHouse()/100;
//					
//					int s=(int) (finalSal);
//					UUID id=UUID.randomUUID();
//					pst3.setString(1, id.toString());
//					pst3.setString(2, info.getEmpId());
//					pst3.setString(3, info.getTrueName());
//					pst3.setString(4, info.getYear());
//					pst3.setString(5, info.getMonth());
//					pst3.setDouble(6, info.getBaseSalary());
//					pst3.setDouble(7, s);
//					pst3.setString(8, info.getLateCome()*attendenceSet.getClatecome());
//					pst3.setString(9, info.getEarlyLeave()*attendenceSet.getCearlyleave());
//					pst3.setString(10, info.getLeave()*attendenceSet.getCearlyleave());
//					pst3.setString(11, info.getOvertime()*attendenceSet.getCovertime());
//					pst3.setString(12, info.getNegletwork()*attendenceSet.getNegletwork());
//					pst3.setString(13, finalSalary*insurance.getOld()/100);
//					pst3.setString(14, finalSalary*insurance.getUnemployment()/100);
//					pst3.setString(15, finalSalary*insurance.getInjury()/100);
//					pst3.setString(16, finalSalary*insurance.getBear()/100);
//					pst3.setString(17, finalSalary*insurance.getMedical()/100);
//					pst3.setString(18, finalSalary*insurance.getHouse()/100);
//					pst3.setString(19, info.getUid());
//					pst3.executeUpdate();
//				}
//				
//				DbUtil.commit();
//				DbUtil.closeConnection();
//				
//				
//				conn = DbUtil.getConnection();
//				
//				//查询工资信息
//				String sqlSalary="select * from salary where syear=? and smonth=? limit ?,?";
//				PreparedStatement pstSalary=conn.prepareStatement(sqlSalary);
//				pstSalary.setString(1, year);
//				pstSalary.setString(2, month);
//				//设置分页查询参数
//				int begin = (page-1)*pageSize;
//				pstSalary.setInt(3, begin);//设置抓取的起始点(从0开始)
//				pstSalary.setInt(4, pageSize);//设置最多抓取记录数
//				ResultSet rsSalary=pstSalary.executeQuery();
//				List<Salary> salarys=new ArrayList<Salary>();
//				Salary salary=null;
//				while(rsSalary.next()){
//					salary=new Salary();
//					salary.setSid(rsSalary.getString("sid"));
//					salary.setSempid(rsSalary.getString("sempid"));
//					salary.setStruename(rsSalary.getString("struename"));
//					salary.setSyear(rsSalary.getString("syear"));
//					salary.setSmonth(rsSalary.getString("smonth"));
//					salary.setSbasesalary(rsSalary.getString("sbasesalary"));
//					salary.setXinji(rsSalary.getString("xinji"));
//					salary.setJintie(rsSalary.getString("jintie"));
//					salary.setDushengzibu(rsSalary.getString("dushengzibu"));
//					salary.setGongjijin(rsSalary.getString("gongjijin"));
//					salary.setYiliaoxian(rsSalary.getString("yiliaoxian"));
//					salary.setQunuanbu(rsSalary.getString("qunuanbu"));
//					salary.setJishuixiangmu(rsSalary.getString("jishuixiangmu"));
//					salary.setSuodeshui(rsSalary.getString("suodeshui"));
//					salary.setYingfa(rsSalary.getString("yingfa"));
//					salary.setYingkou(rsSalary.getString("yingkou"));
//					salary.setShifa(rsSalary.getString("shifa"));				
//					salarys.add(salary);
//				}
//				DbUtil.closeConnection();
//				return salarys;
//	}

	
	
	
	public List<SalaryStandard> findStand(SalaryStandard salaryStand) throws Exception {
		StringBuffer sql=new StringBuffer();
		sql.append("select * from salarystandard where 1=1");
		if(salaryStand.getDid()!=null&&!salaryStand.getDid().equals("")){
			sql.append(" and dempid like'%"+salaryStand.getDid()+"%'");
		}
		if(salaryStand.getDtruename()!=null&&!salaryStand.getDtruename().equals("")){
			sql.append(" and dtruename like'%"+salaryStand.getDtruename()+"%'");
		}
		Connection conn = DbUtil.getConnection();
		Statement stmt=conn.createStatement();
		String str=sql.toString();
		ResultSet rs=stmt.executeQuery(str);
		List<SalaryStandard> list = new ArrayList<SalaryStandard>();
		SalaryStandard salaryStandard=null;
		while(rs.next()){
			salaryStandard=new SalaryStandard();
			salaryStandard.setDbasesalary(rs.getString("dbasesalary"));	
			salaryStandard.setDempid(rs.getString("dempid"));
			salaryStandard.setDid(rs.getString("did"));
			salaryStandard.setDtruename(rs.getString("dtruename"));
			list.add(salaryStandard);
		}
		DbUtil.closeConnection();
		return list;
	}

	public SalaryStandard loadStand(String id) throws Exception {
		String sql = "select * from salarystandard where did=?";
		
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
					conn.prepareStatement(sql);
		pst.setString(1, id);
		ResultSet rs=pst.executeQuery();
		SalaryStandard salaryStandard=null;
		if(rs.next()){
			salaryStandard=new SalaryStandard();
			salaryStandard.setDid(rs.getString("did"));
			salaryStandard.setDempid(rs.getString("dempid"));
			salaryStandard.setUid(rs.getString("uid"));
			salaryStandard.setDtruename(rs.getString("dtruename"));
			salaryStandard.setDbasesalary(rs.getString("dbasesalary"));	
			salaryStandard.setZhiwei(rs.getString("zhiwei"));
			salaryStandard.setBaoliu(rs.getString("baoliu"));
			salaryStandard.setQunuanbu(rs.getString("qunuanbu"));
			salaryStandard.setJixiao(rs.getString("jixiao"));
			salaryStandard.setBufazi(rs.getString("bufazi"));
			salaryStandard.setDuzibu(rs.getString("duzibu"));
			salaryStandard.setGongjijin(rs.getString("gongjijin"));
			salaryStandard.setGongjijinjian(rs.getString("gongjijinjian"));
			salaryStandard.setYiliaoxian(rs.getString("yiliaoxian"));
			
		}
		return salaryStandard;
	}

	public void updateStand(SalaryStandard salaryStandard) throws Exception {
		String sql = "update salarystandard set zhiwei=?," +
				    "dbasesalary=? ,baoliu=?  ,jixiao=? ,bufazi=? ,duzibu=? ,gongjijin=?"
				    + " ,yiliaoxian=? ,gongjijinjian=? ,qunuanbu=?where did=?";
		Connection conn = DbUtil.getConnection();
	
		PreparedStatement pst = 
					conn.prepareStatement(sql);
		pst.setString(11,salaryStandard.getDid());
		pst.setString(1,salaryStandard.getZhiwei());
		pst.setString(2, salaryStandard.getDbasesalary());
		pst.setString(3, salaryStandard.getBaoliu());
		pst.setString(4, salaryStandard.getJixiao());
		pst.setString(5, salaryStandard.getBufazi());
		pst.setString(6, salaryStandard.getDuzibu());
		pst.setString(7, salaryStandard.getGongjijin());
		pst.setString(8, salaryStandard.getYiliaoxian());
		pst.setString(9, salaryStandard.getGongjijinjian());
		pst.setString(10, salaryStandard.getQunuanbu());
	
		pst.executeUpdate();
		DbUtil.closeConnection();
	}

	public List<Salary> findSalary(Salary salary) throws Exception {
		StringBuffer sql=new StringBuffer();
		sql.append("select * from salary where 1=1");
		if(salary.getSempid()!=null&&!salary.getSempid().equals("")){
			sql.append(" and sempid like'%"+salary.getSempid()+"%'");
		}
		if(salary.getStruename()!=null&&!salary.getStruename().equals("")){
			sql.append(" and struename like'%"+salary.getStruename()+"%'");
		}
		sql.append(" and syear like'%"+salary.getSyear()+"%'");
		sql.append(" and smonth like'%"+salary.getSmonth()+"%'");
		Connection conn = DbUtil.getConnection();
		Statement stmt=conn.createStatement();
		String str=sql.toString();
		ResultSet rs=stmt.executeQuery(str);
		Salary s = null;
		List<Salary> salarys=new ArrayList<Salary>();
		while(rs.next()){
			s=new Salary();
			s.setSid(rs.getString("sid"));
			s.setSempid(rs.getString("sempid"));
			s.setStruename(rs.getString("struename"));
			s.setSyear(rs.getString("syear"));
			s.setSmonth(rs.getString("smonth"));
			s.setDept(rs.getString("dept"));
			s.setSbasesalary(rs.getDouble("sbasesalary"));
			s.setXinji(rs.getDouble("xinji"));
			s.setJintie(rs.getDouble("jintie"));
			s.setDushengzibu(rs.getDouble("dushengzibu"));
			s.setGongjijin(rs.getDouble("gongjijin"));
			s.setYiliaoxian(rs.getDouble("yiliaoxian"));
			s.setQunuanbu(rs.getDouble("qunuanbu"));
			s.setJishuixiangmu(rs.getDouble("jishuixiangmu"));
			s.setSuodeshui(rs.getDouble("suodeshui"));
			s.setYingfa(rs.getDouble("yingfa"));
			s.setYingkou(rs.getDouble("yingkou"));
			s.setShifa(rs.getDouble("shifa"));
			salarys.add(s);
		}
		return salarys;
	}

	public List<SalaryStandard> findStandAll(int page, int pageSize)
			throws Exception {
		String sql = "select * from salarystandard limit ?,?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
					conn.prepareStatement(sql);
		//设置分页查询参数
		int begin = (page-1)*pageSize;
		pst.setInt(1, begin);//设置抓取的起始点(从0开始)
		pst.setInt(2, pageSize);//设置最多抓取记录数
		ResultSet rs = pst.executeQuery();
		List<SalaryStandard> salaryStandards = new ArrayList<SalaryStandard>();
		SalaryStandard salaryStandard=null;
		while(rs.next()){
			salaryStandard=new SalaryStandard();
			salaryStandard.setDid(rs.getString("did"));		
			salaryStandard.setZhiwei(rs.getString("zhiwei"));
			salaryStandard.setDempid(rs.getString("dempid"));
			salaryStandard.setUid(rs.getString("uid"));
			salaryStandard.setDtruename(rs.getString("dtruename"));
			salaryStandard.setDbasesalary(rs.getString("dbasesalary"));
			salaryStandard.setQunuanbu(rs.getString("qunuanbu"));
			salaryStandard.setGongjijinjian(rs.getString("gongjijinjian"));
			salaryStandard.setYiliaoxian(rs.getString("yiliaoxian"));
			salaryStandard.setGongjijin(rs.getString("gongjijin"));
			salaryStandard.setDuzibu(rs.getString("duzibu"));
			salaryStandard.setBufazi(rs.getString("bufazi"));
			salaryStandard.setJixiao(rs.getString("jixiao"));
			salaryStandard.setBaoliu(rs.getString("baoliu"));		
			salaryStandards.add(salaryStandard);
		}
		DbUtil.closeConnection();
		return salaryStandards;
	}
	public List<SalaryStandard> findStandAllZhiwei(String zhiwei)
			throws Exception {
		String sql = "select * from salarystandard where zhiwei=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
				conn.prepareStatement(sql);
		//设置分页查询参数
//		int begin = (page-1)*pageSize;
		pst.setString(1, zhiwei);
//		pst.setInt(2, begin);//设置抓取的起始点(从0开始)
//		pst.setInt(3, pageSize);//设置最多抓取记录数
		ResultSet rs = pst.executeQuery();
		List<SalaryStandard> salaryStandards = new ArrayList<SalaryStandard>();
		SalaryStandard salaryStandard=null;
		while(rs.next()){
			salaryStandard=new SalaryStandard();
			salaryStandard.setDid(rs.getString("did"));		
			salaryStandard.setZhiwei(rs.getString("zhiwei"));
			salaryStandard.setDempid(rs.getString("dempid"));
			salaryStandard.setUid(rs.getString("uid"));
			salaryStandard.setDtruename(rs.getString("dtruename"));
			salaryStandard.setDbasesalary(rs.getString("dbasesalary"));
			salaryStandard.setQunuanbu(rs.getString("qunuanbu"));
			salaryStandard.setGongjijinjian(rs.getString("gongjijinjian"));
			salaryStandard.setYiliaoxian(rs.getString("yiliaoxian"));
			salaryStandard.setGongjijin(rs.getString("gongjijin"));
			salaryStandard.setDuzibu(rs.getString("duzibu"));
			salaryStandard.setBufazi(rs.getString("bufazi"));
			salaryStandard.setJixiao(rs.getString("jixiao"));
			salaryStandard.setBaoliu(rs.getString("baoliu"));		
			salaryStandards.add(salaryStandard);
		}
		DbUtil.closeConnection();
		return salaryStandards;
	}

	public Insurance findInsurance() throws Exception {
		String sql="select  * from insurance";
		Connection conn = DbUtil.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		Insurance insurance=null;
		if(rs.next()){
			insurance=new Insurance();
			insurance.setId(rs.getString("id"));
			insurance.setBear(rs.getString("bear"));
			insurance.setHouse(rs.getString("house"));
			insurance.setInjury(rs.getString("injury"));
			insurance.setMedical(rs.getString("medical"));
			insurance.setOld(rs.getString("old"));
			insurance.setUnemployment(rs.getString("unemployment"));
		}
		return insurance;
	}

	public void updateInsurance(Insurance insurance) throws Exception {
		String sql="update insurance set bear=?,house=?, " +
				"injury=?,medical=?,old=?,unemployment=? where id=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst=conn.prepareStatement(sql);
//		pst.setInt(1, insurance.getBear());
//		pst.setInt(2, insurance.getHouse());
//		pst.setInt(3, insurance.getInjury());
//		pst.setInt(4, insurance.getMedical());
//		pst.setInt(5, insurance.getOld());
//		pst.setInt(6, insurance.getUnemployment());
//		pst.setString(7, insurance.getId());
//		pst.executeUpdate();
		
	}

	@Override
	public List<Salary> saveSalarysByMonth(int page, int pageSize, String year,
			String month) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Salary> findAll1(String year) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}



