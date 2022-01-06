package dao;

import java.util.List;

import entity.AskForLeave;


public interface AskForLeaveDao {
	public List<AskForLeave> findAllInf(int page, int pageSize,String dept,String year,String month) throws Exception;
}
