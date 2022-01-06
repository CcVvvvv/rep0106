package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.UUID;

import util.DbUtil;
import entity.SalaryStandard;

public class JdbcSalaryStandardDao {
	public void save(SalaryStandard salaryStandard) throws Exception {
		String sql = "insert into salarystandard(zhiwei,dbasesalary,baoliu,jixiao,bufazi,duzibu,gongjijin," +
				"yiliaoxian,gongjijinjian,qunuanbu,did) values(?,?,?,?,?,?,?,?,?,?,?)";
		
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
					conn.prepareStatement(sql);
		UUID id=UUID.randomUUID();
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
		pst.setString(11, salaryStandard.getDid());
		pst.executeUpdate();
		DbUtil.closeConnection();
		
	}
	public void deleteById(String did) throws Exception {
		String sql = "delete from salarystandard where did=?";
		
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
				conn.prepareStatement(sql);
		UUID id=UUID.randomUUID();
		pst.setString(1,did);
		
		pst.executeUpdate();
		DbUtil.closeConnection();
		
	}
}
