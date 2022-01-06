package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import util.DbUtil;
import entity.AskForLeave;


public class JdbcAskForLeaveDao implements AskForLeaveDao{
	public List<AskForLeave> findAllInf(int page, int pageSize,String dept,String year,String month) throws Exception {
		Connection conn = DbUtil.getConnection();
		//查询考勤信息
		String sqlAttendence="select * from askforleave where dept=? and month=? and year=?";
		PreparedStatement pstAttendence=conn.prepareStatement(sqlAttendence);
		pstAttendence.setString(1, dept);
		pstAttendence.setString(3, year);
		pstAttendence.setString(2, month);
		//设置分页查询参数
//		int begin = (page-1)*pageSize;
//		pstAttendence.setInt(1, begin);//设置抓取的起始点(从0开始)
//		pstAttendence.setInt(2, pageSize);//设置最多抓取记录数
		ResultSet rsAttendence=pstAttendence.executeQuery();
		List<AskForLeave> askForLeaves=new ArrayList<AskForLeave>();
		AskForLeave askForLeave=null;
		while(rsAttendence.next()){
			askForLeave=new AskForLeave();
			askForLeave.setUid(rsAttendence.getString("uid"));
			askForLeave.setDept(rsAttendence.getString("dept"));
			askForLeave.setDay(rsAttendence.getString("day"));
			askForLeave.setDeduction(rsAttendence.getString("deduction"));
			askForLeave.setMonth(rsAttendence.getString("month"));
			askForLeave.setYear(rsAttendence.getString("year"));
			askForLeave.setReason(rsAttendence.getString("reason"));
			askForLeave.setSid(rsAttendence.getString("sid"));
			askForLeave.setGongzi(rsAttendence.getString("gongzi"));
			askForLeaves.add(askForLeave);
		}
		DbUtil.closeConnection();
		return askForLeaves;
	}
}
