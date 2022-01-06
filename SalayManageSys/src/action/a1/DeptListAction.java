package action.a1;

import java.util.List;

import util.Factory;

import dao.DeptDao;


import entity.Dept;


public class DeptListAction {
	//input 
		private int page = 1;//当前显示的页数
		//output
		private int totalPages;//总页数
		private List<Dept> depts;
		//injection
		private int pageSize = 20;
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
		public List<Dept> getDepts() {
			return depts;
		}
		public void setDepts(List<Dept> depts) {
			this.depts = depts;
		}
		public int getPageSize() {
			return pageSize;
		}
		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}
		public String showlist(){
			DeptDao deptDao = (DeptDao) Factory.getInstance("DeptDao");
			try {
				//获取当前页需要的记录
				depts = deptDao.findAll(page,pageSize);
				
				//计算总页数
				totalPages = deptDao.countTotalPage(pageSize);
				return "success";
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
		}
}
