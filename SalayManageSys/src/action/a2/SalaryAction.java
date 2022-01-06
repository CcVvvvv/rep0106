package action.a2;

import util.Factory;
import dao.SalaryDao;
import entity.Salary;

public class SalaryAction {
	private Salary salary;

	public Salary getSalary() {
		return salary;
	}
	public void setSalary(Salary salary) {
		this.salary = salary;
	}
	public String add(){
		SalaryDao salaryDao=(SalaryDao) Factory.getInstance("SalaryDao");
		try {
			salaryDao.save(salary);
			return "list";
			} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}
	public String load(){
		SalaryDao salaryDao=(SalaryDao) Factory.getInstance("SalaryDao");
		try {
			salary=salaryDao.findById2(salary.getUid());
			return "load";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
	public String delete(){
		SalaryDao salaryDao=(SalaryDao) Factory.getInstance("SalaryDao");
		try {
//			salaryDao.deleteById(salary.getId());
			return "list";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
	public String update(){
		SalaryDao salaryDao=(SalaryDao) Factory.getInstance("SalaryDao");
		try {
			salaryDao.update2(salary);
			return "list";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
}
