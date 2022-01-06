package action.a4;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import util.Factory;
import dao.DeptDao;
import dao.SalaryDao;
import entity.Dept;
import entity.Salary;

public class SalaryListAction {
	//input 
			private int page = 1;//当前显示的页数
			//output
			private int totalPages;//总页数
			private List<Salary> salarys;
			//injection
			private int pageSize = 3;
			private String dept = "";			
			private String  year = "";
		
			private List monthList;
			public int getPage() {
				return page;
			}
			
			public String getDept() {
				return dept;
			}

			public void setDept(String dept) {
				this.dept = dept;
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
		
			public List<Salary> getSalarys() {
				return salarys;
			}
			public void setSalarys(List<Salary> salarys) {
				this.salarys = salarys;
			}
			public int getPageSize() {
				return pageSize;
			}
			public void setPageSize(int pageSize) {
				this.pageSize = pageSize;
			}
			
		
			public String getYear() {
				return year;
			}
			public void setYear(String year) {
				this.year = year;
			}
			public List getMonthList() {
				return monthList;
			}
			public void setMonthList(List monthList) {
				this.monthList = monthList;
			}
			public String showlist(){
				SalaryDao salaryDao = (SalaryDao) Factory.getInstance("SalaryDao");
				try {
				
					salarys = salaryDao.findAllYear(year);
					
					totalPages = salaryDao.countTotalPage(pageSize);
					return "success";
				} catch (Exception e) {
					e.printStackTrace();
					return "error";
				}
			}
			public String showlistDY(){
				SalaryDao salaryDao = (SalaryDao) Factory.getInstance("SalaryDao");
				try {
					
					salarys = salaryDao.findAllYear(dept,year);
					
					totalPages = salaryDao.countTotalPage(pageSize);
					return "success";
				} catch (Exception e) {
					e.printStackTrace();
					return "error";
				}
			}
}
