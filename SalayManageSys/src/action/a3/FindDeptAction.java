package action.a3;

import java.util.List;

import util.Factory;
import dao.DeptDao;

import entity.Dept;

public class FindDeptAction {

	private String name;
	private String manager;
	private List<Dept> depts;

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}
	
	
	public List<Dept> getDepts() {
		return depts;
	}

	public void setDepts(List<Dept> depts) {
		this.depts = depts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String findDept(){
		DeptDao deptDao=(DeptDao) Factory.getInstance("DeptDao");
		try {
			depts=deptDao.findDept(name, manager);
			return "find";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
}
