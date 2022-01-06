package action.a2;

import action.BaseAction;
import util.Factory;
import dao.AttendenceDao;
import dao.DeptDao;
import entity.AttendenceSet;

public class AttendenceSetAction extends BaseAction{
	private AttendenceSet attendenceSet;

	public AttendenceSet getAttendenceSet() {
		return attendenceSet;
	}

	public void setAttendenceSet(AttendenceSet attendenceSet) {
		this.attendenceSet = attendenceSet;
	}
	
	public String load(){
		AttendenceDao attendenceDao=(AttendenceDao) Factory.getInstance("AttendenceDao");
		try {
			attendenceSet=attendenceDao.findAttendenceSet();
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
	
	
	public String updateSetInf(){
		AttendenceDao attendenceDao=(AttendenceDao) Factory.getInstance("AttendenceDao");
		try {
			attendenceDao.updateSetYeji(attendenceSet);
			request.put("messageInf", "修改成功");
			return "messageInf";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
	public String updateSet(){
		AttendenceDao attendenceDao=(AttendenceDao) Factory.getInstance("AttendenceDao");
		try {
			attendenceDao.updateSet(attendenceSet);
			request.put("message", "修改成功");
			return "message";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	public String updateSetYeji(){
		AttendenceDao attendenceDao=(AttendenceDao) Factory.getInstance("AttendenceDao");
		try {
			attendenceDao.updateSet(attendenceSet);
			request.put("message", "修改成功");
			return "message";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
}
