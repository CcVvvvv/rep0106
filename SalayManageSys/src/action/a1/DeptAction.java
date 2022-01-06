package action.a1;

import java.util.List;

import dao.DeptDao;
import util.Factory;

import entity.Dept;

public class DeptAction {
	private Dept dept;
	
	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}
	
	public String add(){
		DeptDao deptDao=(DeptDao) Factory.getInstance("DeptDao");
		try {
			deptDao.save(dept);
			return "addsuccess";
			} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}
	public String load(){
		DeptDao deptDao=(DeptDao) Factory.getInstance("DeptDao");
		try {
			dept=deptDao.findById(dept.getId());
			return "update";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
	public String delete(){
		DeptDao deptDao=(DeptDao) Factory.getInstance("DeptDao");
		try {
			deptDao.deleteById(dept.getId());
			return "deletesuccess";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
	public String update(){
		DeptDao deptDao=(DeptDao) Factory.getInstance("DeptDao");
		try {
			deptDao.update(dept);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
	
	public String execute(){
		DeptDao deptDao=(DeptDao) Factory.getInstance("DeptDao");
		try {
			
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
	
}








