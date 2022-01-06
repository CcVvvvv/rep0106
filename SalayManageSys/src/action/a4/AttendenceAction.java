package action.a4;

import util.Factory;
import dao.AttendenceDao;
import entity.Attendence;


public class AttendenceAction {
	private Attendence attendence;

	public Attendence getAttendence() {
		return attendence;
	}
	public void setAttendence(Attendence attendence) {
		this.attendence = attendence;
	}
	public String add(){
		AttendenceDao attendenceDao=(AttendenceDao) Factory.getInstance("AttendenceDao");
		try {
			attendenceDao.save(attendence);
			return "add";
			} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}
	public String load(){
		AttendenceDao attendenceDao=(AttendenceDao) Factory.getInstance("AttendenceDao");
		try {
			attendence=attendenceDao.findById(attendence.getAid());
			return "update";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	public String loadInf(){
		AttendenceDao attendenceDao=(AttendenceDao) Factory.getInstance("AttendenceDao");
		try {
			attendence=attendenceDao.findByIdInf(attendence.getAid());
			return "update";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
	public String delete(){
		AttendenceDao attendenceDao=(AttendenceDao) Factory.getInstance("AttendenceDao");
		try {
			attendenceDao.deleteById(attendence.getAid());
			return "delete";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	public String deleteInf(){
		AttendenceDao attendenceDao=(AttendenceDao) Factory.getInstance("AttendenceDao");
		try {
			attendenceDao.deleteByIdInf(attendence.getAid());
			return "delete";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
	public String update(){
		AttendenceDao attendenceDao=(AttendenceDao) Factory.getInstance("AttendenceDao");
		try {
			attendenceDao.update(attendence);
			return "list";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	public String updateInf(){
		AttendenceDao attendenceDao=(AttendenceDao) Factory.getInstance("AttendenceDao");
		try {
			attendenceDao.updateInf(attendence);
			return "list";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
}
