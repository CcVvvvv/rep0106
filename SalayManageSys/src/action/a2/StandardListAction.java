package action.a2;

import java.util.List;

import dao.SalaryDao;
import dao.SalaryStandardDao;
import util.Factory;


import entity.Salary;
import entity.SalaryStandard;

public class StandardListAction {
	private int page = 1;//当前显示的页数
	//output
	private int totalPages;//总页数
	private SalaryStandard salaryStandard;
	private int pageSize = 30;
	private String zhiwei ="";
	private String year ="";

	private List<SalaryStandard> salaryStandards;

	public List<SalaryStandard> getSalaryStandards() {
		return salaryStandards;
	}

	public void setSalaryStandards(List<SalaryStandard> salaryStandards) {
		this.salaryStandards = salaryStandards;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getZhiwei() {
		return zhiwei;
	}

	public void setZhiwei(String zhiwei) {
		this.zhiwei = zhiwei;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public SalaryStandard getSalaryStandard() {
		return salaryStandard;
	}

	public void setSalaryStandard(SalaryStandard salaryStandard) {
		this.salaryStandard = salaryStandard;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String add()
	{
		SalaryStandardDao salaryStandardDao = (SalaryStandardDao) Factory.getInstance("SalaryStandardDao");
		try {
			salaryStandardDao.save(salaryStandard);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	public String execute(){
		SalaryDao salaryDao = (SalaryDao) Factory.getInstance("SalaryDao");
		try {
			//获取当前页需要的记录
	//		salaryStandards = salaryDao.findStandAll(page, pageSize);
			salaryStandards = salaryDao.findStandAllZhiwei(zhiwei);
		
//			totalPages = salaryDao.countTotalPage(pageSize);
			totalPages=1;
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	public String showlist(){
		SalaryDao salaryDao = (SalaryDao) Factory.getInstance("SalaryDao");
		try {
			//获取当前页需要的记录
			//		salaryStandards = salaryDao.findStandAll(page, pageSize);
			salaryStandards = salaryDao.findStandAllZhiwei(year);
			
//			totalPages = salaryDao.countTotalPage(pageSize);
			totalPages=1;
			return "showlist";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
}




