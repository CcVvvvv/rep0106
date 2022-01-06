package dao;

import java.util.List;

import entity.Attendence;
import entity.AttendenceSet;



public interface AttendenceDao {
	
	public int countTotalPage(int pageSize) throws Exception;
	public void save(Attendence attendence)throws Exception;
	public Attendence findById(String id)throws Exception;
	public void update(Attendence attendence)throws Exception;
	public void deleteById(String id)throws Exception;
	
	public List<Attendence> showAttendence() throws Exception;
	
	public AttendenceSet findAttendenceSet()throws Exception;
	public void updateSet(AttendenceSet attendenceSet)throws Exception;
	public void updateSetYeji(AttendenceSet attendenceSet)throws Exception;
	
	
	public List<Attendence> findAll(int page,int pageSize,String year,String month)throws Exception;
	public List<Attendence> findAllInf(int page,int pageSize,String dept,String year,String month)throws Exception;
	public List<Attendence> generateByMonth(int page, int pageSize,String year,String month) throws Exception;
	public boolean checkMonth(String year,String month)throws Exception;
	public List<Attendence> findAttendence(Attendence attendence)throws Exception;
	public AttendenceSet findAttendenceSetYeji() throws Exception;
	public void updateSetInf(AttendenceSet attendenceSet) throws Exception;
	public List<Attendence> findAll1(int page, int pageSize, String year,
			String month) throws Exception;
	public void update1(Attendence attendence) throws Exception;
	public List<Attendence> findAllDYM(String dept, String year, String month) throws Exception;
	public void update2(Attendence attendence) throws Exception;
	public Attendence findByIdInf(String aid) throws Exception;
	public void updateInf(Attendence attendence)  throws Exception;
	public void deleteByIdInf(String aid)throws Exception;
	public List<Attendence> findAllYM(String year, String month) throws Exception;
}
