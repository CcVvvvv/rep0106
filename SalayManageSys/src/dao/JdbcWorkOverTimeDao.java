package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import util.DbUtil;
import entity.AskForLeave;
import entity.WorkOverTime;


public class JdbcWorkOverTimeDao implements WorkOverTimeDao{
	public List<WorkOverTime> findAllInf(int page, int pageSize,String dept,String year,String month) throws Exception {
		Connection conn = DbUtil.getConnection();
		//��ѯ������Ϣ
		String sqlAttendence="select * from workovertime where dept=? and month=? and year=?";
		PreparedStatement pstAttendence=conn.prepareStatement(sqlAttendence);
		pstAttendence.setString(1, dept);
		pstAttendence.setString(3, year);
		pstAttendence.setString(2, month);
		//���÷�ҳ��ѯ����
//		int begin = (page-1)*pageSize;
//		pstAttendence.setInt(1, begin);//����ץȡ����ʼ��(��0��ʼ)
//		pstAttendence.setInt(2, pageSize);//�������ץȡ��¼��
		ResultSet rsAttendence=pstAttendence.executeQuery();
		List<WorkOverTime> workOverTimes=new ArrayList<WorkOverTime>();
		WorkOverTime workOverTime=null;
		while(rsAttendence.next()){
			workOverTime=new WorkOverTime();
			workOverTime.setUid(rsAttendence.getString("uid"));
			workOverTime.setDept(rsAttendence.getString("dept"));
			workOverTime.setDay(rsAttendence.getString("day"));
			workOverTime.setJiangjin(rsAttendence.getString("jiangjin"));
			workOverTime.setMonth(rsAttendence.getString("month"));
			workOverTime.setYear(rsAttendence.getString("year"));
		//	workOverTime.setReason(rsAttendence.getString("reason"));
			workOverTime.setSid(rsAttendence.getString("sid"));
			workOverTime.setGongzi(rsAttendence.getString("gongzi"));
			workOverTimes.add(workOverTime);
		}
		DbUtil.closeConnection();
		return workOverTimes;
	}
}
