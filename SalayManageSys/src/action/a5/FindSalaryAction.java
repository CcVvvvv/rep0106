package action.a5;

import java.util.ArrayList;
import java.util.List;

import util.Factory;
import dao.DeptDao;
import dao.SalaryDao;
import dao.UserDao;
import entity.Dept;
import entity.Salary;
import entity.User;

public class FindSalaryAction {
	private Salary salary;
	private List<Dept> deptList;
	private Dept dept;
	private List<Salary> salarys;
	private Integer month;
	private List monthList;
	
	private List<User> userList;
	private User user;
	
	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	public List<Salary> getSalarys() {
		return salarys;
	}

	public void setSalarys(List<Salary> salarys) {
		this.salarys = salarys;
	}
	
	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public List getMonthList() {
		return monthList;
	}

	public void setMonthList(List monthList) {
		this.monthList = monthList;
	}



	public List<Dept> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<Dept> deptList) {
		this.deptList = deptList;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String execute(){
		SalaryDao salaryDao=(SalaryDao) Factory.getInstance("SalaryDao");
		DeptDao deptDao=(DeptDao) Factory.getInstance("DeptDao");
		try {
//			month = Integer.parseInt(salary.getSmonth());
//			monthList =new ArrayList();
//			for(int i=1;i<=12;i++){
//				monthList.add(i);
//			}
		//	salarys=salaryDao.findSalary(salary);
	//		deptList=deptDao.findDept("人事处", "张三");
	//		userList=UserDao
	//	    dept=deptList.get(1);
			return "find";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
}
