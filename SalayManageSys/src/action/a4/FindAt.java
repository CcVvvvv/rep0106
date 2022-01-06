package action.a4;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import util.Factory;
import dao.AttendenceDao;

import entity.Attendence;


public class FindAt {
	//input 
			private int page = 1;//当前显示的页数
			//output
			private int totalPages;//总页数
			private List<Attendence> attendences;
			//injection
			private int pageSize = 20;
			private String dept = "";
			private String  month = "";
			private String year = "";
		
			public int getPage() {
				return page;
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
		
			
			public String getDept() {
				return dept;
			}
			public void setDept(String dept) {
				this.dept = dept;
			}
			public List<Attendence> getAttendences() {
				return attendences;
			}
			public void setAttendences(List<Attendence> attendences) {
				this.attendences = attendences;
			}
			public int getPageSize() {
				return pageSize;
			}
			public void setPageSize(int pageSize) {
				this.pageSize = pageSize;
			}
			
		
			public String getMonth() {
				return month;
			}
			public void setMonth(String month) {
				this.month = month;
			}
			public String getYear() {
				return year;
			}
			public void setYear(String year) {
				this.year = year;
			}
			public String showlist(){
				AttendenceDao  attendenceDao = (AttendenceDao) Factory.getInstance("AttendenceDao");
				try {
		
					attendences = attendenceDao.findAll(page,pageSize,year,month);
					
					//计算总页数
					totalPages = attendenceDao.countTotalPage(pageSize);
				    
					return "success";
				} catch (Exception e) {
					e.printStackTrace();
					return "error";
				}
			}
			public String showlist1(){
				AttendenceDao  attendenceDao = (AttendenceDao) Factory.getInstance("AttendenceDao");
				try {
					
					attendences = attendenceDao.findAllDYM(dept,year,month);
					
					//计算总页数
					totalPages = attendenceDao.countTotalPage(pageSize);
					
					return "success";
				} catch (Exception e) {
					e.printStackTrace();
					return "error";
				}
			}
}
