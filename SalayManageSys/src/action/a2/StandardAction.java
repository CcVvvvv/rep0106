package action.a2;

import util.Factory;
import dao.DeptDao;
import dao.JdbcSalaryStandardDao;
import dao.SalaryDao;
import dao.SalaryStandardDao;
import entity.SalaryStandard;

public class StandardAction {
	private SalaryStandard salaryStandard;

	public SalaryStandard getSalaryStandard() {
		return salaryStandard;
	}

	public void setSalaryStandard(SalaryStandard salaryStandard) {
		this.salaryStandard = salaryStandard;
	}
	public String add()
	{
		JdbcSalaryStandardDao salaryStandardDao = new JdbcSalaryStandardDao();
		try {
			salaryStandardDao.save(salaryStandard);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	public String load(){
		SalaryDao salaryDao=(SalaryDao) Factory.getInstance("SalaryDao");
		try {
			salaryStandard=salaryDao.loadStand(salaryStandard.getDid());
			return "loadsuccess";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
	
	public String update(){
		SalaryDao salaryDao=(SalaryDao) Factory.getInstance("SalaryDao");
		try {
			salaryDao.updateStand(salaryStandard);
			
			return "updatetwosuccess";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	public String delete(){
		JdbcSalaryStandardDao salaryStandardDao = new JdbcSalaryStandardDao();
		try {
			salaryStandardDao.deleteById(salaryStandard.getDid());
		//	salaryStandardDao.save(salaryStandard);
			return "delete";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}	
	}
}
