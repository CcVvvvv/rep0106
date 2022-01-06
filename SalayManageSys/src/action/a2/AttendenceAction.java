package action.a2;

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
			return "list";
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
	public String loadatt(){
		AttendenceDao attendenceDao=(AttendenceDao) Factory.getInstance("AttendenceDao");
		try {
			attendence=attendenceDao.findById(attendence.getAid());
			return "loadatt";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	public String load1(){
		AttendenceDao attendenceDao=(AttendenceDao) Factory.getInstance("AttendenceDao");
		try {
			attendence=attendenceDao.findById(attendence.getAid());
			return "load1";
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
			return "list";
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
	public String update1(){
		AttendenceDao attendenceDao=(AttendenceDao) Factory.getInstance("AttendenceDao");
		try {
			attendenceDao.update1(attendence);
			return "list";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	public String update2(){
		AttendenceDao attendenceDao=(AttendenceDao) Factory.getInstance("AttendenceDao");
		try {
			attendenceDao.update2(attendence);
			return "list";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
}
