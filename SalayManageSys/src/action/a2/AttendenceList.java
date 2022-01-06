package action.a2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;



import util.Factory;
import dao.AttendenceDao;
import dao.JdbcAskForLeaveDao;
import dao.JdbcWorkOverTimeDao;
import dao.UserDao;
import dao.WorkOverTimeDao;
import entity.AskForLeave;
import entity.Attendence;
import entity.WorkOverTime;


public class AttendenceList {
	//input 
			private int page = 1;//��ǰ��ʾ��ҳ��
			//output
			private int totalPages;//��ҳ��
			private List<AskForLeave> askForLeaves;
			private List<WorkOverTime> workovertimes;
			//injection
			private int pageSize =20;
			private String year="";
			private String month="";
			private String dept="";

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
		
		
			public List<WorkOverTime> getWorkovertimes() {
				return workovertimes;
			}
			public void setWorkovertimes(List<WorkOverTime> workovertimes) {
				this.workovertimes = workovertimes;
			}
			public List<AskForLeave> getAskForLeaves() {
				return askForLeaves;
			}
			public void setAskForLeaves(List<AskForLeave> askForLeaves) {
				this.askForLeaves = askForLeaves;
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
			public String getMonth() {
				return month;
			}
			public void setMonth(String month) {
				this.month = month;
			}
			
			
			public String getDept() {
				return dept;
			}
			public void setDept(String dept) {
				this.dept = dept;
			}
			public String showlist(){
//				AttendenceDao  attendenceDao = (AttendenceDao) Factory.getInstance("AttendenceDao");
				JdbcAskForLeaveDao askForLeaveDao=new JdbcAskForLeaveDao();
				JdbcWorkOverTimeDao workOverTimeDao=new JdbcWorkOverTimeDao();
				
				try {
					//��ȡ��ǰҳ��Ҫ�ļ�¼
//					Calendar c = Calendar.getInstance();
					askForLeaves=askForLeaveDao.findAllInf(page, pageSize, dept, year, month);
				//	workovertimes=workOverTimeDao.findAllInf(page, pageSize, dept, year, month);
					
			/*		for(int i=0;i<askForLeaves.size();i++)
					{
						for(int j=0;j<workovertimes.size();j++)
						if(askForLeaves.get(i).getUid()==workovertimes.get(j).getUid())
						{
							int pay=0;
							int deduction = Integer.getInteger(askForLeaves.get(i).getDeduction());
							int jiangjin = Integer.getInteger(workovertimes.get(j).getJiangjin());
							pay=30*50-Integer.getInteger(askForLeaves.get(i).getDay())*deduction+
									Integer.getInteger(workovertimes.get(j).getDay())*jiangjin;
							askForLeaves.get(i).setGongzi(String.valueOf(pay));
						}
					}*/
					return "success";
				} catch (Exception e) {
					e.printStackTrace();
					return "error";
				}
			}
}
