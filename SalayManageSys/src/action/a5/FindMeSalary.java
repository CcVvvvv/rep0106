package action.a5;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;



import action.BaseAction;
import util.Factory;
import dao.DeptDao;
import dao.SalaryDao;
import dao.UserDao;
import entity.Dept;
import entity.Salary;
import entity.User;

public class FindMeSalary extends BaseAction {
			private User user;
			private int page = 1;//��ǰ��ʾ��ҳ��
			//output
			private int totalPages;//��ҳ��
			private Salary salary;
			//injection
			private int pageSize = 10;
			private String struename ="";
			private String uid ="";
			private String year = "";
			private String month = "";
			private List monthList;
			public int getPage() {
				return page;
			}
			
			
			public String getStruename() {
				return struename;
			}


			public void setStruename(String struename) {
				this.struename = struename;
			}


			public String getUid() {
				return uid;
			}


			public void setUid(String uid) {
				this.uid = uid;
			}


			public void setPage(int page) {
				this.page = page;
			}
			public int getTotalPages() {
				return totalPages;
			}
			public void setTotalPages(int totalPages) {
				this.totalPages = totalPages;
			}
		
		
			public Salary getSalary() {
				return salary;
			}
			public void setSalary(Salary salary) {
				this.salary = salary;
			}
			public int getPageSize() {
				return pageSize;
			}
			public void setPageSize(int pageSize) {
				this.pageSize = pageSize;
			}
			
			
		
			public List getMonthList() {
				return monthList;
			}
			public void setMonthList(List monthList) {
				this.monthList = monthList;
			}
			
			
			public User getUser() {
				return user;
			}
			public void setUser(User user) {
				this.user = user;
			}
			public String getYear() {
				return year;
			}
			public void setYear(String year) {
				this.year = year;
			}
			public String getMonth() {
				return month;
			}
			public void setMonth(String month) {
				this.month = month;
			}
			public String showlist(){
				SalaryDao salaryDao = (SalaryDao) Factory.getInstance("SalaryDao");
				try {
					
					String id = (String) session.get("userInfo");
					salary = salaryDao.findByIYM(id,year,month);
				//	salary = salaryDao.findById(id);
				//	salary = salaryDao.findAll(page,pageSize,year,month);
					
					//������ҳ��
					totalPages = salaryDao.countTotalPage(pageSize);
					return "success";
				} catch (Exception e) {
					e.printStackTrace();
					return "error";
				}
			}
}




