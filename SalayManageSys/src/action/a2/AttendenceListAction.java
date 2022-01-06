package action.a2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import util.Factory;
import dao.AttendenceDao;

import entity.Attendence;


public class AttendenceListAction {
	//input 
			private int page = 1;//当前显示的页数
			//output
			private int totalPages;//总页数
			private List<Attendence> attendences;
			//injection
			private int pageSize = 20;
		//	private Integer month;
			private String year;
			private String month;
			private List monthList;
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
			
			
			
			public List getMonthList() {
				return monthList;
			}
			public void setMonthList(List monthList) {
				this.monthList = monthList;
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
				AttendenceDao  attendenceDao = (AttendenceDao) Factory.getInstance("AttendenceDao");
				try {
					//获取当前页需要的记录
					Calendar c = Calendar.getInstance();
					
//					month = c.get(Calendar.MONTH) + 1;
//					monthList =new ArrayList();
//					for(int i=1;i<=12;i++){
//						monthList.add(i);
//					}
//					
//					String m=month.toString();
//					year = c.get(Calendar.YEAR);
//					String y=year.toString();
					attendences = attendenceDao.findAll(page,pageSize,year,month);
					
					//计算总页数
					totalPages = attendenceDao.countTotalPage(pageSize);
				    
					return "success";
				} catch (Exception e) {
					e.printStackTrace();
					return "error";
				}
			}
}
