package action.a1;

import java.util.List;

import action.BaseAction;
import util.Factory;
import dao.DeptDao;
import dao.EmpDao;
import dao.UserDao;
import entity.Dept;
import entity.User;

public class EmpAction extends BaseAction{
	private User emp;
	private List<Dept> deptList;

	public User getEmp() {
		return emp;
	}

	public void setEmp(User emp) {
		this.emp = emp;
	}
	
	
	public List<Dept> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<Dept> deptList) {
		this.deptList = deptList;
	}

	public String add(){
		EmpDao empDao=(EmpDao) Factory.getInstance("EmpDao");
		try {
			empDao.save(emp);
			return "addsuccess";
			} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}
	public String add1(){
		EmpDao empDao=(EmpDao) Factory.getInstance("EmpDao");
		try {
			empDao.save1(emp);
			return "add1";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}
	public String load(){
		EmpDao empDao=(EmpDao) Factory.getInstance("EmpDao");
	//	DeptDao deptDao=(DeptDao) Factory.getInstance("DeptDao");
		try {
			emp=empDao.findByIdEmp(emp.getUid());
		//	deptList=deptDao.showDept();
			return "load";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
	public String load2(){
		EmpDao empDao=(EmpDao) Factory.getInstance("EmpDao");
		DeptDao deptDao=(DeptDao) Factory.getInstance("DeptDao");
		try {
			String id=(String) session.get("userInfo");
			emp=empDao.findById(id);
			deptList=deptDao.showDept();
			return "update2";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	public String load3(){
		EmpDao empDao=(EmpDao) Factory.getInstance("EmpDao");
		DeptDao deptDao=(DeptDao) Factory.getInstance("DeptDao");
		try {
			String id=(String) session.get("userInfo");
			emp=empDao.findById(id);
			deptList=deptDao.showDept();
			return "changesuccess";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	public String load4(){
		EmpDao empDao=(EmpDao) Factory.getInstance("EmpDao");
	//	DeptDao deptDao=(DeptDao) Factory.getInstance("DeptDao");
		try {
			//String id=(String) session.get("userInfo");
			emp=empDao.findById(emp.getUid());	
		//	empDao.update(emp);
	//		deptList=deptDao.showDept();
			return "load4";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
	public String delete(){
		EmpDao empDao=(EmpDao) Factory.getInstance("EmpDao");
		try {
			empDao.deleteById(emp.getUid());
			return "delete";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
	public String update(){
			EmpDao empDao=(EmpDao) Factory.getInstance("EmpDao");
		try {
			empDao.update(emp);
			return "updatesuccess";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
	public String update1(){
		EmpDao empDao=(EmpDao) Factory.getInstance("EmpDao");
		try {
			empDao.update1(emp);
			return "update1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
	public String update2(){
		EmpDao empDao=(EmpDao) Factory.getInstance("EmpDao");
		try {
			empDao.update2(emp);
			return "update1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
}


